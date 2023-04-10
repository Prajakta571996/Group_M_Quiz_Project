package com.user.quiz.application;

import java.sql.SQLException;

public class User {
	
	public void getUserData() throws SQLException {
		
	
		Login login = new Login();
		login.getLogin();
		
		//for show result
		System.out.println("For Your Result Please Enter ur Details");
		Results results = new Results();
		results.getResults();
		
		System.out.println("Thank You");
		
	}

}
