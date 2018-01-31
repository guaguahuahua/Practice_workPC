package com.xjtu.interview;

import java.util.Arrays;

public class JudgeIfTwoStringSame {
	
	/**
	 * �ж������ַ����Ƿ�����ͬ���ַ���ɣ��ַ���������Բ�ͬ�������ַ����ĳ�����һ����
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean sameOrNot(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int []table=new int[256];
		//�����ʵ����ͨ������ѭ����ʵ�ֵ�
		for(int i=0; i<s1.length(); i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			//��������ַ�����ͬ����ô�ַ�Ӧ���ǳɶԳ��ֵģ�
			if(table[(int)c1]!=0) {
				table[(int)c1]--;
			}else {
				table[(int)c1]++;
			}
			
			if(table[(int)c2]!=0) {
				table[(int)c2]--;
			}else {
				table[(int)c2]++;
			}
		}
		//���һ��hash�����Ƿ�������Ԫ�صļ���Ϊ0
		for(int i=0; i<table.length; i++) {
			if(table[i]!=0) {
				return false;
			}
		}	
		return true;
	}
	
	/**
	 * �ж������ַ����Ƿ���ͬ
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean sameOrNot_1(String s1, String s2) {
		
		//���Ȳ�һ����ֱ�ӷ���false
		if(s1.length()!=s2.length()) {
			return false;
		}
		//���ַ���ת��Ϊ�ַ�����
		char []c1=s1.toCharArray();
		char []c2=s2.toCharArray();
		//�����ֵ����ַ���������
		Arrays.sort(c1);
		Arrays.sort(c2);
//		//
//		for(char K:c2) {
//			System.out.print(K+"\t");
//		}
		for(int i=0; i<c1.length; i++) {
			if(c1[i]!=c2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="aaaabbc";
		String s2="abcbaaa";
		boolean r=sameOrNot_1(s1, s2);
		System.out.println(r);
	}
	

}
