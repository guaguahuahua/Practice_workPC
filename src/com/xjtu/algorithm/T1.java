package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []c= {'a', 'c', 'e'};
	
		char [] copyc;
		copyc = Arrays.copyOfRange(c, 0, 1);
		System.out.println(copyc );
		System.out.println(myToString(copyc)+myToString(copyc));
		
	}
	
	public static String myToString(char []c) {
		StringBuilder sb=new StringBuilder();
		for(char cs : c) {
			sb.append(cs);
		}
		return sb.toString();
	}
	
	static int k=9;
	
	
	
	String dg(char []c, String str) {
		
		for(int i=0; i<k; i++) {
			str=str+c[i];
			
//			dg();
		}
		return null;
	}

}
