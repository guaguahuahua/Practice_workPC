package com.xjtu.algorithm;

public class Euclid {

	
	/**
	 * 递归实现最大公约数
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
	 * 这块不用担心a,b，大小问题，因为会自动调换，可以模拟一遍代码，立刻明了
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
	 * 使用欧几里得的方法实现最大公约数，递归和非递归
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
