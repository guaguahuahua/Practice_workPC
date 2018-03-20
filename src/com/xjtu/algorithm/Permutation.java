package com.xjtu.algorithm;

public class Permutation {
	
	/**
	 * ����ַ���ȫ����
	 * @param c
	 * @param start
	 * @param end
	 */
	public static void permutation(char []c, int start, int end) {
		//�ݹ�ĳ���
//		if(end<=1) {
//			return; 
//		}
		if(start==end) {
			System.out.println(c);
		}else {
			for(int i=start; i<=end; i++) {
				swap(c, i, start);
				permutation(c, start+1, end);
				swap(c, start, i);
			}
		}		
	}
	
	/**
	 * �����ַ������е�����λ�õ��ַ�
	 * @param c	char[]
	 * @param s
	 * @param e
	 */
	public static void swap(char []c, int s, int e) {
		char temp=c[s];
		c[s]=c[e];
		c[e]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []c= {'1', '3', '2'};
		permutation(c, 0, 2);
	}

}
