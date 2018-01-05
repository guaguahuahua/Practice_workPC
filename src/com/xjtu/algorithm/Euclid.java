package com.xjtu.algorithm;

public class Euclid {

	
	/**
	 * �ݹ�ʵ�����Լ��
	 * @param a
	 * @param b
	 * @return
	 */
	public static int euclid(int a,int b) {
		if(a==0) {
			return b;
		}
		if(b==0) {
			return a;
		}
		return euclid(b,a%b);
	}
	/**
	 * ��鲻�õ���a,b����С���⣬��Ϊ���Զ�����������ģ��һ����룬��������
	 * @param a
	 * @param b
	 * @return
	 */
	public static int euclid_1(int a, int b) {
		
		if(a==0) {
			return b;
		}
		if(b==0) {
			return a;
		}
		int t=a%b;   
		while(t!=0) {
			a=b;
			b=t;
			t=a%b;
		}
		return b;
	}
	/**
	 * ʹ��ŷ����õķ���ʵ�����Լ�����ݹ�ͷǵݹ�
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=18;
		int b=24;
		int res=euclid(a,b);
		System.out.println(res);
	}

}
