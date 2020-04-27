package com.stackroute.spring.mvc.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.spring.mvc.entity.Employee;


@Configuration
@EnableTransactionManagement
public class AppConfig {
	
	//bean definitions
	
	//DataSource
	//Configuration of database properties 
	//helps to connect to db 
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/testempdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	//SessionFactory
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		Properties properties = new Properties();
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		//none -> no action will taken
		//validate -> it just validates the schema definition but doesn't execute DDL
		//create  -> drop the existing schema ( tables ) will recreate the database schema again
		//		  -> it will be done everytime the SessionFactory is created ( not to be used in production)
		//update  -> update the schema ( developement /testing )
		//create-drop -> works like create and drops the schema when the sessionFactory is closed programmaticaly
		//Database schema ( DDL )
		
		//Dialect ( SQL )
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		//show SQL Queries
		properties.put("hibernate.show_sql", "true");
		sessionFactoryBean.setAnnotatedClasses(new Class<?>[] {Employee.class});
		//sessionFactoryBean.setAnnotatedPackages(annotatedPackages);
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.afterPropertiesSet();
	
		
		return sessionFactoryBean;
	}
	//TransactionManager
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

}
