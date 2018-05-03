package com.xjtu.algorithm;

public class ContinueLeftMove {

	/**
	 * ������⣬������λ���Ⱦ����ַ��������ˣ������ַ������ȵ���λͨ��
	 * ȡ�����ʽ���Եõ������ǿ����ֽ������ַ���ƴ�ӵ�һ��t��Ȼ��ֱ����t�вü�Դ�ַ������ȵ�һ����
	 * @param str
	 * @param n
	 * @return
	 */
	public static String continueLeftMove(String str, int n) {
		int len=n%str.length();
		//�������ַ���ƴ����һ��
		String t=str+str;
		String cut=t.substring(len, len+str.length());
		return cut;
	}
	
	/**
	 * ѭ������
	 * ʹ�����е�3����ת�ķ�ʽʵ��
	 * @param str
	 * @param n
	 * @return
	 */
	public static String continueLeftMove_1(String str, int n) {
		
		//���������λ�ĸ���
		n=n%str.length();
		String s1=reverse(str, 0, str.length());
		String s2=reverse(s1, 0, str.length()-n);
		String s3=reverse(s2, str.length()-n, str.length());		
		return s3;
	}
	
	/**
	 * ���������ַ���������ת
	 * @param s
	 * @return
	 */
	public static String reverse(String  s, int start, int end) {
		String t="";
		String r1=s.substring(0, start);
		String r2=s.substring(end, s.length());
		for(int i=start; i<end; i++) {
			t=s.charAt(i)+t;
		}
		return r1+t+r2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcXYZdef";
		int n=3;
		String res=continueLeftMove_1(s, n);
		System.out.println(res);
	}

}
