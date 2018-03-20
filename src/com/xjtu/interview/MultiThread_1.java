package com.xjtu.interview;

public class MultiThread_1 implements Runnable{
	
	public void run() {
		System.out.println("this is in thread");
	}
	
	public static void main(String []args) {
		MultiThread_1 mt=new MultiThread_1();
		Thread t=new Thread(mt);
		t.start();
		System.out.println("this is out thread");
	}
}
