package com.xjtu.algorithm;

public class StringToInteger {

	
	public static int stringToInteger(String s) {
		
		return Integer.parseInt(s);
	}
	
	/**
	 * ���ַ����е��ַ����ε�ȡ�������θ���Ӧ��λ������Ӧ�ı���
	 * @param s
	 * @return
	 */
	public static int stringToInteger_1(String s) {
		
		int times=1;
		int res=0;
		for(int i=s.length()-1; i>=0; i--) {
			//�õ�һ���ַ�
			int temp=s.charAt(i)-'0';
			res+=temp*times;
			times*=10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="252434";
		int res=stringToInteger_1(s);
		System.out.println(res);
	}

}
