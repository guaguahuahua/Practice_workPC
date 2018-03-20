package com.xjtu.interview;

public class BeverageProblem {

	public static void fun() {
		int n=30;
		String pattern="00000";
		for(int i=0; i<n; i++) {
			//获得当前数的二进制字符串
			String t=Integer.toBinaryString(i);
			if(t.length()<5) {
				int offset=5-t.length();
				t=pattern.substring(0, offset)+t;
			}
			System.out.println(t);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun();
	}

}
