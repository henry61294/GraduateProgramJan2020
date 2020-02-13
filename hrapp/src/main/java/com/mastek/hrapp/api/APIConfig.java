package com.mastek.hrapp.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.mastek.hrapp.services.EmployeeService;


@Component // declare it as spring Component
public class APIConfig extends ResourceConfig{ // configure the Service classes using ResourceConfig
   
   public APIConfig() {
       // register each Service class to enable services as API
       register(EmployeeService.class);
   }



}