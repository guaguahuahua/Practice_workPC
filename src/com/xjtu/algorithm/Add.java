package com.xjtu.algorithm;

/**
 * ʵ�������������
 * @author Administrator
 *
 */
public class Add {

	/**
	 * �ڲ�ʹ��+- /* ���ŵ������ʵ�������������
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		int res=addBacktrack_1(a, b);
		return res;
	}
	
	/**
	 * �ݹ��ʵ�������������
	 * @param a
	 * @param b
	 */
	public static void addBacktrack(int a, int b) {
		
		int sum=0;
		//ֱ��û�н�λ��ʱ���������
		while(b!=0) {
			//ֱ������
			sum=a ^ b;
			//��ý�λ
			b=(a&b)<<1;
			//
			a=sum;
		}
		System.out.println(a);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int addBacktrack_1(int a, int b) {
		
		if(b==0) {
			return a;
		}else {
			int sum=a^b;
			int carry=(a&b)<<1;
			a=sum;
			b=carry;
			return addBacktrack_1(a, b);
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		int b=1;
		int r=add(a, b);
		System.out.println(r);
	}

}
