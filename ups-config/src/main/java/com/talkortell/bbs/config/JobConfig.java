package com.talkortell.bbs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource("classpath:job.properties")
@Getter
public class JobConfig {
	@Value("${xxl.job.admin.address}")
	private String adminAddress;
	
	@Value("${xxl.job.executor.appName}")
	private String appName;
	
	@Value("${xxl.job.executor.ip}")
	private String ip;
	
	@Value("${xxl.job.executor.port}")
	private int port;
	
	@Value("${xxl.job.accessToken}")
	private String accessToken;
	
	@Value("${xxl.job.executor.logPath}")
	private String logPath;
	
	@Value("${xxl.job.executor.logRetentionDays}")
	private int logRetentionDays;
}
