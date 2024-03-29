package com.keysoft.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.keysoft.")
@EnableTransactionManagement
public class SpringConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/storemanagement");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.keysoft.entity");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialec", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate.show_sql", true);
		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager1 = new HibernateTransactionManager();
		hibernateTransactionManager1.setSessionFactory(sessionFactory);
		return hibernateTransactionManager1;

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	// TILES CONFIGURATION
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("classpath:tiles.xml");
		configurer.setCheckRefresh(true);
		return configurer;
	}

	@Bean
	public ViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		// public ViewResolver viewResolver() {
		// InternalResourceViewResolver viewResolver = new
		// InternalResourceViewResolver();
		// viewResolver.setViewClass(JstlView.class);
		// viewResolver.setPrefix("/WEB-INF/views/");
		// viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	// ---------------------------------------------
}
