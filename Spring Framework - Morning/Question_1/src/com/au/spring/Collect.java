package com.au.spring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Collect {
	
	private Map<Integer, Integer> multiplyby2=new HashMap<Integer, Integer>();; 
	private Set<String> hset = new HashSet<String>();

	public Set<String> getHset() {
		return hset;
	}

	public void setHset(Set<String> hset) {
		this.hset = hset;
	}

	public Map<Integer, Integer> getMultiplyby2() {
		return multiplyby2;
	}

	public void setMultiplyby2(Map<Integer, Integer> multiplyby2) {
		this.multiplyby2 = multiplyby2;
	}

	public void show() {
		System.out.println("Map");
		for(Integer a:multiplyby2.keySet()) {
			System.out.println(a +","+multiplyby2.get(a));
		}
		System.out.println("Set");
		for (String temp : hset) {
	        System.out.println(temp);
	     }
		
	}

}
