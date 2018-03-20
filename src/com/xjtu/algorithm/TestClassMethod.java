package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClassMethod {
	int a=5;
	public static void hello() {
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClassMethod test=null;
		test.hello();
		int []a= {1,2,3,4};
		List r=Arrays.asList(a);
		
		System.out.print(r.getClass()+"\t");
		double b=Math.cos(Math.toRadians(42));
		System.out.println(b);
	}

}
