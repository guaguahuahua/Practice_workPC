package com.xjtu.interview;

import java.io.IOException;

public class TestFinally {

	/**
	 * �����쳣�����е�finally ����ִ��˳��
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
	 * ������ǰ��ֹ�ģ��������try-catch��Ҳ�������finally������
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
	 * ʹ��ϵͳ��exit������ǰ��ֹ��������У�����ִ��finally�����
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
	 * ����׳���IOException���ּ��ʱ�쳣����ô����ʱ������ͨ����
	 * ����������׳�ArithmeticException��������ʱ�쳣����ô����׶ο���ͨ��
	 */
	private void testException() throws IOException{
		System.out.println("testException block");
	} 
	
	/**
	 * main������������������ķ�����
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
