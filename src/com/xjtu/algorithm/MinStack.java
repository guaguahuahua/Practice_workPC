package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 获得栈中最小元素
 * @author Administrator
 *
 */
public class MinStack {

	//栈结构
	LinkedList<Integer> stack=new LinkedList<Integer>();
	//存放最小元
	ArrayList<Integer> min=new ArrayList<Integer>();
	
	/**
	 * 入栈
	 * @param e
	 */
	public void push(int e) {
		stack.push(e);
		//如果存放最小元素的集合为空，直接将新元素添加进去
		if(min.size()==0) {
			min.add(e);
		}else {
			//判断新元素是否比前面的元素大
			if(e>=min.get(min.size()-1)) {
				min.add(min.get(min.size()-1));
			}else {
				min.add(e);
			}
		}
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		if(stack.isEmpty()) {
			System.out.println("栈已空！");
			return -1;
		}
		//栈不为空
		int res=stack.pop();
		min.remove(min.size()-1);
		return res;
	}
	
	/**
	 * 获得当前栈中的最小元
	 * @return
	 */
	public int getMin() {
		if(min.isEmpty()) {
			System.out.println("栈已空！");
			return -1;
		}
		return min.get(min.size()-1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack=new MinStack();
		minStack.push(1);
		minStack.push(2);
		minStack.push(5);
		minStack.push(8);
		minStack.push(0);
		
		minStack.pop();
		minStack.pop();
		minStack.pop();
		minStack.pop();
//		minStack.pop();
		
		int min=minStack.getMin();
		System.out.println(min);
	}

}
