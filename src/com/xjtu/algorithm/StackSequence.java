package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * 给两个栈的序列，第一个为入栈序列，判断第二个序列是否为第一个序列的出栈序列
 * @author Administrator
 *
 */
public class StackSequence {

	/**
	 * 给定一个栈，如果栈顶元素和出栈序列元素不同，那么继续入栈，直到栈顶元素和出栈序列的元素相同是出栈
	 * 最终判定栈是否为空了，如果栈不为空，那么说明序列2不是序列1的出栈序列
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean stackSequence(int []a, int []b) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		int l=0,r=0;
		stack.push(a[l]);
		l++;
		while(!stack.isEmpty()) {
			if(stack.peek()==b[r]) {
				stack.pop();
				r++;
			}else {
				stack.push(a[l]);
				l++;
			}
		}
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;	
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= {1,2,3,4,5};
		int []b= {4,5,3,2,1};
		boolean res=stackSequence(a, b);
		System.out.println(res);
	}

}
