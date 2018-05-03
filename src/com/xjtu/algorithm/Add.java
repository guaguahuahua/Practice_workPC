package com.xjtu.algorithm;

/**
 * 实现两个数的相加
 * @author Administrator
 *
 */
public class Add {

	/**
	 * 在不使用+- /* 符号的情况下实现两个数的相加
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		int res=addBacktrack_1(a, b);
		return res;
	}
	
	/**
	 * 递归的实现两个数的相加
	 * @param a
	 * @param b
	 */
	public static void addBacktrack(int a, int b) {
		
		int sum=0;
		//直到没有进位的时候运算结束
		while(b!=0) {
			//直接运算
			sum=a ^ b;
			//获得进位
			b=(a&b)<<1;
			//
			a=sum;
		}
		System.out.println(a);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int addBacktrack_1(int a, int b) {
		
		if(b==0) {
			return a;
		}else {
			int sum=a^b;
			int carry=(a&b)<<1;
			a=sum;
			b=carry;
			return addBacktrack_1(a, b);
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		int b=1;
		int r=add(a, b);
		System.out.println(r);
	}

}
