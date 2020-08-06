package springmvchb.practice.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springmvchb.practice.aopdemo.dao.AccountDAO;
import springmvchb.practice.aopdemo.dao.PlayerDAO;
import springmvchb.practice.entity.Account;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		PlayerDAO playerDAO=context.getBean("playerDAO",PlayerDAO.class);
				
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		theAccountDAO.setAname("Devanshu");
		theAccountDAO.setAid("139181");
		System.out.println(theAccountDAO.getAid());
		System.out.println(theAccountDAO.getAname());
		playerDAO.getPlayerName();
		
		// close the context
		context.close();

	}

}
