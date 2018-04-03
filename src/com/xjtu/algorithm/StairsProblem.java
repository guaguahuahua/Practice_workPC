package com.xjtu.algorithm;

public class StairsProblem {

	/**
	 * 输入台阶数n，每次可以走两个或者是一个，求出最终走的所有方法数
	 * 递归解法
	 * 在这里，我们看到了一个问题，就是当前走法=在当前的基础上走一步的方法数 + 当前基础上走两步的方法数
	 * @param n	int 总台阶数
	 * @return	int 所有的走法
	 */
	public static int stairsProblem(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		return stairsProblem(n-1)+stairsProblem(n-2);
	}
	
	/**
	 * 走台阶的非递归解法
	 * 首先我们根据了递归解法发现了规律：f(n)=f(n-1)+f(n-2)
	 * 从而直接实现动态规划求解问题
	 * @param n	int 剩余台阶数
	 * @return	int 所有可能的走法
	 */
	public static int stairsProblem_1(int n) {
	
		//处理一下特殊情况
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		//根据现有的情况
		int one=1;
		int two=2;
		int res=0;
		
		for(int i=0; i<n-2; i++) {
			res=one+two;
			one=two;
			two=res;
		}
		return res;
	}
	
	/**
	 * 变态走台阶法，每次走的数量可以是1，2...，n
	 * 以前都是走一级或者是两级，那么那种情况下会有是一个斐波那契数列的情形
	 * 现在变成了前n项和的情形，因为情况转化为 f(n)=f(n-1)+f(n-2)+f(n-3)+..f(2)+f(1)+f(0)这种形式
	 * 所以每一项都是前n项的和
	 * 时间复杂度是O(n)，空间复杂度o(n)
	 * @param n
	 * @return
	 */
	public static long stairsProblem_2(int n) {
		
		if(n<0) {
			System.out.println("参数n越界错误!");
			return -1;
		}
		if(n==1) {
			return 1;			
		}
		if(n==2) {
			return 2;
		}
		long []sum=new long[n];
		sum[0]=1;
		sum[1]=1;
		
		//构造fabonacci数列
		for(int i=2; i<n; i++) {
			sum[i]=sum[i-1]+sum[i-2];
			System.out.print(sum[i]+"\t");
		}
		System.out.println();
		long s=0;
		//因为是变态走法，所以我们需要遍历求前n项的和
		for(int i=0; i<sum.length; i++) {
			s+=sum[i];
		}
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=16;
		long res=(long) stairsProblem(n);
		System.out.println(res);
	}

}
