package com.talkortell.bbs.dal.config.slave;

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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(value="tk.mybatis.mapper.annotation", 
	properties= {"mappers=tk.mybatis.mapper.common.Mapper", "notEmpty=true", "identity=MYSQL"},
	basePackages=SlaveUpsDataSourceConfig.BASEPACKAGES,
	sqlSessionFactoryRef="masterSqlSessionFactory")
@EnableTransactionManagement
public class SlaveUpsDataSourceConfig {
	protected static final String BASEPACKAGES = "com.talkortell.bbs.dal.dao.ups.mysql.slave";
	protected static final String MAPPER_LOCATION = "classpath:mappings/ups/slave/*.xml";
	protected static final String DATA_SOURCE = "slaveDataSource";
	public static final String TRANS_MANAGER = "slaveTransactionManager";
	protected static final String SESSION_FACTORY = "slaveSqlSessionFactory";

	@Value("${spring.datasource.ups.slave.url}")
	private String url;
	@Value("${spring.datasource.ups.slave.username}")
	private String userName;
	@Value("${spring.datasource.ups.slave.password}")
	private String password;
	@Value("${spring.datasource.ups.slave.driver-class-name}")
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
