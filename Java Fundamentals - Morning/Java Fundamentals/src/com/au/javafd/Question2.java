package com.au.javafd;

public class Question2 {

	public static int divide(int a,int b)
	{
		if(b==0)
		{throw new ArithmeticException("Division by 0 is not allowed");}
		else
		return a/b;
	}
	public static int divideusingthrows(int a, int b) throws ArithmeticException
	{
		return a/b;
	}
	public static void main(String[] args) {

		//int a=divide(5,0);          //uncomment for ArithmeticException using throw
		int a= divideusingthrows(5,0);//comment for ArithmeticException using throw
		System.out.println(a);

	}

}
