package com.xjtu.algorithm;

public class RotatedString {

	/**
	 * 对字符串的左边n个字符进行旋转操作，转到字符串的右端，并保持原来的顺序
	 * 首先将字符串整体逆置；
	 * 之后分别对左右两部分进行逆置
	 * 我们使用字符数组进行操作
	 * @param s
	 * @param n
	 * @return
	 */
	public static String rotatedString(String s, int n) {
		
		//对参数n进行处理
		if(n>s.length()) {
			n %= s.length();
		}	
		
		//转化为字符数组
		char []chars=s.toCharArray();
		//整体逆转
		reverse(chars, 0, s.length()-1);
		reverse(chars, 0, s.length()-n-1);
		reverse(chars, s.length()-n, s.length()-1);
		return new String(chars);
	}
	
	/**
	 * 对字符数组进行逆置的方法
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
