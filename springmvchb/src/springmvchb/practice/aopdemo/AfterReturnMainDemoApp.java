package springmvchb.practice.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springmvchb.practice.aopdemo.dao.AccountDAO;
import springmvchb.practice.aopdemo.dao.PlayerDAO;
import springmvchb.practice.entity.Account;

public class AfterReturnMainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> getAccountList=null;
		try
		{
		 getAccountList=theAccountDAO.findAllAccount();
		}
		catch(Exception ex)
		{
			System.out.println("Exception: "+ex);
		}
		
		System.out.println("//---------");
		System.out.println("List: "+getAccountList);
		theAccountDAO.printAllAccount(getAccountList);
		System.out.println("//---------");
		// close the context
		context.close();

	}

}
