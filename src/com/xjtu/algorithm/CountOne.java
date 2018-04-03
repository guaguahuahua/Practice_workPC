package com.xjtu.algorithm;

public class CountOne {

	/**
	 * 给定整数你，求整数n中1的个数
	 * 使用位运算，通过移位实现
	 * @param n
	 * @return
	 */
	public static int countOnes(int n) {
		
		int count=0;
		while(n != 0) {
			if((n&1)!=0) {
				count++;
			}
			n>>=1;
		}
		
		return count;
	}
	
	/**
	 * 通过位运算判断一个数是否为2的n次方
	 * 判断二进制数中1的个数，如果1的个数为1，那么就是2的幂次，否则不是
	 * @param n	
	 * @return
	 */
	public static boolean isFac(int n) {
		
		int count=0;
		while(n!=0) {
			if((n & 1)==1) {
				count++;
			}
			n>>=1;
		}
		if(count==1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=48;
//		int res=countOnes(n);
//		System.out.println(res);
//		System.out.println(Integer.toBinaryString(n));
		boolean res=isFac(n);
		System.out.println(res);
	}

}
