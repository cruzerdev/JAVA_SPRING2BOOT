package springmvchb.practice.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class PlayerDAO {

	public String getPlayerName()
	{
		System.out.println("Method: getPlayerName");
		return "Ms Dhoni";
	}
}
