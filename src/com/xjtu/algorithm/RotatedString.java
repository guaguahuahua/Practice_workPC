package com.xjtu.algorithm;

public class RotatedString {

	/**
	 * ���ַ��������n���ַ�������ת������ת���ַ������Ҷˣ�������ԭ����˳��
	 * ���Ƚ��ַ����������ã�
	 * ֮��ֱ�����������ֽ�������
	 * ����ʹ���ַ�������в���
	 * @param s
	 * @param n
	 * @return
	 */
	public static String rotatedString(String s, int n) {
		
		//�Բ���n���д���
		if(n>s.length()) {
			n %= s.length();
		}	
		
		//ת��Ϊ�ַ�����
		char []chars=s.toCharArray();
		//������ת
		reverse(chars, 0, s.length()-1);
		reverse(chars, 0, s.length()-n-1);
		reverse(chars, s.length()-n, s.length()-1);
		return new String(chars);
	}
	
	/**
	 * ���ַ�����������õķ���
	 * @param chars
	 * @param start
	 * @param end
	 */
	public static void reverse(char []chars, int start, int end) {
		
		while(start<end) {
			char temp=chars[start];
			chars[start]=chars[end];
			chars[end]=temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdef";
		String res=rotatedString(s, 9);
		System.out.println(res);
	}

}
