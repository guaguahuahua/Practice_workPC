package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ���ջ����СԪ��
 * @author Administrator
 *
 */
public class MinStack {

	//ջ�ṹ
	LinkedList<Integer> stack=new LinkedList<Integer>();
	//�����СԪ
	ArrayList<Integer> min=new ArrayList<Integer>();
	
	/**
	 * ��ջ
	 * @param e
	 */
	public void push(int e) {
		stack.push(e);
		//��������СԪ�صļ���Ϊ�գ�ֱ�ӽ���Ԫ����ӽ�ȥ
		if(min.size()==0) {
			min.add(e);
		}else {
			//�ж���Ԫ���Ƿ��ǰ���Ԫ�ش�
			if(e>=min.get(min.size()-1)) {
				min.add(min.get(min.size()-1));
			}else {
				min.add(e);
			}
		}
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public int pop() {
		if(stack.isEmpty()) {
			System.out.println("ջ�ѿգ�");
			return -1;
		}
		//ջ��Ϊ��
		int res=stack.pop();
		min.remove(min.size()-1);
		return res;
	}
	
	/**
	 * ��õ�ǰջ�е���СԪ
	 * @return
	 */
	public int getMin() {
		if(min.isEmpty()) {
			System.out.println("ջ�ѿգ�");
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
