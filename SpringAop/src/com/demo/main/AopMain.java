package com.demo.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.service.ShapeService;

public class AopMain {

	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		context = new ClassPathXmlApplicationContext("spring.xml");
		// ShapeService shapeService = (ShapeService)
		// context.getBean("shapeService");
		/*
		 * The above getBean call also be written in the below way, where we
		 * specify the class we are expecting and the conversion is done by the
		 * spring itself
		 */
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		// shapeService.getCircle().setName("Argument Testing");
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());

	}

}
