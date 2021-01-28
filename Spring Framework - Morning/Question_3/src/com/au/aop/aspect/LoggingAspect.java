package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {
	
	
	// uncomment for After Advice
	@Pointcut("execution(public * set*(..))")
	public void allSetters() {	}
	
	@After("allSetters()")
	public void afterAdvice() {
		System.out.println("After Setter advice");
	} 
	
	//uncomment for After Returning
	@AfterReturning(pointcut="execution( public * *(..))", returning = "retVal")
	public void afterReturningAdvice(JoinPoint jp, Object retVal) {
		System.out.println("After Returning");
		System.out.println("Method Signature: "  + jp.getSignature());  

	} 
	
//	uncomment for AfterThrowing
//	
//	@AfterThrowing(pointcut ="execution( public * *(..))",throwing="error")
//	public void afterThrowingAdvice() {
//		System.out.println("Exception thrown");
//	} 
	
	
	//uncomment for Around
//	@Pointcut("execution (public * set*(..))")
//	private void setterMethods() {}
//	
//	@Around("setterMethods()")
//	public void aroundAdvice() {
//		System.out.println("Before and After Setter");
//	}
	

}
