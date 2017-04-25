package com.demo.aspect;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspectAround {

	/*
	 * Suppose there are some advice that you want to execute before and after
	 * some class method executes. We can write separate After and Before but
	 * thats waste of time, instead we can write a single Around advice that
	 * will be executed before the method runs and after the method run
	 * successfully or not.
	 * 
	 * @Around Advice needs one "ProceedingJoinPoint" object as argument. So the
	 * below advice will run around all getters methods as we have used
	 * "allGetters" as parameter in the Around annotation. Now suppose that at
	 * some point in the below advice method you want to you want your
	 * triggering method to run then we will use the "proceed()" on
	 * proceedingJoinPoint object. And so in this way we are calling the advice
	 * method around the "proceedingJoinPoint.proceed()" which in our case is
	 * the triggering getter method. And so the execution of the triggering
	 * method is in our hand. Now since in our case the getters are returns the
	 * value to the calling programming during the bean initialization or during
	 * any get call in the main, so we have to set the return type as
	 * Object(Circle/Triangle)
	 */
	/*
	 * @Around("allGetters()") public Object myAroundAdvice(ProceedingJoinPoint
	 * proceedingJoinPoint) { Object returnValue = null; try {
	 * System.out.println("This is before the Around method !!"); returnValue =
	 * proceedingJoinPoint.proceed();
	 * System.out.println("This is After the Around method !!"); } catch
	 * (Throwable e) { // TODO Auto-generated catch block
	 * System.out.println("This is error in the Around method !!");
	 * e.printStackTrace(); }
	 * 
	 * System.out.println("This is End of the Around method !!"); return
	 * returnValue; }
	 * 
	 * @Pointcut("execution(* get*())") public void allGetters() { }
	 */

}
