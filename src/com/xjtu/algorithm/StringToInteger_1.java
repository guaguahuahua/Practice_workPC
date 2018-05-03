package com.xjtu.algorithm;
/**
 * 将字符串 转换为整数
 * @author Administrator
 *
 */
public class StringToInteger_1 {

	/**
	 * 其中核心代码主要是字符转化为数字的过程，但是必须得包括下面的考虑：
	 * 1.正负数的符号问题
	 * 2.掺杂这空格的问题
	 * 3.其他的符号问题
	 * 4.如果发生溢出的问题
	 * @param s
	 * @return
	 */
	public static int stringToInteger(String s) {
		//存放最后的结果
		int res=0;
		//判断是否为负数
		boolean negative=false;
		//字符串遍历的开始的第一个索引位置
		int i=0;
		char first=s.charAt(0);
		if(first=='+') {
			i=1;
		}
		if(first=='-') {
			i=1;
			negative=true;
		}
		int fac=1;
		//遍历
		for (int start=s.length()-1; start>=i; start--) {
			char c=s.charAt(start);
			//如果为数字
			if((c>='0' && c<='9')) {
				res=res+(c-'0')*fac;
				fac=fac*10;
				//判断是否发生了溢出
				if((res<0 && res<=Integer.MIN_VALUE) || (res>0 && res>Integer.MAX_VALUE)) {
					return Integer.MIN_VALUE;
				}
				
			//如果为空格，那继续下次循环	
			}else if(c==' ') {
				continue;
			//如果既不是空格也不是数字	
			}else {
				return Integer.MIN_VALUE;
			}
		}
		//根据前面的正负号的判断返回结果
		if(negative) {
			return -res;
		}else {
			return res;
		}
	}
	
	public static void main(String []args) {
		String s="-1 2% 222222222222222222222";
		int res=stringToInteger(s);
		System.out.println(res);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
