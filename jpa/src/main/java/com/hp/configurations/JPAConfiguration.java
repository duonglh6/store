//package com.hp.configurations;
//
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableJpaRepositories(basePackages = { "com.hp.dao" })
//@EnableTransactionManagement
//public class JPAConfiguration {
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/jpa");
//		dataSource.setUsername("root");
//		dataSource.setPassword("12345678");
//		return dataSource;
//
//	}
//
//	@Bean
//	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, Environment environment) {
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setDataSource(dataSource());
//		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		entityManagerFactoryBean.setPackagesToScan("com.hp.entity");
//
//		Properties jpaProperties = new Properties();
//
//		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		jpaProperties.put("hibernate.show_sql", true);
////		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
////		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
////		jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//		entityManagerFactoryBean.setJpaProperties(jpaProperties);
//		return entityManagerFactoryBean;
//
//	}
//
//	@Bean
//	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory);
//		return transactionManager;
//	}
//}
