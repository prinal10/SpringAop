package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class LoggingAspectUsingXML {

	// @Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("This is before the Around method !!");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("This is After the Around method !!");
		} catch (Throwable e) { // TODO Auto-generated catch block
			System.out.println("This is error in the Around method !!");
			e.printStackTrace();
		}

		System.out.println("This is End of the Around method !!");
		return returnValue;
	}

	/*
	 * @Pointcut("execution(* get*())") public void allGetters() { }
	 */
}
