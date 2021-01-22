package com.au.assignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class RandNum {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub

		FileOutputStream out;
		out = new FileOutputStream("rand.txt");
		
		Random rand = new Random();
		Integer randno = rand.nextInt(50)+1;
		System.out.println("Writing Random numbers: "+randno);
		while(randno % 5 != 0)  
		{
			String s1 = randno.toString()+ "\t";
			byte b1[]=s1.getBytes();
			out.write(b1);
			randno = rand.nextInt(50)+1;
			System.out.println(randno);
		}
		String s2 = randno.toString()+ "\t";
		byte b2[] = s2.getBytes();
		out.write(b2);
		out.close();
		
		Scanner scanner = new Scanner(new File("rand.txt"));
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (scanner.hasNextInt()) {
				int innumber=scanner.nextInt();
				list.add(innumber);
			}
		System.out.println("Reading Random numbers: "+list);
	

		Integer id = list.stream().filter(e-> e%5 == 0).map(e-> e*2).reduce(1,(a,b)->{return a*b;});
		System.out.println("Multiplied by 2: "+id);
		
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";		
		String username = "sMkXvyYxZM";
		String	passowrd = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url, username, passowrd);
		String sql = "insert into test values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		preparedStatement.setString(2,"Kashish");
		preparedStatement.execute();
		System.out.println("Successfully inserted into table");

		}
	}
