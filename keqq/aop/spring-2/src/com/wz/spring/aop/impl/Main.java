package com.wz.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//1.创建spring ioc容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从ioc容器中获取bean的实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		//3.使用bean
		int result =  arithmeticCalculator.add(1, 2);
		System.out.println("result  = " + result);
	
		result =  arithmeticCalculator.div(1, 0);
		System.out.println("result  = " + result);
		
	}
	
}
