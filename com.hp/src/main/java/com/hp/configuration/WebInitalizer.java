package com.hp.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitalizer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfiguration.class);
		ctx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));	
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	CharacterEncodingFilter characterEncodingFilter= new CharacterEncodingFilter("UTF-8", true);
	container.addFilter("encodingFilter", characterEncodingFilter)
	.addMappingForUrlPatterns(null, false, "/*");
	}
	

}
