package com.user.quiz.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	Scanner scanner = new Scanner(System.in);

	public void getLogin() throws SQLException {
		
		Registration get = new Registration();

		String user = "";
		String pass = "";
		Connection con = null;
		PreparedStatement pr = null;

		try {
			    
			System.out.println("LOGIN PAGE");

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
			System.out.println("Check data...");
			String uName = null;
			String password1 = null;
			while (rs.next()) {
				uName = rs.getString(6);
				password1 = rs.getString(7);

			}
			
			if (userName.equals(uName) && password1.equals(password)) {
				System.out.println("login successfully");
				System.out.println(" ");
				System.out.println("Your Quiz has been started");
				
				QuizDemo quizDemo = new QuizDemo();
				quizDemo.getquiz();
	
			} else {
				System.out.println("Invalid login");
				
				System.out.println(" ");
				System.out.println("Please Registered First");
				
				get.insertData();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			pr.close();

		}
		
		

	}

}
