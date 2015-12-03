package com.globallogic.mqtt.poc.configuration;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.globallogic.mqtt.poc.utility.LoggingReqResFilter;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.globallogic.mqtt.poc"})
@EnableCaching
public class Application extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	@Bean
	public Filter hiddenHttpMethodFilter() {
		LoggingReqResFilter filter = new LoggingReqResFilter();
	   return filter;
	}
}
