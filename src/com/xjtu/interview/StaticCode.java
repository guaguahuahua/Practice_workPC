package com.xjtu.interview;

public class StaticCode {
	static {
		StaticCode.x=5;
		System.out.println("para init finished! ");
	}
	static int x, y;
	
	public static void f1() {
		y=(x++) + (++x);
		System.out.println(y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		f1();
		String s="com.jd.";
		s=s.replaceAll(".", "/");
		System.out.println(s);
	}

}
