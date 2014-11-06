package com.hb.common.controller;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	public void foo() {
		System.out.println("------> This is service foo");
	}

	public String name() {
		return "MyServicename";
	}
}
