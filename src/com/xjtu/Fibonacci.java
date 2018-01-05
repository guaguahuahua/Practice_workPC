package com.xjtu;

public class Fibonacci {
	
	/**
	 * 使用递归法完成求解fabonacci序列的第n个元素的值
	 * @param n
	 * @return
	 */
	public static int fabonacci_1(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		return fabonacci_1(n-1)+fabonacci_1(n-2);
	}
	/**
	 * 使用改进算法求fabonacci的值，即使用矩阵的方式完成
	 * @param n
	 * @return
	 */
	public static int fabonacci(int n) {
		int f0=0,f1=1; //初始值
		if(n==0) {
			return f0;
		}
		//直接计算模板迭代后的值
		int [][]pattern={{0,1},
						{1,1}};
		int [][]temp={{0,1},
					 {1,1}};
		int [][]tmp=new int[2][2];
		for(int i=0;i<n-1;i++) {             //矩阵相乘的问题还是不好弄
			tmp[0][0]=temp[0][0]*pattern[0][0]+temp[0][1]*pattern[1][0];
			tmp[0][1]=temp[0][0]*pattern[0][1]+temp[0][1]*pattern[1][1];
			tmp[1][0]=temp[1][0]*pattern[0][0]+temp[1][1]*pattern[1][0];
			tmp[1][1]=temp[1][0]*pattern[0][1]+temp[1][1]*pattern[1][1];
			temp[0][0]=tmp[0][0];
			temp[0][1]=tmp[0][1];
			temp[1][0]=tmp[1][0];
			temp[1][1]=tmp[1][1];
			System.out.println(temp[0][0]+","+temp[0][1]);
			System.out.println(temp[1][0]+","+temp[1][1]);
			System.out.println();
		}
		System.out.println();
		System.out.println(temp[0][0]+","+temp[0][1]);
		System.out.println(temp[1][0]+","+temp[1][1]);
		return temp[0][0]*f0+temp[0][1]*f1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		int res=fabonacci(n);
		System.out.print(res);
	}

}
