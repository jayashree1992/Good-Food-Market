package com.neu.edu.webtools.project.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.neu.edu.webtools.project.backend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

//	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/goodfood?serverTimezone=UTC";
//	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
//	private final static String DATABASE_USERNAME = "root";
//	private final static String DATABASE_PASSWORD = "root1234";
	
	
	private final static String DATABASE_URL = "jdbc:postgresql://ec2-52-71-231-180.compute-1.amazonaws.com:5432/d34kakqvt1uoe";
	private final static String DATABASE_DRIVER = "org.postgresql.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private final static String DATABASE_USERNAME = "ikjqogisescfso";
	private final static String DATABASE_PASSWORD = "3d23f54e08ab0c0f88f97673d9facb1849321d20d1c32048e6a641fc3475f4ed";
	

	@Bean("dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.neu.edu.webtools.project.backend.dto");

		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);

		properties.put("hibernate.show_sql", "true");

		properties.put("hibernate.format_sql", "true");

		properties.put("hibernate.hbm2ddl.auto", "create");

		return properties;

	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
