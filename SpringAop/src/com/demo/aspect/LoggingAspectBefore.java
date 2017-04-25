package com.demo.aspect;

import org.aspectj.lang.annotation.Aspect;

/*
 * Use to mark this class as an Aspect and the method of this class will
 * be marked as advice. To tell spring that we have some classes which are 
 * marked as Aspects and have advice configured to run, we have to add
 * "aop:aspectj-autoproxy" tag in the beans in .xml file. And then add bean
 * to point the location of the class marked as Aspect or Annotate the class 
 * with @Component annotation 
*/
@Aspect
public class LoggingAspectBefore {

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
	/*
	 * @Before(value =
	 * "execution(public String com.demo.model.Circle.getName())") public void
	 * loggingAdvice1() {
	 * System.out.println("Advice thrown from the Logging Aspect Class - 1");
	 * 
	 * }
	 */

	/*
	 * By passing "execution(public String get*())" we are telling spring to run
	 * this advice before any method that has the signature="public String" and
	 * method that starts with "get" i.e getName, etc. any method that returns
	 * String and strictly not allowing any parameter/arguments in the "get"
	 * method. THIS IS CALLED WILD CARD EXPRESSION
	 */
	/*
	 * @Before(value = "execution(public String get*())") public void
	 * loggingAdvice2() {
	 * System.out.println("Advice thrown from the Logging Aspect Class - 2");
	 * 
	 * }
	 */

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
	/*
	 * @Before(value = "execution(* get*())") public void loggingAdvice3() {
	 * System.out.println("Advice thrown from the Logging Aspect Class - 3");
	 * 
	 * }
	 */
	/*
	 * You will notice that we have pass "execution(* get*(*))" which is similar
	 * to the above advice but here we are specifying that the method should
	 * also contain at least one argument i.e parameter. While all of the above
	 * where strictly not allowing any parameter/arguments in the "get" method.
	 * To allow none/some parameter we will use next annotation
	 */
	/*
	 * @Before(value = "execution(* get*(*))") public void loggingAdvice4() {
	 * System.out.println("Advice thrown from the Logging Aspect Class - 3");
	 * 
	 * }
	 */

	/*
	 * @Before("allGetters()") public void pointcutexample1() {
	 * System.out.println("Advice thrown from the pointcutexample - 1");
	 * 
	 * }
	 */

	/*
	 * This advice will execute only when both of the specified pointcuts
	 * "allGetters() && allCircleMethods()" are called. The calling of the
	 * specifies methods can be in the same line(such as here we are calling
	 * "shapeService.getCircle().getName()"), can be one after another, also
	 * when one("allGetters()") is called first and after execution of some
	 * other lines another("allCircleMethods()") method specified below is
	 * called. Only when the last method (from all pointcuts specified by &&) is
	 * going to be called (for here in the main method) only then the below
	 * advice will get execute
	 */
	/*
	 * @Before("allGetters() && allCircleMethods()") public void
	 * pointcutexample2() {
	 * System.out.println("Advice thrown from the pointcutexample - 2");
	 * 
	 * }
	 */

	/*
	 * Suppose we have many advice that we want to run on a same event like we
	 * have event of execution of method starting with name get. Then instead of
	 * repeating the same value="execution(* get*(*))" for every advice we will
	 * make a dummy method and annotate it
	 * with @Pointcut("execution(* get*(*))"). And then
	 * use @Before("allGetters()") for all other advice.
	 * i.e @Before("dummy_Class_Name")
	 */
	/*
	 * @Pointcut("execution(* get*())") public void allGetters() { }
	 */

	/*
	 * We can also config any advice for all methods in a class/package. Simply
	 * By using "within(com.demo.model.Circle)" in the Pointcut annotation we
	 * are specifying that which ever advice uses this Pointcut, that advice
	 * will be executed for all the methods with in the Circle class
	 * com.demo.model.* = means all classes in the given package
	 * com.demo.model..* = means all packages and classes with in those packages
	 * 
	 * @Pointcut(args("classname/type")) = this advice should run for those
	 * having the specified type/classname as their argument types
	 * 
	 */
	/*
	 * @Pointcut("within(com.demo.model.Circle)") public void allCircleMethods()
	 * { }
	 */

	/*
	 * Here the below advice is executed BEFORE "allCircleMethods()" are called
	 * anywhere, but we want to perform different action in this
	 * advice(joinPointExample) on the different CIRCLE class methods calls, so
	 * we will pass JoinPoint object as argument, this object will have info
	 * about the actual CIRCLE class method call that triggered this advice and
	 * so we can use this info to perform different action in this
	 * advice(joinPointExample) on the different CIRCLE class methods calls
	 * 
	 * joinPoint.getTarget() in the below advice returns the object of the class
	 * whose method triggered this advice (for us the object will be of the
	 * CIRCLE class). So we can use this object to perform some action on Circle
	 * class itself
	 * 
	 */
	/*
	 * @Before("allCircleMethods()") public void joinPointExample(JoinPoint
	 * joinPoint) {
	 * 
	 * System.out.println(joinPoint.getTarget());
	 * 
	 * }
	 */

	/*
	 * The below advice will run before a class method having the specified type
	 * as an argument is called. We can specify String, int, Circle, boolean,
	 * etc. But if we want o use the argument passed and perform some action
	 * before it is used in the method that triggered that advice than we can
	 * specify a variable name (here "var_name") in the below annotation and
	 * also as an advice argument with data type that we are expecting the
	 * argument of the triggering method will have. Then use that variable in
	 * the advice to perform some action.(here the argument of the triggering
	 * method (setName()) has String type argument)
	 */
	/*
	 * @Before("args(var_name)") public void stringArgumentMethods(String
	 * var_name) {
	 * 
	 * System.out.
	 * println("This from the String Argument Method and the variable is : " +
	 * var_name);
	 * 
	 * }
	 */

	/*
	 * Here by specifying the "get(..)" we are telling the spring this aspect
	 * should run before any method that starts with "get" and can have
	 * one/many/none arguments (parameters). Also by specifying com.demo.model.*
	 * we can have more control over where to look for the event classes
	 */
	/*
	 * @Before(value = "execution(* com.demo.model.*.get*(..))") public void
	 * loggingAdvice5() {
	 * System.out.println("Advice thrown from the Logging Aspect Class - 3");
	 * 
	 * }
	 */
}
