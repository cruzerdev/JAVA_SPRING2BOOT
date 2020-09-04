package springmvchb.practice.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springmvchb.practice.aopdemo.dao.AccountDAO;
import springmvchb.practice.aopdemo.dao.PlayerDAO;
import springmvchb.practice.aopdemo.service.TrafficFortuneService;
import springmvchb.practice.entity.Account;

public class AroundMainDemoApp {

	private static Logger myLogger=Logger.getLogger(AroundMainDemoApp.class.getName());
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService=context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("Around ");
		myLogger.info("Calling FortuneService");
		String data=theFortuneService.getFortune();
		myLogger.info("Data: "+data);
		myLogger.info("Finished");

	}

}
