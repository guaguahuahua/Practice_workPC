package com.xjtu.interview;

import java.util.Arrays;

public class JudgeIfTwoStringSame {
	
	/**
	 * 判断两个字符串是否由相同的字符组成，字符的排序可以不同，但是字符串的长度是一样的
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean sameOrNot(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int []table=new int[256];
		//这块其实可以通过两个循环来实现的
		for(int i=0; i<s1.length(); i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			//如果两个字符串相同，那么字符应该是成对出现的，
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
		//检查一下hash表中是否有所有元素的计数为0
		for(int i=0; i<table.length; i++) {
			if(table[i]!=0) {
				return false;
			}
		}	
		return true;
	}
	
	/**
	 * 判断两个字符串是否相同
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean sameOrNot_1(String s1, String s2) {
		
		//长度不一样，直接返回false
		if(s1.length()!=s2.length()) {
			return false;
		}
		//将字符串转化为字符数组
		char []c1=s1.toCharArray();
		char []c2=s2.toCharArray();
		//按照字典序将字符进行排列
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
