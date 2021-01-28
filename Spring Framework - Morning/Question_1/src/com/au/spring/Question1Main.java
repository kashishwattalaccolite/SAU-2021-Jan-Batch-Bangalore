package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Question1Main {

	public static void main(String[] args) {
		
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		Collect collect = (Collect)factory.getBean("collect");
		collect.show();
	}

}
