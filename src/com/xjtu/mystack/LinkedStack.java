package com.xjtu.mystack;

import com.xjtu.LinkedList.Node;

/**
 * ʹ��ͷ�巨ʵ����ʽջ
 * @author Administrator
 *
 */
public class LinkedStack {

	private Node head; //��ʽ��ջ��Ҫһ��ͷ�����ʵ��
	private int length=0; //ջ�ĸ߶�
	
	/**
	 * �ڽ�����ջ��ʱ���ʼ��һ��ͷ���
	 */
	public LinkedStack() {
		head=new Node(0);
	}
	
	/**
	 * ��ȡ��ջ�ĳ���
	 * @return int 
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * @return boolean 
	 */
	public synchronized boolean isEmpty() {
		if(head.next==null) {
			return true;
		}
		return false;
	}
	
	/**
	 * ��ջ
	 * @param node
	 * @return boolean
	 */
	public synchronized boolean push(Node node) {
		//ͷ�巨��ջ
		node.next=head.next;
		head.next=node;
		length++;
		return true;
	}
	
	/**
	 * ��ջ,ͷɾ��
	 * @return boolean 
	 */
	public synchronized Node pop() {
		
		if(head.next==null) {
			System.out.println("ջ�ѿգ�");
			return null;
		}
		Node r=head.next; //ȡ���ýڵ�
		head.next=head.next.next; // ��ջ��ɾ����Ԫ��
		length--;
		return r;
	}
	
	/**
	 * ����ջ����Ԫ��
	 * @return Node
	 */ 
	public synchronized Node peek() {
		
		return head.next;
	}
	
	/**
	 * ��������ĸ��෽��
	 * @param args
	 */
	public static void main(String []args) {
		LinkedStack stack=new LinkedStack();
		
		stack.push(new Node(1));
		stack.push(new Node(2));
		stack.push(new Node(3));
		System.out.println("ջ�Ƿ�Ϊ�գ�"+stack.isEmpty());
		System.out.println("ջ�ĸ߶ȣ�"+stack.getLength());
		System.out.println("ջ��Ԫ�أ�"+stack.peek().data);
		Node res=stack.pop();
		System.out.println("��ջԪ��Ϊ��"+res.data);
		System.out.println("ջ��Ԫ�أ�"+stack.peek().data);
		
	}
}
