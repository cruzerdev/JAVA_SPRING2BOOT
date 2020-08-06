package springmvchb.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

//	@Before("execution(* springmvchb.practice.aopdemo.dao.*.*(..))")
//	public void beforeAddAccountAdvice() {
//		
//		System.out.println("\n=====>>> Executing @Before advice on method");
//		
//	}
//	@Before("execution(* springmvchb.practice.aopdemo.dao.AccountDAO.doWork(..))")
//	public void beforeDoWorkMethod() {
//		
//		System.out.println("\n=====>>> Executing @Before advice on method doWork()");
//		
//	}
	@Pointcut("execution(* springmvchb.practice.aopdemo.dao.*.*(..))")
	private void doSomeWork()
	{
	}
	@Pointcut("execution(* springmvchb.practice.aopdemo.dao.*.get*(..))")
	private void getter()
	{
	}
	@Pointcut("execution(* springmvchb.practice.aopdemo.dao.*.set*(..))")
	private void setter()
	{
	}
	@Pointcut("doSomeWork() && (getter() ||setter())")
	private void doSomeWorkForPackage()
	{
	}
	@Before("doSomeWorkForPackage()")
	public void beforeDoWorkMethod() {
		
		System.out.println("\n=====>>> Executing @Before advice on method @Pointcut");
		
	}
}
