package com.xjtu.algorithm;

public class StairsProblem {

	/**
	 * ����̨����n��ÿ�ο���������������һ������������ߵ����з�����
	 * �ݹ�ⷨ
	 * ��������ǿ�����һ�����⣬���ǵ�ǰ�߷�=�ڵ�ǰ�Ļ�������һ���ķ����� + ��ǰ�������������ķ�����
	 * @param n	int ��̨����
	 * @return	int ���е��߷�
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
	 * ��̨�׵ķǵݹ�ⷨ
	 * �������Ǹ����˵ݹ�ⷨ�����˹��ɣ�f(n)=f(n-1)+f(n-2)
	 * �Ӷ�ֱ��ʵ�ֶ�̬�滮�������
	 * @param n	int ʣ��̨����
	 * @return	int ���п��ܵ��߷�
	 */
	public static int stairsProblem_1(int n) {
	
		//����һ���������
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		//�������е����
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
	 * ��̬��̨�׷���ÿ���ߵ�����������1��2...��n
	 * ��ǰ������һ����������������ô��������»�����һ��쳲��������е�����
	 * ���ڱ����ǰn��͵����Σ���Ϊ���ת��Ϊ f(n)=f(n-1)+f(n-2)+f(n-3)+..f(2)+f(1)+f(0)������ʽ
	 * ����ÿһ���ǰn��ĺ�
	 * ʱ�临�Ӷ���O(n)���ռ临�Ӷ�o(n)
	 * @param n
	 * @return
	 */
	public static long stairsProblem_2(int n) {
		
		if(n<0) {
			System.out.println("����nԽ�����!");
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
		
		//����fabonacci����
		for(int i=2; i<n; i++) {
			sum[i]=sum[i-1]+sum[i-2];
			System.out.print(sum[i]+"\t");
		}
		System.out.println();
		long s=0;
		//��Ϊ�Ǳ�̬�߷�������������Ҫ������ǰn��ĺ�
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
