package com.talkortell.bbs.dal.mbg;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;
import com.talkortell.bbs.dal.DalTestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DalTestApplication.class)
public class MySQLGenerator extends BaseGenerator {
	
	private static final String encryptFields = "loginPassword";
	private static final String selfTypeHandler = "com.talkortell.bbs.base.common.db.EncryptTypeHandler";
	
	
	@Test
	public void masterGen() {
		this.run("generatorMySQLConfig.xml");
	}
	@Test
	public void slaveGen() {
		this.run("generatorMySQLConfigSlave.xml");
	}
	
	private String javaLoopCheck(String formattedContent, String fileContent) {
		String[] targetFields = encryptFields.split(",");
		for(String encryptField : targetFields) {
			BaseElement be = new BaseElement(encryptField, selfTypeHandler);
			if(StringUtils.contains(formattedContent, be.getDomainEncryptContent())) {
				fileContent = StringUtils.isBlank(fileContent) ? formattedContent : fileContent;
				fileContent = fileContent.replace(be.getDomainEncryptContent(), be.getNewAnnotation() + "\n    " + be.getDomainEncryptContent());
			}
			if(StringUtils.contains(fileContent, be.getDomainEncryptContent()) && !StringUtils.contains(fileContent, be.getImportAnnotation())) {
				System.out.println("===wolaile===");
				fileContent = fileContent.replace(be.getDomainPackage(), be.getDomainPackage() + "\n\n" + be.getImportAnnotation());
			}
		}
		return fileContent;
	}
	
	private String xmlLoopCheck(String formattedContent, String fileContent) {
		String[] targetFields = encryptFields.split(",");
		for(String encryptField : targetFields) {
			BaseElement be = new BaseElement(encryptField, selfTypeHandler);
			if(StringUtils.contains(formattedContent, be.getXmlSourceContent())) {
				fileContent = StringUtils.isBlank(fileContent) ? formattedContent : fileContent;
				fileContent = fileContent.replace(be.getXmlSourceContent(), be.getXmlSourceContent() + be.getXmlAddContent());
				fileContent = fileContent.replace(be.getXmlDynamicSql(), be.getXmlDynamicSql() + be.getXmlDynamicAddContent());
			}
		}
		return fileContent;
	}
	
	private void run(String configName) {
		try {
			List<String> warnings = Lists.newArrayList();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
		
			Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream("generator/".concat(configName)));
			
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			
			myBatisGenerator.getGeneratedJavaFiles().forEach(file -> {
				String fileContent = StringUtils.EMPTY;
				if(StringUtils.contains(file.getFormattedContent(), "Example")) {
					fileContent = this.renameExample(file.getFormattedContent());
				}
				
				if(StringUtils.contains(file.getFormattedContent(), "@GeneratedValue") && !StringUtils.contains(file.getFormattedContent(), "@Id")) {
					fileContent = StringUtils.isBlank(fileContent) ? file.getFormattedContent() : fileContent;
					fileContent = fileContent.replace("@GeneratedValue", "@Id\n    @GeneratedValue");
				}
				
				fileContent = javaLoopCheck(file.getFormattedContent(), fileContent);
				
				if(!StringUtils.isBlank(fileContent)) {
					changeGenFileContent(callback, file, fileContent);
				}
			});
			
			myBatisGenerator.getGeneratedXmlFiles().forEach(file ->{
				String fileContent = StringUtils.EMPTY;
				
				if(StringUtils.contains(file.getFormattedContent(), "Example")) {
					fileContent = this.renameExample(file.getFormattedContent());
				}
				
				fileContent = xmlLoopCheck(file.getFormattedContent(), fileContent);
				
				if(!StringUtils.isBlank(fileContent)) {
					changeGenFileContent(callback, file, fileContent);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
