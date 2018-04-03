package com.xjtu.algorithm;

public class CountOne {

	/**
	 * ���������㣬������n��1�ĸ���
	 * ʹ��λ���㣬ͨ����λʵ��
	 * @param n
	 * @return
	 */
	public static int countOnes(int n) {
		
		int count=0;
		while(n != 0) {
			if((n&1)!=0) {
				count++;
			}
			n>>=1;
		}
		
		return count;
	}
	
	/**
	 * ͨ��λ�����ж�һ�����Ƿ�Ϊ2��n�η�
	 * �ж϶���������1�ĸ��������1�ĸ���Ϊ1����ô����2���ݴΣ�������
	 * @param n	
	 * @return
	 */
	public static boolean isFac(int n) {
		
		int count=0;
		while(n!=0) {
			if((n & 1)==1) {
				count++;
			}
			n>>=1;
		}
		if(count==1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=48;
//		int res=countOnes(n);
//		System.out.println(res);
//		System.out.println(Integer.toBinaryString(n));
		boolean res=isFac(n);
		System.out.println(res);
	}

}
