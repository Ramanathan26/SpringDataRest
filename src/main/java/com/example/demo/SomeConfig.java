package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

@Configuration
public class SomeConfig {

	 @Bean
	  public SpelAwareProxyProjectionFactory projectionFactory() {
	    return new SpelAwareProxyProjectionFactory();
	  }
	
}
