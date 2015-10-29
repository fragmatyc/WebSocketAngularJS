package com.javacodegeeks.examples.realtimeapp.part3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.javacodegeeks.examples.realtimeapp.part3")
public class TaskAppConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/**").addResourceLocations("/");
	}

}
