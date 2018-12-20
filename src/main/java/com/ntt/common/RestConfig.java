package com.ntt.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.ntt.department.DeptRecords;
import com.ntt.employee.EmpRecords;
import com.ntt.employee.EmpRecords2;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
  
    @Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.getProjectionConfiguration().addProjection(EmpRecords.class);
        repositoryRestConfiguration.getProjectionConfiguration().addProjection(DeptRecords.class);
        repositoryRestConfiguration.getProjectionConfiguration().addProjection(EmpRecords2.class);
    }
}
