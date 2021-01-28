package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Question2Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml"); 	      
		factory.registerShutdownHook();
		Collect2 collect2 = (Collect2)factory.getBean("collect2");
		collect2.show();
	}

}
