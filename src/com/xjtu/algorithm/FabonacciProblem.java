package com.xjtu.algorithm;

/**
 * ��fabonacci���еĵ�n��
 * @author Administrator
 *
 */
public class FabonacciProblem {

	/**
	 * �ݹ�ķ�ʽ�� ʱ�临�Ӷ�Ϊfabanacci(n)ԼΪ2^0.694n
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
	 * O(n)ʱ�临�Ӷ�
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
	 * O(log n)ʱ�临�Ӷ�
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
	 * ʵ�ֱ�̬��̨�ף���ǰ������Ǵ���ģ����ڵݹ�ʽf(n)=f(n-1)+f(n-2)+...+f(2)+f(1)+f(0)
	 * ���տ��Ի���Ϊ:
	 * f(n)=f(n-1)+f(n-1)=2*f(n-1);
	 * ʱ�临�Ӷ�Ϊ O(n),���ǵݹ��õ���ջ�ṹ
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
	 * �ǵݹ�ṹʵ��
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
	 * �ó���Ϊ2*1��Сש���ǳ���Ϊ2*n������
	 * ���ŷ�2��f(n-2)�� ���������ŷ�1��f(n-1)��
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
