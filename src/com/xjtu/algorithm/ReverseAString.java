package com.xjtu.algorithm;

public class ReverseAString {

	
	public static void reverseAString(String str) {
		System.out.println("逆置之前："+str);
		//将字符串分割为单词
		String []strs=str.split("\\s+");
		StringBuilder sb=new StringBuilder();
		for(int i=strs.length-1; i>=0; i--) {
			sb.append(strs[i]+" ");
		}
		String res=sb.toString().substring(0, sb.length()-1);
		System.out.println("逆置之后："+res);
	}
	
	/**
	 * 在java中String是一个不可变类，所以不能直接对原字符串进行操作，
	 * 需要将源字符串转化为字符数组操作，或者是新建一个字符串
	 * @param str
	 */
	public static void reverseWholeString(String str) {
		System.out.println("逆转前："+str);
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
		System.out.println("逆转后："+res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str="I like to eat";
		String str="I am a student.";
		reverseAString(str);
//		reverseWholeString(str);
	}

}
