package springmvchb.practice.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springmvchb.practice.entity.Account;

@Component
public class AccountDAO {
	String aname;
	String aid;
	public List<Account> findAllAccount()
	{
		int a=1;
		int b=0;
		if(a/b !=1)
		{
			throw new RuntimeException("Getting error");
		}


		List<Account> myAccountList=new ArrayList<>();
		Account account1=new Account("Johan","101");
		Account account2=new Account("Binod","102");
		Account account3=new Account("Ali","103");
		myAccountList.add(account1);
		myAccountList.add(account2);
		myAccountList.add(account3);
		return myAccountList;
	}
	
	public void  printAllAccount(List<Account> myList)
	{
		System.out.println("Account List Details: "+myList);
	}
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	public void doWork()
	{
		System.out.println("DoWork");
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		System.out.println("setAname() Method");
		this.aname = aname;
	}
	public String getAid() {
		System.out.println("setAid() Method");
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
}
