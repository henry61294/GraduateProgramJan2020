package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ProjectServices {
	String exampleProperty1;
	
	
	public ProjectServices() {
		System.out.println("project service created");
	}
	
	@PostConstruct 
	public void initializeService() {
		System.out.println("project service initiliased");
		
	}
	
	@PreDestroy
	public void terminateService() {
		System.out.println("project service terminated");
	}
	
	
	
	public void exampleMethod() {
		System.out.println("connect to " + getExampleProperty()+" for business data");
	}


	public String getExampleProperty() {
		return exampleProperty1;
	}

@Value("Spring Example Data Source") // Initialise the property with the simple value
	public void setExampleProperty(String exampleProperty1) {
		System.out.println("example property set: "+ exampleProperty1);
		this.exampleProperty1 = exampleProperty1;
	}

	
	
}
