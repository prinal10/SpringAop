package com.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.aspect.CustomLoggable;

@Component
public class Circle {

	@Value("Oval Circle")
	private String name;

	@CustomLoggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
