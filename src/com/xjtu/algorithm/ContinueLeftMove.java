package com.xjtu.algorithm;

public class ContinueLeftMove {

	/**
	 * 按照理解，最大的移位长度就是字符串本身了，超过字符串长度的移位通过
	 * 取余的形式可以得到，我们可以现将两个字符串拼接到一起t，然后直接在t中裁剪源字符串长度的一个串
	 * @param str
	 * @param n
	 * @return
	 */
	public static String continueLeftMove(String str, int n) {
		int len=n%str.length();
		//将两个字符串拼接在一起
		String t=str+str;
		String cut=t.substring(len, len+str.length());
		return cut;
	}
	
	/**
	 * 循环左移
	 * 使用流行的3次逆转的方式实现
	 * @param str
	 * @param n
	 * @return
	 */
	public static String continueLeftMove_1(String str, int n) {
		
		//获得最终移位的个数
		n=n%str.length();
		String s1=reverse(str, 0, str.length());
		String s2=reverse(s1, 0, str.length()-n);
		String s3=reverse(s2, str.length()-n, str.length());		
		return s3;
	}
	
	/**
	 * 将给定的字符串进行逆转
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
