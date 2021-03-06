package com.xjtu.algorithm;

/**
 * 求fabonacci数列的第n项
 * @author Administrator
 *
 */
public class FabonacciProblem {

	/**
	 * 递归的方式， 时间复杂度为fabanacci(n)约为2^0.694n
	 * @param n
	 * @return
	 */
	public static int fabonacci(int n) {
		
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fabonacci(n-1)+fabonacci(n-2);	
		}
	}
	
	/**
	 * O(n)时间复杂度
	 * @param n
	 * @return
	 */
	public static int fabonacci_1(int n) {
		
		int f0=0;
		int f1=1;
		if(n==0) {
			return f0;
		}else if(n==1) {
			return f1;
		}
		
		int fn=0;
		for(int i=2; i<=n; i++) {
			fn=f1+f0;
			f0=f1;
			f1=fn;
		}
		return fn;
	}
	
	/**
	 * O(log n)时间复杂度
	 * @param n
	 * @return
	 */
	public static int fabonacci_2(int n) {
		
		int f0=0;
		int f1=1;
		if(n==0) {
			return f0;
		}else if(n==1){
			return f1;
		}
		
		int [][]a= {{0,1},{1,1}};
		int [][]temp=a;
		for(int i=0; i<n-2; i++) {
			int [][]t=new int[2][2];
			t[0][0]=temp[0][0]*a[0][0]+temp[0][1]*a[1][0];
			t[0][1]=temp[0][0]*a[0][1]+temp[0][1]*a[1][1];
			t[1][0]=temp[1][0]*a[0][0]+temp[1][1]*a[1][0];
			t[1][1]=temp[1][0]*a[0][1]+temp[1][1]*a[1][1];
			
			temp=t;
		}
		
		return temp[1][0]*f0+temp[1][1]*f1;
	}
	
	/**
	 * 实现变态跳台阶，以前的理解是错误的，对于递归式f(n)=f(n-1)+f(n-2)+...+f(2)+f(1)+f(0)
	 * 最终可以化简为:
	 * f(n)=f(n-1)+f(n-1)=2*f(n-1);
	 * 时间复杂度为 O(n),但是递归用到了栈结构
	 * @param n
	 * @return
	 */
	public static int jumpStairs(int n) {
		
		if(n<0) {
			return -1;
		}else if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return 2*jumpStairs(n-1);
		}
	}
	
	/**
	 * 非递归结构实现
	 * @param n
	 * @return
	 */
	public static int jumpStairs_1(int n) {
		
		int f0=0;
		int f1=1;
		int fn=0;
		
		if(n==0) {
			return f0;
		}else if(n==1) {
			return f1;
		}else {
			for(int i=2; i<=n; i++) {
				fn=2*f1;
				f1=fn;
			}
			
		}
		return fn;
	}
	
	/**
	 * 用长度为2*1的小砖覆盖长度为2*n的区域
	 * 横着放2个f(n-2)， 或者是竖着放1个f(n-1)；
	 * @param n
	 * @return
	 */
	public static int cover(int n) {
		
		int f0=0;
		int f1=1;
		int fn=0;
		if(n<0) {
			return -1;
		}else if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			for(int i=2; i<=n; i++) {
				fn=f0+f1;
				f0=f1;
				f1=fn;
			}
		}
		return fn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
//		int res=fabonacci_2(n);
		int res=cover(n);
		System.out.println(res);
	}

}
