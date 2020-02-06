package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeprtmentServices {
	String exampleProperty2;
	
	
	public DeprtmentServices() {
		System.out.println("department service created");
	}
	
	@PostConstruct 
	public void initializeService() {
		System.out.println("department service initiliased");
		
	}
	
	@PreDestroy
	public void terminateService() {
		System.out.println("department service terminated");
	}
	
	
	
	public void exampleMethod() {
		System.out.println("connect to " + getExampleProperty()+" for business data");
	}


	public String getExampleProperty() {
		return exampleProperty2;
	}

@Value("Spring Example Data Source") // Initialise the property with the simple value
	public void setExampleProperty(String exampleProperty2) {
		System.out.println("example property set: "+ exampleProperty2);
		this.exampleProperty2 = exampleProperty2;
	}

	
	
}
