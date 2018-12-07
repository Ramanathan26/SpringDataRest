package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
  
    @Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.getProjectionConfiguration().addProjection(EmpRecords.class);
        repositoryRestConfiguration.getProjectionConfiguration().addProjection(DeptRecords.class);
    }
}
