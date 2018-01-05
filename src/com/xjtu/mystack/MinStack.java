package com.xjtu.mystack;

import com.xjtu.LinkedList.Node;

/**
 * 该栈的目的是在O(1)的时间复杂度内实现得到栈内的最小值
 * @author Administrator
 *
 */
public class MinStack {
	LinkedStack data; //存放所有数据
	LinkedStack minValue; //存放当前最小值
	
	//初始化两个栈，
	public MinStack() {
		data=new LinkedStack();
		minValue=new LinkedStack();
	}
	
	/**
	 * 获取当前堆栈的长度
	 * @return int
	 */
	public synchronized int getLength() {
		return data.getLength();
	} 
	
	/**
	 * 判断栈是否为空
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		return data.isEmpty();
	}
	
	/**
	 * 获取当前栈顶元素
	 * @return Node
	 */
	public synchronized Node peek() {
		return data.peek();
	}
	
	/**
	 * 入栈
	 * @return boolean
	 */
	public synchronized boolean push(Node node) {
		//判断一下最小栈是否为空，为空则将该元素作为最小值入最小栈
		//如果不为空，查看一下最小栈的栈顶元素的和当前元素的大小，如果当前元素小，那么入最小栈，否则最小栈不进行操作
		if(minValue.isEmpty()) {
			minValue.push(node);
		}else {
			//只有比最小栈的栈顶元素小的，才能入栈
			if(node.data<minValue.peek().data) {
				minValue.push(node);
			}
		}
		//数据存放栈添加数据
		data.push(node);
		return true;
	}
	
	/**
	 * 出栈
	 * @return Node
	 */
	public synchronized Node pop() {
		//存放返回值
		Node res=null;
		//如果数据栈为空，那么直接放回空值
		if(data.isEmpty()) {
			return null;
		}
		//如果数据栈出栈元素与当前最小栈栈顶元素相同，那么数据栈出栈同时，最小栈也同时出栈
		if(data.peek().data==minValue.peek().data) {
			res=data.pop();
			minValue.pop();
			
		//如果数据栈和最小栈的栈顶元素不同，那么最小栈不进行操作	
		}else {
			res=data.pop();
		}
		return res;
	}
	
	/**
	 * 获取当前栈的最小值
	 * @return int
	 */
	public synchronized Node getCurrentMinvalue() {
		//存放当前栈的最小值
		Node top=null;
		if(data.isEmpty()) {
			return null;
		}else {
			top=minValue.peek();
		}
		return top;
	}
	
	
	/**
	 * 测试以上方法
	 * @param args
	 */
	public static void main(String []args) {
		MinStack stack=new MinStack();
		stack.push(new Node(1));
		stack.push(new Node(2));
		stack.push(new Node(3));
		stack.push(new Node(-3));
		stack.pop();
		stack.push(new Node(-6));
		System.out.println("当前栈是否为空："+stack.isEmpty());
		System.out.println("当前栈的高度："+stack.getLength());
		Node res=stack.getCurrentMinvalue();
		if(res!=null) {
			System.out.println("当前栈的最小值为："+res.data);
		}else {
			System.out.println("当前栈为空！");
		}
	}
	
}

