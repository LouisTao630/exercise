package com.louis.exercise.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.louis.exercise.db.mybatis")
@ComponentScan(basePackages = { "com.louis.exercise.db" })
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		Properties p = new Properties();
		p.setProperty("mapUnderscoreToCamelCase", "true");
		sessionFactory.setConfigurationProperties(p);
		return sessionFactory.getObject();
	}

}
