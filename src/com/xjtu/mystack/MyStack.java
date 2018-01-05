package com.xjtu.mystack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 这块实现一个顺序堆栈
 * @author Administrator
 */
public class MyStack {
	Object data[]; //堆栈中可以存放100个元素
	int top=-1; //栈顶的高度
	
	/**
	 * 构造函数 
	 */
	public MyStack() {
		data=new Object[10];
//		top=-1;
	}	
	
	/**
	 * 判断堆栈是否为空，为空返回true，不为空返回false
	 * @return boolean
	 */
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 获得堆栈的高度
	 * @return int
	 */
	public int getLength() {
		return top+1;
	}
	
	/**
	 * 查看当前的栈顶元素
	 * @return
	 */
	public Object peek() {
		
		if(top==-1) {
			return null;
		}else {
			return data[top];
		}
	}
	
	/**
	 * 向顺序栈中放入元素，成功返回true，失败返回false
	 * @param obj Objcet类型
	 * @return boolean
	 */
	public boolean push(Object obj) {
		//首先判断一下当前的长度能否存放的下新元素，如果存不下，那么就会自动的申请10个单位的空间
		ensureCapacity(top+1);
		data[++top]=obj;
		return true;
	}
	
	/**
	 * 出栈
	 * @return Object
	 */
	public Object pop() {
		
		if(top==-1) {
			System.out.println("栈已空");
			return null;
		}
		Object obj=data[top--];
		return obj;
	}
	
	/**
	 * 如果栈已满，则自动申请空间
	 * @param size
	 */
	private void ensureCapacity(int size) {
		
		if(size>=data.length) {
			int newLen=data.length+10; //在原来的基础上增加10个元素长度
			data=Arrays.copyOf(data, newLen);
		}
	}
	
	
	public static void main(String []args) {
		MyStack stack=new MyStack();
		//判断栈是不是为空
		System.out.println("栈是否为空： "+stack.isEmpty());
		//入栈
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		System.out.println("栈是否为空： "+stack.isEmpty());
		System.out.println("栈顶元素为： "+stack.peek());
		System.out.println("栈的高度：     "+stack.getLength());
		stack.push(11);

		System.out.println();
		System.out.println("栈是否为空： "+stack.isEmpty());
		System.out.println("栈顶元素为： "+stack.peek());
		System.out.println("栈的高度：     "+stack.getLength());
		Stack stack1=new Stack();
	}
}
