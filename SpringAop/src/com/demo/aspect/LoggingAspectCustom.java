package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspectCustom {

	/*
	 * To provide a custom advice we will need a custom annotation. So we will
	 * create a new custom annotation file (here we have
	 * "CustomLoggable.annotation")and and a aspect class that uses that
	 * annotation to bind advice with that annotation and so we will pass below
	 * para "@annotation(AnnotationFilePathWithPackage)". And so now we can
	 * annotate any method/variable of any class with @CustomLoggable annotation
	 * and the below advice will be applied to that method/variable. In short we
	 * are marking/pointing our triggering method with the @CustomLoggable
	 */
	@Around("@annotation(com.demo.aspect.CustomLoggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("This is before the Custom method !!");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("This is After the Custom method !!");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("This is error in the Custom method !!");
			e.printStackTrace();
		}

		System.out.println("This is End of the Custom method !!");
		return returnValue;
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

}
