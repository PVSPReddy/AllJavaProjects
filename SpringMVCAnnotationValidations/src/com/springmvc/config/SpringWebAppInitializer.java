package com.springmvc.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.ContextLoaderListener;

public class SpringWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);
		//appContext.register(WebMVCConfig.class);

		// DispatcherServlet
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setInitParameter("contextClass", appContext.getClass().getName());

		servletContext.addListener(new ContextLoaderListener(appContext));

		// Filter
		// UTF-8 Character Filter
		FilterRegistration.Dynamic utfFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		utfFilter.setInitParameter("encoding", "UTF-8");
		utfFilter.setInitParameter("forceEncoding", "true");
		utfFilter.addMappingForUrlPatterns(null, true, "/*");

	}

}
