package com.wz.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		/*
		ArithmeticCalculator arithmeticCalculator = null;
		arithmeticCalculator = new ArithmeticCalculatorImpl();
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("-->" + result);
		*/
		
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLogginProxy(target).getLoggingProxy();
		
		int result = proxy.add(1, 2);
		System.out.println("-->" + result);
		
	}
	
}
