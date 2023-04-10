package com.user.quiz.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QuizDemo {
	public int marks;
	
	public  void getquiz()
	{
		QuizDemo quizDemo=new QuizDemo();
		Scanner sc=new Scanner(System.in);
		
		Map<Integer, String> map=new LinkedHashMap<Integer, String>();       //create object of LinkedHashMap with generic
		Connection connection=null;             
		PreparedStatement ps=null;
		
		try{
			GetConnection con=new GetConnection();
			connection=con.getConnectionDetails();                      //create the connection
		
		for(int i=1;i<=10;i++)
		{
			    //created the query to get questions from database.
			ps=connection.prepareStatement("SELECT * FROM quiz_question ORDER BY RAND() LIMIT 1");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				map.put(88, rs.getString(2));            
				
				map.put(1, rs.getString(3));
				map.put(2, rs.getString(4));             //Getting data from database
				map.put(3, rs.getString(5));
				map.put(4, rs.getString(6));
				
				Set<Integer> s=map.keySet();               //sorting key by keySet() method
				
				for(Integer j:s)
				{
					System.out.println(j+" : "+map.get(j));               //print question with options in console
				}
				System.out.println(" ");
				System.out.println("Choose correct option");
				int a=sc.nextInt();
				if(a==rs.getInt(8))
				{
					System.out.println("Right Answer : "+rs.getString(7));
					quizDemo.marks++;                                           // counting the marks
				}else 
				{
					System.out.println("Wrong Answer");
					System.out.println("Right answer is >> "+rs.getString(7));
				}
			     this.marks=quizDemo.marks;
				System.out.println();
				
				
			}
		
		ps.close();
		}
		connection.close();

	}catch(Exception e)
		{
			System.out.println(e);
		}
		
		updateUserInput();
		
	}
	
	public void updateUserInput() {
		Connection con1 = null;
		PreparedStatement ps1 = null;
		try {
			GetConnection con = new GetConnection();                  //creating object of connection
			con1 = con.getConnectionDetails();      
			ps1 = con1.prepareStatement("insert into results(marks)values(?);");   //insert data quiry                              // setting value for database    
			ps1.setInt(1, marks);

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
