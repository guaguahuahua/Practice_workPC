package com.xjtu.algorithm;

public class StringToInteger {

	
	public static int stringToInteger(String s) {
		
		return Integer.parseInt(s);
	}
	
	/**
	 * 将字符串中的字符依次的取出，依次给对应的位乘以相应的倍数
	 * @param s
	 * @return
	 */
	public static int stringToInteger_1(String s) {
		
		int times=1;
		int res=0;
		for(int i=s.length()-1; i>=0; i--) {
			//得到一个字符
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
