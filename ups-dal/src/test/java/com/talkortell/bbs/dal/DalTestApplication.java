package com.talkortell.bbs.dal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.talkortell.bbs.utils.SpringContextUtil;

@Configuration
@ComponentScan({"com.talkortell.bbs"})
@EnableConfigurationProperties
@Import(SpringContextUtil.class)
public class DalTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(DalTestApplication.class, args);
	}
}
