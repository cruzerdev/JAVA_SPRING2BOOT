package springmvchb.practice.aopdemo.dao;

import org.springframework.stereotype.Component;

import springmvchb.practice.entity.Account;

@Component
public class AccountDAO {
	String aname;
	String aid;
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
