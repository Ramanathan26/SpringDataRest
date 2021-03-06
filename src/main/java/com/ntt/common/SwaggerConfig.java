package com.ntt.common;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
	
	 @Bean
	  public Docket docket() {
	    return new Docket(DocumentationType.SWAGGER_2);
	     // .tags(new Tag("Employee Entity","Repository for Employee Entities"));
	  }
}
