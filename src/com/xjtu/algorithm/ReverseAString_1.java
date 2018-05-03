package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * ��תһ���ַ���
 * @author Administrator
 *
 */
public class ReverseAString_1 {

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String reverseAString(String str) {
		
		//�������ַ�����ת
		String step1=reverse(str);
		//����ת֮����ַ���ʹ�ÿո�ֿ�
		String []strs=step1.split("\\s+");
		StringBuilder sb=new StringBuilder();
		//���εĽ�ÿ�����ʽ�����ת
		for(int i=0; i<strs.length; i++) {
			String t=reverse(strs[i]);
			sb.append(t+" ");
		}
		return sb.toString();
	}
	
	/**
	 * �Ը����������ַ���������ת
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		
		StringBuilder sb=new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	/**
	 * ʹ�ö�ջʵ���ַ�������ת
	 * @param str
	 * @return
	 */
	public static String reverseAString_1(String str) {
		LinkedList<Character> stack=new LinkedList<Character>();
		StringBuilder sb=new StringBuilder();
		//���Ƚ��ַ�������Ž�ջ��ȥ
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
		}
		//�ڴ���һ��ջ������ŵ�������
		LinkedList<Character> word=new LinkedList<Character>();
		//��һ��ջ��ջ
		while(!stack.isEmpty()) {
			char c=stack.pop();
			if(c!=' ') {
				word.push(c);
			}else {
				//��������˿ո񣬽����е��ַ���ջ��ɴ�
				String t="";
				while(!word.isEmpty()) {
					t=t+word.pop();
				}
				sb.append(t+" ");
			}
		}
		//ȡ�����һ������
		String t="";
		while(!word.isEmpty()) {
			t=t+word.pop();
		}
		sb.append(t);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="kat is a student";
		String s="game of throne";
		String res=reverseAString_1(s);
		System.out.println(res);
	}

}
