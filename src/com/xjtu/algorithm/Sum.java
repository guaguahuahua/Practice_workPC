package com.xjtu.algorithm;

/**
 * ��ָ����n���������ĺ�,����ʹ��if else ��Ŀ�����������
 * �Լ������жϷ�,for whileѭ�����˳���
 * @author Administrator
 *
 */
public class Sum {
	
	public static int sum(int n) {		
		
		if(n==1) {
			return 1;
		}
		return n+sum(n-1);
	}

	/**
	 * ʹ�ö�·����Ϊ��ֹ�����ж�
	 */
	private static int count=0;
	public static boolean sum_1(int n) {
		count=count+n;
		return n!=0 && sum_1(n-1);
	}
	
	
	public static int sum_2(int n) {
			
		return multiple(n, n+1)>>1;
	}
	
	/**
	 * ʹ��λ�������������ĳ˻�
	 * ����˼�������ڶ��������ĳ˷�����ʽ
	 * @param a
	 * @param b
	 * @return
	 */
	public static int multiple(int a, int b) {
		
		int res=0;
		while(b!=0) {
			if((b&1)!=0) {
				res=res+a;
			}
			a=a<<1;
			b=b>>1;
		}
		return res;
	}
	
	/**
	 * ���������ĳ˻��ݹ�ⷨ
	 * ����������
	 */
	private static int res=0;
	public static boolean multiple_1(int a, int b) {
		
		boolean r=(b!=0) && (res=res+a)>0;
		
		return r && multiple_1(a<<1, b>>1);
	}
	public static int sum_3(int n) {
		
		multiple_1(n, n+1);
		System.out.println(res);
		return res>>1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int res=sum_3(n);
//		System.out.println(count);
		System.out.println(res);
	}

}
