package com.xjtu.mystack;

import java.util.Arrays;
import java.util.Stack;

/**
 * ���ʵ��һ��˳���ջ
 * @author Administrator
 */
public class MyStack {
	Object data[]; //��ջ�п��Դ��100��Ԫ��
	int top=-1; //ջ���ĸ߶�
	
	/**
	 * ���캯�� 
	 */
	public MyStack() {
		data=new Object[10];
//		top=-1;
	}	
	
	/**
	 * �ж϶�ջ�Ƿ�Ϊ�գ�Ϊ�շ���true����Ϊ�շ���false
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
	 * ��ö�ջ�ĸ߶�
	 * @return int
	 */
	public int getLength() {
		return top+1;
	}
	
	/**
	 * �鿴��ǰ��ջ��Ԫ��
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
	 * ��˳��ջ�з���Ԫ�أ��ɹ�����true��ʧ�ܷ���false
	 * @param obj Objcet����
	 * @return boolean
	 */
	public boolean push(Object obj) {
		//�����ж�һ�µ�ǰ�ĳ����ܷ��ŵ�����Ԫ�أ�����治�£���ô�ͻ��Զ�������10����λ�Ŀռ�
		ensureCapacity(top+1);
		data[++top]=obj;
		return true;
	}
	
	/**
	 * ��ջ
	 * @return Object
	 */
	public Object pop() {
		
		if(top==-1) {
			System.out.println("ջ�ѿ�");
			return null;
		}
		Object obj=data[top--];
		return obj;
	}
	
	/**
	 * ���ջ���������Զ�����ռ�
	 * @param size
	 */
	private void ensureCapacity(int size) {
		
		if(size>=data.length) {
			int newLen=data.length+10; //��ԭ���Ļ���������10��Ԫ�س���
			data=Arrays.copyOf(data, newLen);
		}
	}
	
	
	public static void main(String []args) {
		MyStack stack=new MyStack();
		//�ж�ջ�ǲ���Ϊ��
		System.out.println("ջ�Ƿ�Ϊ�գ� "+stack.isEmpty());
		//��ջ
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
		System.out.println("ջ�Ƿ�Ϊ�գ� "+stack.isEmpty());
		System.out.println("ջ��Ԫ��Ϊ�� "+stack.peek());
		System.out.println("ջ�ĸ߶ȣ�     "+stack.getLength());
		stack.push(11);

		System.out.println();
		System.out.println("ջ�Ƿ�Ϊ�գ� "+stack.isEmpty());
		System.out.println("ջ��Ԫ��Ϊ�� "+stack.peek());
		System.out.println("ջ�ĸ߶ȣ�     "+stack.getLength());
		Stack stack1=new Stack();
	}
}
