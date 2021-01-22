package com.au.javafd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question1 {

	public static void main(String[] args) {
		Integer[] numbers = new Integer[] { 6,1,3,25,89,900,74,54,67 };
		List<Integer> numbersList = Arrays.asList(numbers);
		 
		//Sort the list
		Collections.sort(numbersList);
		 
		//Print list to confirm
		System.out.println(numbersList);

	}

}
