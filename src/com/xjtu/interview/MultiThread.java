package com.xjtu.interview;

public class MultiThread extends Thread{

	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("this is a new thread !");
	}
	
	public static void f1() {
		MultiThread mt=new MultiThread();
		mt.start();
		System.out.println("this is out thread");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

}
