package com.xjtu;

public class Fibonacci {
	
	/**
	 * ʹ�õݹ鷨������fabonacci���еĵ�n��Ԫ�ص�ֵ
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
	 * ʹ�øĽ��㷨��fabonacci��ֵ����ʹ�þ���ķ�ʽ���
	 * @param n
	 * @return
	 */
	public static int fabonacci(int n) {
		int f0=0,f1=1; //��ʼֵ
		if(n==0) {
			return f0;
		}
		//ֱ�Ӽ���ģ��������ֵ
		int [][]pattern={{0,1},
						{1,1}};
		int [][]temp={{0,1},
					 {1,1}};
		int [][]tmp=new int[2][2];
		for(int i=0;i<n-1;i++) {             //������˵����⻹�ǲ���Ū
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
