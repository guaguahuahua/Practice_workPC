package com.xjtu.algorithm;

public class DivideConquer {

	/**
	 * 使用分治法实现数乘，将四次乘法运算降到三次
	 * 仅仅针对有偶数位乘法运算，
	 * @param x 
	 * @param y
	 * @return
	 */
	public static int divideConquer(int x,int y) {
		int bits=nums(x);
		if(bits==1) {
			return x*y;
		}
		int stair=(int)Math.pow(10,bits/2);
		int xl=stair*(x/stair);
		int xr=x-xl;
		int yl=stair*(y/stair);
		int yr=y-yl;
		int p1=divideConquer(xl,yl);
		int p2=divideConquer(xr,yr);
		int p3=divideConquer(xl+xr,yl+yr);
		return p1+p2+(p3-p1-p2);
	}
	public static int nums(int number) {
		int count=0;
		while(number!=0) {
			count++;
			number/=10;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=11;
		int y=12;
		int res=divideConquer(x,y);
		System.out.println(res);
	}

}
