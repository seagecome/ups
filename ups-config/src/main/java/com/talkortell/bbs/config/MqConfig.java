package com.talkortell.bbs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource("classpath:rabbitmq.properties")
@Getter
public class MqConfig {
	@Value("${rabbitmq.host}")
	private String host;
	
	@Value("${rabbitmq.port}")
	private Integer port;

	@Value("${rabbitmq.password}")
	private String password;
	
	@Value("${rabbitmq.username}")
	private String username;
	
	@Value("${rabbitmq.publisherConfirms}")
	private Boolean publisherConfirms;
	
	@Value("${rabbitmq.virtualHost}")
	private String virtualHost;
	
}
