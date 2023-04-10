package com.user.quiz.application;

import java.sql.SQLException;
import java.util.Scanner;

import com.admin.quiz.application.Admin;
import com.admin.quiz.application.AllResults;

public class TestMain {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome To Quiz Application");
		
		System.out.println("Choose Option \n 1: User\n 2: Admin");
		
		User user = new User();
		Admin admin = new Admin();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Option");
		
		int no = sc.nextInt();
		
		switch(no) {
		case 1 :  user.getUserData(); 
			break;
		case 2 :  admin.getAdminData();
			break;
		}
		
	}

}
