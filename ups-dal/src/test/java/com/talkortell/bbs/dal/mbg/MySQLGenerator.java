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
				
				if(!StringUtils.isBlank(fileContent)) {
					changeGenFileContent(callback, file, fileContent);
				}
			});
			
			myBatisGenerator.getGeneratedXmlFiles().forEach(file ->{
				if(StringUtils.contains(file.getFormattedContent(), "Example")) {
					String fileContent = this.renameExample(file.getFormattedContent());
					changeGenFileContent(callback, file, fileContent);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
