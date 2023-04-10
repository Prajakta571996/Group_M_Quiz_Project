package com.user.quiz.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	
	Scanner scanner = new Scanner(System.in);

	public void insertData() throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;

		try {

			// calling method from SqlLinked Class
			GetConnection conn = new GetConnection();

			con = conn.getConnectionDetails();
             System.out.println("Enter First Name");
			String fName = scanner.next();
			System.out.println("Enter Last Name");
			String lName = scanner.next();
			System.out.println("Enter Mobile Number");
			String mobileNumber = scanner.next();
			System.out.println("Enter EmailId");
			String emailId = scanner.next();
			System.out.println("Enter UserName");
			String userName = scanner.next();
			System.out.println("Enter Password");
			String password = scanner.next();

			pr = con.prepareStatement(
					"insert into student(FirstName, LastName, mobileNo, emailid, Username, password)values(?,?,?,?,?,?)");

			pr.setString(1, fName);
			pr.setString(2, lName);
			pr.setString(3, mobileNumber);
			pr.setString(4, emailId);
			pr.setString(5, userName);
			pr.setString(6, password);

			// step 4
			int i = pr.executeUpdate();
			System.out.println("Registration data is inserted" + " " + i);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Login login = new Login();
		login.getLogin();

	}

}
