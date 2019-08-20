package com.talkortell.bbs.web;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import com.google.common.collect.Lists;
import com.talkortell.bbs.base.utils.SpringContextUtil;

@SpringBootApplication(exclude=PageHelperAutoConfiguration.class)
@ComponentScan({"com.talkortell.bbs"})
@Import(SpringContextUtil.class)
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.talkortell.bbs.reference.feign"})
public class UpsWebApplication {
	
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.SkipTransientField, 
				SerializerFeature.WriteDateUseDateFormat, 
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue, 
				SerializerFeature.WriteNullListAsEmpty, 
				SerializerFeature.WriteNullNumberAsZero, 
				SerializerFeature.WriteNullBooleanAsFalse);
		List<MediaType> fastmedisTypes = Lists.newArrayList();
		fastmedisTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastmedisTypes);
		
		fastConverter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters(fastConverter);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UpsWebApplication.class, args);
	}
}
