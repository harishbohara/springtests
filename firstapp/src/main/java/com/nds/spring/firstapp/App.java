package com.nds.spring.firstapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:com/applicationContext.xml");
		MyService service = context.getBean(MyService.class);
		System.out.println("Hello World!");
		service.foo();
	}
}
