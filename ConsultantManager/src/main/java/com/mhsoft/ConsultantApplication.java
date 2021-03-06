package com.mhsoft;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ConsultantApplication extends SpringBootServletInitializer{

	 @Bean
	 public HttpSessionListener httpSessionListener(){
	   return new SessionListener();

	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ConsultantApplication.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsultantApplication.class, args);
	}

}
