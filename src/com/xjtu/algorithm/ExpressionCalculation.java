package com.xjtu.algorithm;

import java.util.LinkedList;

public class ExpressionCalculation {

	/**
	 * 根据后缀表达式计算值，通过栈的方式来实现
	 * 表达式的内容只涉及正整数，只是模拟编译器计算的过程
	 * @param str
	 * @return
	 */
	public static int expressionCalculation(String str) {
		//获得运算数和运算符
		String []strs=str.split("\\,");
		//使用栈实现表达式求值问题
		LinkedList<String> stack=new LinkedList<String>();
		//遍历操作树和操作符
		for(int len=0; len<strs.length; len++) {
			//判断当前的串字符还是运算符
			if(isNumbers(strs[len])) {
				stack.push(strs[len]);
			}else if(isSymbol(strs[len])!=-1){
				//获得运算符
				int num=isSymbol(strs[len]);
				//出栈获得两个操作数
				int first=Integer.parseInt(stack.pop());
				int second=Integer.parseInt(stack.pop());
				
				//判断当前运算符是什么
				if(num==0) {
					int temp=second+first;
					stack.push(temp+"");
				}else if(num==1){
					int temp=second-first;
					stack.push(temp+"");
				}else if(num==2) {
					int temp=second*first;
					stack.push(temp+"");
				}else if(num==3) {
					int temp=second/first;
					stack.push(temp+"");
				}
			}else {
				System.out.println("输入参数有误！");
			}
		}
		
		int res=Integer.parseInt(stack.pop());
		
		return res;
	}
	
	/**
	 * 判断一个字符串是否完全为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumbers(String str) {
		for(int i=0; i<str.length(); i++) {
			char temp=str.charAt(i);
			//如果字符的数字，那么返回true
			if(temp>='0' && temp<='9') {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符是否为运算符
	 * @param str
	 * @return
	 */
	public static int isSymbol(String str) {
		
		if(str.equals("+")) {
			return 0;
		}else if(str.equals("-")) {
			return 1;
		}else if(str.equals("*")) {
			return 2;
		}else if(str.equals("/")){
			return 3;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="2,10,6,3,/,-,7,*,+";
//		int res=expressionCalculation(str);
//		System.out.println(res);
		
//		String s="-56";
//		System.out.println(Integer.parseInt(s));
	}

}
