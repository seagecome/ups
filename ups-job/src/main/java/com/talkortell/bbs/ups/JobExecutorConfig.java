package com.talkortell.bbs.ups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.talkortell.bbs.config.JobConfig;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class JobExecutorConfig {
	
	@Autowired
	private JobConfig jobConfig;
	
	@Bean(initMethod="start",destroyMethod="destroy")
	public XxlJobSpringExecutor xxlJobExecutor() {
		log.info("===ups xxlJobExecutor init===");
		XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
		xxlJobSpringExecutor.setAdminAddresses(jobConfig.getAdminAddress());
		xxlJobSpringExecutor.setAppName(jobConfig.getAppName());
		xxlJobSpringExecutor.setIp(jobConfig.getIp());
		xxlJobSpringExecutor.setPort(jobConfig.getPort());
		xxlJobSpringExecutor.setAccessToken(jobConfig.getAccessToken());
		xxlJobSpringExecutor.setLogPath(jobConfig.getLogPath());
		xxlJobSpringExecutor.setLogRetentionDays(jobConfig.getLogRetentionDays());
		return xxlJobSpringExecutor;
	}
}
