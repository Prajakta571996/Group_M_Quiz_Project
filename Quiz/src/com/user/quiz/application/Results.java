package com.user.quiz.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Results {

	Scanner scanner = new Scanner(System.in);

	public void getResults() {
	
	String user = "";
	String pass = "";
	Connection con = null;
	PreparedStatement pr = null;

	try {

		System.out.println("Enter the username");
		String userName = scanner.next();

		System.out.println("Enter the password");
		String password = scanner.next();
		

		// calling method from SqlLinked Class
		GetConnection conn = new GetConnection();
		con = conn.getConnectionDetails();
		// step 1 & step 2 is already done in SqlLinked class
		// now Step 3 insert data by dynamically
		pr = con.prepareStatement("select * from student ");

		ResultSet rs = pr.executeQuery();
		int id = 0;
		String uName = null;
		String password1 = null;
		while (rs.next()) {
			 id = rs.getInt(1);
			uName = rs.getString(6);
			password1 = rs.getString(7);

		}
		
		if (userName.equals(uName) && password1.equals(password)) {
            
			pr = con.prepareStatement("select marks from results where student_id = " + id);
			ResultSet rs3 = pr.executeQuery();
			while (rs3.next()) {
				System.out.println("Your Marks is >> " + rs3.getInt("marks"));
			 
		}
		}else {
		
		}

	} catch (Exception e) {
		e.printStackTrace();
	} 
	}
}
