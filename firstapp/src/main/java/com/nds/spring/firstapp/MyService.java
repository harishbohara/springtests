package com.nds.spring.firstapp;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	public void foo() {
		System.out.println("This is my foo method from My Service class");
	}
}
