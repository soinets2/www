package com.imaeil.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@MapperScan(basePackages = {"com.imaeil.mapper"})
@ComponentScan(basePackages = {"com.imaeil.services.**"})
@PropertySource("classpath:/properties/globals.properties")
@Configuration
public class RootConfig {
	@Resource(name="databaseConfig")
	private DatabaseConfig dbConfig;
	
	/* DatabaseConfig */
	@Bean
	public DatabaseConfig databaseConfig() {
		return new DatabaseConfig();
	}
	
	/* DataSource */
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(dbConfig.getDrivername());
		hikariConfig.setJdbcUrl(dbConfig.getUrl());
		hikariConfig.setUsername(dbConfig.getUsername());
		hikariConfig.setPassword(dbConfig.getPassword());
		//hikariConfig.setMaximumPoolSize(Integer.parseInt(dbConfig.getPoolsize()));
		//hikariConfig.setLeakDetectionThreshold(Integer.parseInt(dbConfig.getDetectionthreshold()));
		//hikariConfig.setIdleTimeout(Integer.parseInt(dbConfig.getTimeout()));
		//hikariConfig.setPoolName(dbConfig.getPoolname());
		//hikariConfig.setConnectionTestQuery(dbConfig.getTestquery());
		//hikariConfig.setConnectionInitSql(dbConfig.getTestquery());
		
		return new HikariDataSource(hikariConfig);
	}
	
	/* SqlSessionFactory */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("/com/imaeil/sqlMap/*.xml"));
		//sqlSessionFactory.setl
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
}
