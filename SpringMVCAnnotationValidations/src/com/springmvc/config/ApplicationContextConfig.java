package com.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.dao.StudentDAO;

//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@ComponentScan("com.springmvc.*")
//@EnableTransactionManagement
// Load to Environment.
@PropertySources({ @PropertySource("WEB-INF/LocalProperties/mysqldbconfig.properties") })
public class ApplicationContextConfig {

	// The Environment class serves as the property holder
	// and stores all the properties loaded by the @PropertySource
	@Autowired
	private Environment envi;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("WEB-INF/JSPPages/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(envi.getProperty("jdbc.className"));
		dataSource.setUrl(envi.getProperty("jdbc.url"));
		dataSource.setUsername(envi.getProperty("jdbc.userName"));
		dataSource.setPassword(envi.getProperty("jdbc.password"));

		/*
		 * // See: datasouce-cfg.properties
		 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 * dataSource.setUrl("jdbc:mysql://den1.mysql6.gear.host:3306/practisemysqldb");
		 * dataSource.setUsername("practisemysqldb");
		 * dataSource.setPassword("my$ql123");
		 */

		System.out.println("## getDataSource: " + dataSource);

		return dataSource;
	}

//	@Bean(name = "transactionManager")
//	public DataSourceTransactionManager getTransactionManager() {
//		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
//
//		DataSource dataSource = this.getDataSource();
//		txManager.setDataSource(dataSource);
//
//		return txManager;
//	}

	@Bean
	public StudentDAO studentDAO() {
		return new StudentDAO(getDataSource());
	}
}
