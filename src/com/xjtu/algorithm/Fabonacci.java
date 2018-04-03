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
	 * 方法二求数列的第n项，使用线性代数的方式加速
	 * @param n
	 * @return
	 */
	public static int fabonacci_1(int n) {
		int [][]A= {{1, 1}, {1, 0}};
		int [][]T= {{1, 1}, {1, 0}};	
		int [][]temp=new int[2][2];
		if(n<0) {
			System.out.println("传入参数n有问题！");
			return -1;
		}
		if(n==0 || n==1) {
			return 1;
		}
		for(int i=1; i<n-1; i++) {
			//这块当时出现错误的原因是直接进行对T数组进行了赋值，导致元素在计算过程中发生了变化
			//应该先将计算结果放在临时数组中，等计算完成之后再进行赋值
			temp[0][0]=T[0][0]*A[0][0]+T[0][1]*A[1][0];
			temp[0][1]=T[0][0]*A[0][1]+T[0][1]*A[1][1];
			temp[1][0]=T[1][0]*A[0][0]+T[1][1]*A[1][0];
			temp[1][1]=T[1][0]*A[0][1]+T[1][1]*A[1][1];
			
			T[0][0]=temp[0][0];
			T[0][1]=temp[0][1];
			T[1][0]=temp[1][0];
			T[1][1]=temp[1][1];
		}
		int t=T[0][0]*1+T[0][1]*1;
		return t;
	}
	
	/**
	 * 递归的过程形成了很多重复的元素，再重复节点上的时间浪费很大
	 * 现在使用
	 * @param n
	 * @return
	 */
	public static int fabonacci_2(int n) {
		
		if(n<0) {
			System.out.println("参数输入有误！");
			return -1;
		}
		
		if(n==0 || n==1) {
			return 1;
		}
		int f0=1;
		int f1=1;
		int fn=0;
		for(int i=0; i<n-1; i++) {
			fn=f0+f1;
			f0=f1;
			f1=fn;
		}
		return fn;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int res=fabonacci_1(n);
		System.out.println(res);
	}

}
