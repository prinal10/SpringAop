package com.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * Use to mark this class as an Aspect and the method of this class will
 * be marked as advice. To tell spring that we have some classes which are 
 * marked as Aspects and have advice configured to run, we have to add
 * "aop:aspectj-autoproxy" tag in the beans in .xml file. And then add bean
 * to point the location of the class marked as Aspect or Annotate the class 
 * with @Component annotation 
*/
@Aspect
public class LoggingAspect {

	/*
	 * Cross cutting means the some functionality that needs to execute after
	 * some events in some class but is not a part or concept of business logic
	 * and so any class should not depend on these cross cutting object. To
	 * remove such dependencies we will convert these cross cutting object to
	 * aspects. There can be many "Advice" (functionality/methods/logic) in one
	 * aspect. We will then configure which advice will run/execute and when
	 * (after other class method completion/ any such event)
	 */
	/*
	 * @Before tells the spring that this advice should run before the
	 * "execution(SOME_METHOD)" of some method of one class, which in our case
	 * is "public String getName()" method of Circle class.
	 */
	@Before(value = "execution(public String com.demo.model.Circle.getName())")
	public void loggingAdvice1() {
		System.out.println("Advice thrown from the Logging Aspect Class - 1");

	}

	/*
	 * By passing "execution(public String get*())" we are telling spring to run
	 * this advice before any method that has the signature="public String" and
	 * method that starts with "get" i.e getName, etc. any method that returns
	 * String and strictly not allowing any parameter/arguments in the "get"
	 * method. THIS IS CALLED WILD CARD EXPRESSION
	 */
	@Before(value = "execution(public String get*())")
	public void loggingAdvice2() {
		System.out.println("Advice thrown from the Logging Aspect Class - 2");

	}

	/*
	 * By passing "execution(public * get*())" we are telling spring to run this
	 * advice before any method that has the
	 * signature="public String/int/Boolean/Class_Name(any return type)" and
	 * method that starts with "get" i.e getName,getTriangle,getCircle etc. with
	 * any type of return type but strictly not allowing any parameter/arguments
	 * in the "get" method.. THIS IS CALLED WILD CARD EXPRESSION
	 * 
	 * We can also remove the acess specifier - public,private,etc and put one
	 * "*" common for both acess specifier and return type
	 */
	@Before(value = "execution(* get*())")
	public void loggingAdvice3() {
		System.out.println("Advice thrown from the Logging Aspect Class - 3");

	}

	/*
	 * You will notice that we have pass "execution(* get*(*))" which is similar
	 * to the above advice but here we are specifying that the method should
	 * also contain at least one argument i.e parameter. While all of the above
	 * where strictly not allowing any parameter/arguments in the "get" method.
	 * To allow none/some parameter we will use next annotation
	 */
	@Before(value = "execution(* get*(*))")
	public void loggingAdvice4() {
		System.out.println("Advice thrown from the Logging Aspect Class - 3");

	}

	@Before("allGetters()")
	public void pointcutexample1() {
		System.out.println("Advice thrown from the pointcutexample - 1");

	}

	@Before("allGetters()")
	public void pointcutexample2() {
		System.out.println("Advice thrown from the pointcutexample - 2");

	}

	/*
	 * Suppose we have many advice that we want to run on a same event like we
	 * have event of execution of method starting with name get. Then instead of
	 * repeating the same value="execution(* get*(*))" for every advice we will
	 * make a dummy method and annotate it
	 * with @Pointcut("execution(* get*(*))"). And then
	 * use @Before("allGetters()") for all other advice.
	 * i.e @Before("dummy_Class_Name")
	 */
	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	/*
	 * Here by specifying the "get(..)" we are telling the spring this aspect
	 * should run before any method that starts with "get" and can have
	 * one/many/none arguments (parameters). Also by specifying com.demo.model.*
	 * we can have more control over where to look for the event classes
	 */
	@Before(value = "execution(* com.demo.model.*.get*(..))")
	public void loggingAdvice5() {
		System.out.println("Advice thrown from the Logging Aspect Class - 3");

	}

}
