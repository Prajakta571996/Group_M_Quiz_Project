package com.admin.quiz.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.user.quiz.application.GetConnection;

public class AllResults {
	public void getResult() {
           
		   System.out.println("All Student Result Data");
		try {
			Connection con2 = null;
			PreparedStatement ps2 = null;
  
			GetConnection con = new GetConnection();
			con2 = con.getConnectionDetails(); // Query for to get data
			ps2 = con2.prepareStatement(
					"SELECT student.student_id, student.firstname, student.lastname, results.marks FROM student \r\n"
							+ "INNER JOIN results ON student.student_id=results.student_id order by marks;");
			ResultSet rs = ps2.executeQuery();
			System.out.println("studno  firstname   lastname       marks      ");
			while (rs.next()) {
				int a = rs.getInt(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				int d = rs.getInt(4);

				System.out.println(a + " :      " + b + "         " + c + "     " + d);
			}
			con2.close();
			ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getIndividualStudentData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("If u want to retrive ur result\n" + "Enter ur sid i.e Student id from the table");
		System.out.println(" ");
		int a = sc.nextInt();
		Connection con2 = null;
		PreparedStatement ps3 = null;
		try {
			GetConnection con = new GetConnection();
			con2 = con.getConnectionDetails();
			ps3 = con2.prepareStatement(
					"SELECT student.student_id, student.firstname, student.lastname, results.marks FROM student INNER JOIN results ON student.student_id=results.student_id WHERE student.student_id ="
							+ a);
			ResultSet rs3 = ps3.executeQuery();
			while (rs3.next()) {
				System.out.println("No : " + rs3.getInt("student_id") + "\n" + rs3.getString("firstname") + " "
						+ rs3.getString("lastname") + "\n" + "your score is : " + rs3.getInt("marks"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
