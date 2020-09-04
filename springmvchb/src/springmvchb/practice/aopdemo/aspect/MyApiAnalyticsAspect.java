package springmvchb.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("springmvchb.practice.aopdemo.aspect.AopExpressions.doSomeWorkForPackage()")
	public void myApiAnalyticsAspect() {
		
		System.out.println("MyApiAnalyticsAspect=====>>> Executing @Before advice on method @Pointcut");
		
	}
}
