package com.wz.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把该类声明为一个切面
//1.需要把该类放入ioc容器中
//2.再声明为一个切面
@Component
@Aspect
public class LoggingAspect {

	//声明该方法是一个前置通知，在目标方法开始之前执行
	@Before("execution(public int com.wz.spring.aop.impl.ArithmeticCalculator.add(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();//方法名称
		List<Object> args = Arrays.asList(joinPoint.getArgs());//参数
		System.out.println("The method " + methodName + " begins" + args);
	}
	
}
