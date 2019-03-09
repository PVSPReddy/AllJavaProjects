package com.springmvc.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
//@ComponentScan("com.springmvc.*")
@EnableWebMvc
public class WebMVCConfig extends WebMvcConfigurerAdapter {

	
//	@Bean(name="viewResolver")
//	public InternalResourceViewResolver getViewResolver()
//	{
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		
//		viewResolver.setPrefix("WEB-INF/JSPPages/");
//		viewResolver.setSuffix(".jsp");
//		
//		return viewResolver;
//	}
	
	// Static resources like Images, Css, JavaScript configurations
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

}
