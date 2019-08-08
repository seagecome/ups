package com.talkortell.bbs.dal.config.master;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(value="tk.mybatis.mapper.annotation", 
	properties= {"mappers=tk.mybatis.mapper.common.Mapper", "notEmpty=true", "identity=MYSQL"},
	basePackages=MasterUpsDataSourceConfig.BASEPACKAGES,
	sqlSessionFactoryRef="masterSqlSessionFactory")
public class MasterUpsDataSourceConfig {
	protected static final String BASEPACKAGES = "com.talkortell.bbs.dal.dao.master";
	protected static final String MAPPER_LOCATION = "classpath:mappings/ups/master/*.xml";

	@Value("${spring.datasource.ups.master.url}")
	private String url;
	@Value("${spring.datasource.ups.master.username}")
	private String userName;
	@Value("${spring.datasource.ups.master.password}")
	private String password;
	@Value("${spring.datasource.ups.master.driver-class-name}")
	private String driverClass;
	
	@Bean(name="masterDataSource")
	public DataSource masterDataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	
	@Bean(name="masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager(){
		return new DataSourceTransactionManager(masterDataSource());
	}
	
	@Bean(name="masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource")DataSource masterDataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        	.getResources(MasterUpsDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
	}
}
