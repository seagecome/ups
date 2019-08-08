package com.talkortell.bbs.dal.config.slave;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages=SlaveUpsDataSourceConfig.BASEPACKAGES,sqlSessionFactoryRef="slaveSqlSessionFactory")
public class SlaveUpsDataSourceConfig {
	protected static final String BASEPACKAGES = "com.talkortell.bbs.dal.dao.slave";
	protected static final String MAPPER_LOCATION = "classpath:mappings/ups/slave/*.xml";

	@Value("${spring.datasource.ups.master.url}")
	private String url;
	@Value("${spring.datasource.ups.master.username}")
	private String userName;
	@Value("${spring.datasource.ups.master.password}")
	private String password;
	@Value("${spring.datasource.ups.master.driver-class-name}")
	private String driverClass;
	
	@Bean(name="slaveDataSource")
	public DataSource slaveDataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	
	@Bean(name="slaveTransactionManager")
	@Primary
	public DataSourceTransactionManager slaveTransactionManager(){
		return new DataSourceTransactionManager(slaveDataSource());
	}
	
	@Bean(name="slaveSqlSessionFactory")
	@Primary
	public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource")DataSource slaveDataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(slaveDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        	.getResources(SlaveUpsDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
	}
}
