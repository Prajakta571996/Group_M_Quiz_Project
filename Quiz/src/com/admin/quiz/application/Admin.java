package com.admin.quiz.application;

import java.util.Scanner;

public class Admin {
	
	public void getAdminData() {
		 AllResults allResults = new AllResults();
		 AddQuestions addQuestions = new AddQuestions();
		System.out.println("Choose Option\n 1: Display All Student Result\n 2: Get Particular Student Data\n 3: For Add Question");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter option");
		int no = sc.nextInt();
		
		switch(no) {
		case 1 : allResults.getResult();
			break;
		case 2 :  allResults.getIndividualStudentData();
			break;
		case 3 : addQuestions.getInsertQuestions();
			break;
		}
	 
		
	}

}
