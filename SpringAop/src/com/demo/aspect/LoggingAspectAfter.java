package com.demo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspectAfter {

	/*
	 * Similiar to the before so for explanation read LoggingAspectBefore Class.
	 * The main difference between After and Before is that After Advice execute
	 * even if the method that triggered this advice had some error and threw
	 * some exception, or failed to execute. To prevent this we have to use
	 * "AfterReturning" instead of just "After" and so now the advice will only
	 * execute when the triggering method successfully returns.
	 */
	@AfterReturning("args(var_name)")
	public void stringArgumentMethods(String var_name) {

		System.out.println("This from the After Class and variable is now : " + var_name);

	}

	/*
	 * The below Advice will only run when the triggering method throws an
	 * exception. So the above advice will execute on normal return from method
	 * and the below will get execute when an exception is thrown. But
	 * only @After will act like finally and run at both time no matter what
	 */
	@AfterThrowing("args(var_name)")
	public void exceptionAdvice(String var_name) {
		System.out.println("This will only run when there is EXCEPTION !!!");
	}

	/*
	 * The Below advice is similar to above @AfterReturning("args(var_name)")
	 * but here we are also notifying spring that we are expecting a String
	 * value to be returned (returning = "returnValue") at the end of the
	 * triggering method and save that value in the passed variable
	 * "returnValue". We can specifying any return type value like String, int,
	 * Circle, Object, Triangle,etc. Using this returned value we can get info
	 * or perform some validation and other actions
	 */
	@AfterReturning(pointcut = "args(var_name)", returning = "returnValue")
	public void getReturnValue(String var_name, String returnValue) {

		System.out.println("This from the After Class and variable is now : " + var_name);
		System.out.println("This from the After Class and RETURN VALUE is : " + returnValue);

	}

	/*
	 * This is similar to the above annotation but here instead of the return
	 * value as String, Object, int,etc the value is an Exception object. We can
	 * use thrown type as Exception if we don't know the thrown exception but as
	 * we assumed here we have used RuntimeException.
	 */
	@AfterThrowing(pointcut = "args(var_name)", throwing = "ex")
	public void getExceptionThrown(String var_name, RuntimeException ex) {
		System.out.println("This is the exeption thrown in the triggering class : " + ex.getStackTrace());
	}

}
