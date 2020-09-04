package springmvchb.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Purpose of making this class is to refactor the Pointcut expression and use the Advice
 */
@Aspect
@Component
public class AopExpressions {

	@Pointcut("execution(* springmvchb.practice.aopdemo.dao.*.*(..))")
	public void doSomeWork()
	{
	}
	@Pointcut("execution(* springmvchb.practice.aopdemo.dao.*.get*(..))")
	public void getter()
	{
	}
	@Pointcut("execution(* springmvchb.practice.aopdemo.dao.*.set*(..))")
	public void setter()
	{
	}
	@Pointcut("doSomeWork() && !(getter() ||setter())")
	public void doSomeWorkForPackage()
	{
	}
}
