package com.admin.quiz.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.user.quiz.application.GetConnection;

public class AddQuestions {

	public void getInsertQuestions() {

		Connection con1 = null;
		PreparedStatement ps1 = null;
		String question = null;
		String optionA= null;
		String optionB= null;
		String optionC= null;
		String optionD= null;
		String corrOpt= null;
		int corrOptNo= 0;
		try {
			GetConnection con = new GetConnection(); // creating object of connection
			con1 = con.getConnectionDetails();
			Scanner sc = new Scanner(System.in);
    for(int i=1; i<=5; i++) {
			System.out.println("Enter Question");
			 question = sc.nextLine();

			System.out.println("Enter optionA");
			 optionA = sc.nextLine();

			System.out.println("Enter optionB");
			 optionB = sc.nextLine();

			System.out.println("Enter optionC");
			 optionC = sc.nextLine();

			System.out.println("Enter optionD");
			 optionD = sc.nextLine();

			System.out.println("Enter corrOpt");
			 corrOpt = sc.nextLine();

			System.out.println("Enter corrOptNo");
			 corrOptNo = sc.nextInt();
    }
			ps1 = con1.prepareStatement(
					"insert into quiz_question(questions, optionA, optionB, optionC, optionD, correct_opt, corrOptNo)values(?,?,?,?,?,?,?);"); // insert
																																				// data
																																				// quiry
			ps1.setString(1, question);
			ps1.setString(2, optionA); // setting value for database
			ps1.setString(3, optionB);
			ps1.setString(4, optionC);
			ps1.setString(5, optionD);
			ps1.setString(6, corrOpt);
			ps1.setInt(7, corrOptNo);

			ps1.executeUpdate();
			System.out.println("Record is inserted in database.");
			System.out.println(" ");

			con1.close();
			ps1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
