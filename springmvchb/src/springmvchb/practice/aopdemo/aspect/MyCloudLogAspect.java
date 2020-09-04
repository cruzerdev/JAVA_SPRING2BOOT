package springmvchb.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAspect {
	@Before("springmvchb.practice.aopdemo.aspect.AopExpressions.doSomeWorkForPackage()")
	public void myCloudLogAspect() {
		
		System.out.println("MyCloudLogAspect=====>>> Executing @Before advice on method @Pointcut");
		
	}
}
