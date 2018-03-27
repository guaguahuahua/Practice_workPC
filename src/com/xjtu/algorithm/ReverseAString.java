package com.xjtu.algorithm;

public class ReverseAString {

	
	public static void reverseAString(String str) {
		System.out.println("����֮ǰ��"+str);
		//���ַ����ָ�Ϊ����
		String []strs=str.split("\\s+");
		StringBuilder sb=new StringBuilder();
		for(int i=strs.length-1; i>=0; i--) {
			sb.append(strs[i]+" ");
		}
		String res=sb.toString().substring(0, sb.length()-1);
		System.out.println("����֮��"+res);
	}
	
	/**
	 * ��java��String��һ�����ɱ��࣬���Բ���ֱ�Ӷ�ԭ�ַ������в�����
	 * ��Ҫ��Դ�ַ���ת��Ϊ�ַ�����������������½�һ���ַ���
	 * @param str
	 */
	public static void reverseWholeString(String str) {
		System.out.println("��תǰ��"+str);
		//
		char []s=str.toCharArray();
		int left=0;
		int right=s.length-1;
		while(left<right) {
			char c=s[left];
			s[left]=s[right];
			s[right]=c;
			left++;
			right--;
		}
		String res=new String(s);
		System.out.println("��ת��"+res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str="I like to eat";
		String str="I am a student.";
		reverseAString(str);
//		reverseWholeString(str);
	}

}
