package springmvchb.practice.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springmvchb.practice.entity.Account;

@Aspect
@Component
@Order(1)
public class MyLoggingDemoAspect {
	private  Logger myLogger=Logger.getLogger(getClass().getName());
	@Around("execution(* springmvchb.practice.aopdemo.service.*.getFortune())")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		myLogger.info("method: "+theProceedingJoinPoint.getSignature().toShortString());
		//Rethrow the exception
		
		try
		{
			theProceedingJoinPoint=null;
			Object result=theProceedingJoinPoint.proceed();
			return result;
		}catch (Exception e) {
			
			myLogger.warning("Wait! Got some problem: "+e.getMessage());
		throw e;
		}
		//handle the Exception
//		Object result=null;
//		try
//		{
//			theProceedingJoinPoint=null;
//			result=theProceedingJoinPoint.proceed();
//		}catch (Exception e) {
//			
//			myLogger.warning("Wait! Got some problem: "+e.getMessage());
//			result="Getting some issue in target method";
//		}
		//Time take to execute the target method
//		long start=System.currentTimeMillis();
//		Object result =theProceedingJoinPoint.proceed();
//		long end=System.currentTimeMillis();
//		long duration=end-start;
//		myLogger.info("Time taken: "+duration);
//		return result;
	}
	@AfterReturning(pointcut = "execution(* springmvchb.practice.aopdemo.dao.AccountDAO.findAllAccount())",returning = "result")
	public void afterReturningDemoAspect(JoinPoint theJoinPoint,List<Account> result)
	{
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("Method Signature: "+ method);
		myLogger.info("Result: "+result);
	}
	@AfterThrowing(pointcut = "execution(* springmvchb.practice.aopdemo.dao.AccountDAO.findAllAccount())",throwing = "theExc")
	public void afterThrowExceptionDemoAspect(JoinPoint theJoinPoint,Throwable theExc)
	{
		myLogger.info("Exception Found: "+theExc);
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("Method Signature: "+ method);
		myLogger.info("Result: "+theExc);
	}
	
	@AfterReturning(pointcut = "execution(* springmvchb.practice.aopdemo.dao.AccountDAO.printAllAccount(..))",returning = "result")
	public void printAccountHolderList()
	{
		myLogger.info("Voila.....Account Details Printed Successfully!");
	}
	
	@After("execution(* springmvchb.practice.aopdemo.dao.AccountDAO.findAllAccount())")
	public void myAfterAdviceDemoAspect(JoinPoint theJoinPoint) {
		myLogger.info("Running after : "+theJoinPoint.getSignature().toShortString());
	}
	@Before("springmvchb.practice.aopdemo.aspect.AopExpressions.doSomeWorkForPackage()")
	public void myLoggingDemoAspect(JoinPoint theJoinPoint) {
		
		myLogger.info("MyLoggingDemoAspect=====>>> Executing @Before advice on method @Pointcut");
		
		//Let's  do something new 
		//Read nmethod Signature using JointPoint
		MethodSignature methodSignature =(MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: "+methodSignature);
		
		//Read method arguments using JoinPoint
		Object [] theArgs=theJoinPoint.getArgs();
		for(Object temp: theArgs)
		{
			myLogger.info("Argument : "+temp);
			if(temp instanceof Account)
			{
				Account account=(Account)temp;
				myLogger.info("Name: "+account.getName());
				myLogger.info("Level: "+account.getLevel());
			}
		}
		
	}
}
