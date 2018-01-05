package com.xjtu.interview;

import java.io.IOException;

public class TestFinally {

	/**
	 * 测试异常捕获中的finally 语句的执行顺序
	 * @return int
	 */
	@SuppressWarnings("finally")
	private int testFinally() {
				
		try{
			return 1;
		}catch (Exception e){
			return 0;
		}finally {
			System.out.println("finally being executed! ");
			return -1;
		}
	}
	
	/**
	 * 测试提前终止的，不会进入try-catch，也不会进入finally的情形
	 */
	private void testFinally_1() {
		int a=5/0;
		try {
			System.out.println("try block");
		}catch(Exception e) {
			System.out.println("catch block");
		}finally {
			System.out.println("finally block");
		}
	}
	
	/**
	 * 使用系统的exit语句会提前终止程序的运行，不会执行finally代码段
	 */
	private void testFinally_2() {
		try {
			System.out.println("try block");
			System.exit(1);
		}catch(Exception e) {
			System.out.println("catch block");
		}finally {
			System.out.println("finally block");
		}
	}
	
	/**
	 * 如果抛出的IOException这种检查时异常，那么编译时就难以通过，
	 * 但是如果是抛出ArithmeticException这种运行时异常，那么编译阶段可以通过
	 */
	private void testException() throws IOException{
		System.out.println("testException block");
	} 
	
	/**
	 * main函数，用来测试上面的方法的
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFinally tFinally=new TestFinally();
//		int res=tFinally.testFinally();
//		System.out.println(res);
//		tFinally.testFinally_1();
//		tFinally.testFinally_2();
		try {
			tFinally.testException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
