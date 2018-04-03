package com.xjtu.algorithm;

public class Fabonacci {

	/**
	 * ��fabonacci���еĵ�n��
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
	 * �����������еĵ�n�ʹ�����Դ����ķ�ʽ����
	 * @param n
	 * @return
	 */
	public static int fabonacci_1(int n) {
		int [][]A= {{1, 1}, {1, 0}};
		int [][]T= {{1, 1}, {1, 0}};	
		int [][]temp=new int[2][2];
		if(n<0) {
			System.out.println("�������n�����⣡");
			return -1;
		}
		if(n==0 || n==1) {
			return 1;
		}
		for(int i=1; i<n-1; i++) {
			//��鵱ʱ���ִ����ԭ����ֱ�ӽ��ж�T��������˸�ֵ������Ԫ���ڼ�������з����˱仯
			//Ӧ���Ƚ�������������ʱ�����У��ȼ������֮���ٽ��и�ֵ
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
	 * �ݹ�Ĺ����γ��˺ܶ��ظ���Ԫ�أ����ظ��ڵ��ϵ�ʱ���˷Ѻܴ�
	 * ����ʹ��
	 * @param n
	 * @return
	 */
	public static int fabonacci_2(int n) {
		
		if(n<0) {
			System.out.println("������������");
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
