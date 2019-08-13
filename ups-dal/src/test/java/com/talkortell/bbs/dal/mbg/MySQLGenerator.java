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

import tk.mybatis.mapper.annotation.ColumnType;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DalTestApplication.class)
public class MySQLGenerator extends BaseGenerator {
	
	private static final String NEEDENCRYPT="private String loginPassword;";
	private static final String ENCRYPTPREFIX="@ColumnType(typeHandler=com.talkortell.bbs.base.common.db.EncryptTypeHandler.class)";
	private static final String STAYPACKAGE="package com.talkortell.bbs.domain.mysql.ups;";
	private static final String IMPORTCONTENT="import tk.mybatis.mapper.annotation.ColumnType;";
	private static final String XMLREPLACESTR="property=\"loginPassword\"";
	private static final String XMLREPLACESUFFIX=" typeHandler=\"com.talkortell.bbs.base.common.db.EncryptTypeHandler\"";
	private static final String XMLELEMENTSTR="loginPassword,jdbcType=VARCHAR";
	private static final String XMLELEMENTSUFFIX=",typeHandler=com.talkortell.bbs.base.common.db.EncryptTypeHandler";
	
	@Test
	public void masterGen() {
		this.run("generatorMySQLConfig.xml");
	}
	@Test
	public void slaveGen() {
		this.run("generatorMySQLConfigSlave.xml");
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
				
				if(StringUtils.contains(file.getFormattedContent(), NEEDENCRYPT)) {
					fileContent = StringUtils.isBlank(fileContent) ? file.getFormattedContent() : fileContent;
					fileContent = fileContent.replace(NEEDENCRYPT, ENCRYPTPREFIX + "\n    " + NEEDENCRYPT);
					fileContent = fileContent.replace(STAYPACKAGE, STAYPACKAGE + "\n\n" + IMPORTCONTENT);
				}
				
				if(!StringUtils.isBlank(fileContent)) {
					changeGenFileContent(callback, file, fileContent);
				}
			});
			
			myBatisGenerator.getGeneratedXmlFiles().forEach(file ->{
				String fileContent = StringUtils.EMPTY;
				
				if(StringUtils.contains(file.getFormattedContent(), "Example")) {
					fileContent = this.renameExample(file.getFormattedContent());
				}
				
				if(StringUtils.contains(file.getFormattedContent(), XMLREPLACESTR)) {
					fileContent = StringUtils.isBlank(fileContent) ? file.getFormattedContent() : fileContent;
					fileContent = fileContent.replace(XMLREPLACESTR, XMLREPLACESTR + XMLREPLACESUFFIX);
					fileContent = fileContent.replace(XMLELEMENTSTR, XMLELEMENTSTR + XMLELEMENTSUFFIX);
				}
				
				if(!StringUtils.isBlank(fileContent)) {
					changeGenFileContent(callback, file, fileContent);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
