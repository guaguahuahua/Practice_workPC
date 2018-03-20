package com.xjtu.interview;

public class MyConstructor {

	public static MyConstructor mc=new MyConstructor();
	{
		System.out.println("block A");
	}
	static {
		System.out.println("block B");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConstructor mycons=new MyConstructor();
	}

}
