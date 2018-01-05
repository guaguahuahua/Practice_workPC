package com.xjtu.interview;

public class TestSwitch {

	public static void testSwitch(String str) {
		
		switch(str) {
		
		case "armo" : System.out.println("truly!"); break;
		case "hate" : System.out.println("sincerely"); break;
		default : System.out.println("wrong!"); break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSwitch("armo");
	}

}
