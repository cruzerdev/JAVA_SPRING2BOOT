package springmvchb.practice.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;



//ProceedingJoinPoint
@Component
public class TrafficFortuneService {

	public String getFortune()
	{
		try
		{
			TimeUnit.SECONDS.sleep(5);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expecting high traffic";
	}
}
