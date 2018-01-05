package com.xjtu.mystack;

import com.xjtu.LinkedList.Node;

/**
 * ��ջ��Ŀ������O(1)��ʱ�临�Ӷ���ʵ�ֵõ�ջ�ڵ���Сֵ
 * @author Administrator
 *
 */
public class MinStack {
	LinkedStack data; //�����������
	LinkedStack minValue; //��ŵ�ǰ��Сֵ
	
	//��ʼ������ջ��
	public MinStack() {
		data=new LinkedStack();
		minValue=new LinkedStack();
	}
	
	/**
	 * ��ȡ��ǰ��ջ�ĳ���
	 * @return int
	 */
	public synchronized int getLength() {
		return data.getLength();
	} 
	
	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		return data.isEmpty();
	}
	
	/**
	 * ��ȡ��ǰջ��Ԫ��
	 * @return Node
	 */
	public synchronized Node peek() {
		return data.peek();
	}
	
	/**
	 * ��ջ
	 * @return boolean
	 */
	public synchronized boolean push(Node node) {
		//�ж�һ����Сջ�Ƿ�Ϊ�գ�Ϊ���򽫸�Ԫ����Ϊ��Сֵ����Сջ
		//�����Ϊ�գ��鿴һ����Сջ��ջ��Ԫ�صĺ͵�ǰԪ�صĴ�С�������ǰԪ��С����ô����Сջ��������Сջ�����в���
		if(minValue.isEmpty()) {
			minValue.push(node);
		}else {
			//ֻ�б���Сջ��ջ��Ԫ��С�ģ�������ջ
			if(node.data<minValue.peek().data) {
				minValue.push(node);
			}
		}
		//���ݴ��ջ�������
		data.push(node);
		return true;
	}
	
	/**
	 * ��ջ
	 * @return Node
	 */
	public synchronized Node pop() {
		//��ŷ���ֵ
		Node res=null;
		//�������ջΪ�գ���ôֱ�ӷŻؿ�ֵ
		if(data.isEmpty()) {
			return null;
		}
		//�������ջ��ջԪ���뵱ǰ��Сջջ��Ԫ����ͬ����ô����ջ��ջͬʱ����СջҲͬʱ��ջ
		if(data.peek().data==minValue.peek().data) {
			res=data.pop();
			minValue.pop();
			
		//�������ջ����Сջ��ջ��Ԫ�ز�ͬ����ô��Сջ�����в���	
		}else {
			res=data.pop();
		}
		return res;
	}
	
	/**
	 * ��ȡ��ǰջ����Сֵ
	 * @return int
	 */
	public synchronized Node getCurrentMinvalue() {
		//��ŵ�ǰջ����Сֵ
		Node top=null;
		if(data.isEmpty()) {
			return null;
		}else {
			top=minValue.peek();
		}
		return top;
	}
	
	
	/**
	 * �������Ϸ���
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
		System.out.println("��ǰջ�Ƿ�Ϊ�գ�"+stack.isEmpty());
		System.out.println("��ǰջ�ĸ߶ȣ�"+stack.getLength());
		Node res=stack.getCurrentMinvalue();
		if(res!=null) {
			System.out.println("��ǰջ����СֵΪ��"+res.data);
		}else {
			System.out.println("��ǰջΪ�գ�");
		}
	}
	
}

