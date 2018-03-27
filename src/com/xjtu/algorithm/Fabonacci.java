package com.xjtu.algorithm;

public class Fabonacci {

	/**
	 * 求fabonacci数列的第n项
	 * @param n
	 * @return
	 */
	public static int fabonacci(int n) {
		if(n==0) {
			return 1;
		}
		
		if(n==1) {
			return 1;
		}
		return fabonacci(n-1)+fabonacci(n-2);
	}
	
	/**
	 * 方法二求数列的第n项
	 * @param n
	 * @return
	 */
	public static int fabonacci_1(int n) {
		int [][]A= {{1, 1}, {1, 0}};
		int [][]T= A;//{{1, 1},{0, 0}};
		if(n==0 || n==1) {
			return 1;
		}
		for(int i=0; i<n; i++) {
			T[0][0]=T[0][0]*A[0][0]+T[0][1]*A[1][0];
			T[0][1]=T[1][0]*A[0][1]+T[1][1]*A[1][1];
			T[1][0]=T[1][0]*A[0][0]+T[1][1]*A[1][0];
			T[1][1]=T[1][0]*A[0][1]+T[1][1]*A[1][1];
		}		
		int t=T[0][0]*1+T[0][1]*1+T[1][0]*1+T[1][1]*1;
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int res=fabonacci_1(n);
		System.out.println(res);
	}

}
