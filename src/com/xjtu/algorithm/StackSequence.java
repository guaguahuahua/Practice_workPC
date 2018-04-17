package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * ������ջ�����У���һ��Ϊ��ջ���У��жϵڶ��������Ƿ�Ϊ��һ�����еĳ�ջ����
 * @author Administrator
 *
 */
public class StackSequence {

	/**
	 * ����һ��ջ�����ջ��Ԫ�غͳ�ջ����Ԫ�ز�ͬ����ô������ջ��ֱ��ջ��Ԫ�غͳ�ջ���е�Ԫ����ͬ�ǳ�ջ
	 * �����ж�ջ�Ƿ�Ϊ���ˣ����ջ��Ϊ�գ���ô˵������2��������1�ĳ�ջ����
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
