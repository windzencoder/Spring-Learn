package com.wz.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	@Before("execution(public int com.wz.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();//方法名称
		List<Object> args = Arrays.asList(joinPoint.getArgs());//参数
		System.out.println("The method " + methodName + " begins" + args);
	}
	
	//后置通知在目标方法执行后（无论是否发生异常），执行通知
	@After("execution(public int com.wz.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	@AfterReturning(value="execution(public int com.wz.spring.aop.impl.ArithmeticCalculator.*(int, int))", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result ) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName +" return with "+result);
	}
	
	@AfterThrowing(value="execution(public int com.wz.spring.aop.impl.ArithmeticCalculator.*(int, int))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName +" throw with "+ex);
	}
	
	
	@Around("execution(public int com.wz.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public Object around(ProceedingJoinPoint pjd) {
		System.out.println("around");
		Object result = null;
		String methodName = pjd.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//后置通知
			System.out.println("The method "+methodName +" ends with "+Arrays.asList(pjd.getArgs()));
		} catch (Throwable e) {
			//异常通知
			e.printStackTrace();
		}
		//后置通知
		return result;
	}
	
	
}
