package com.xjtu.mystack;

import com.xjtu.LinkedList.Node;

/**
 * 使用头插法实现链式栈
 * @author Administrator
 *
 */
public class LinkedStack {

	private Node head; //链式堆栈需要一个头结点来实现
	private int length=0; //栈的高度
	
	/**
	 * 在建立链栈的时候初始化一下头结点
	 */
	public LinkedStack() {
		head=new Node(0);
	}
	
	/**
	 * 获取链栈的长度
	 * @return int 
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * 判断栈是否为空
	 * @return boolean 
	 */
	public synchronized boolean isEmpty() {
		if(head.next==null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 入栈
	 * @param node
	 * @return boolean
	 */
	public synchronized boolean push(Node node) {
		//头插法入栈
		node.next=head.next;
		head.next=node;
		length++;
		return true;
	}
	
	/**
	 * 出栈,头删法
	 * @return boolean 
	 */
	public synchronized Node pop() {
		
		if(head.next==null) {
			System.out.println("栈已空！");
			return null;
		}
		Node r=head.next; //取出该节点
		head.next=head.next.next; // 在栈中删除该元素
		length--;
		return r;
	}
	
	/**
	 * 返回栈顶的元素
	 * @return Node
	 */ 
	public synchronized Node peek() {
		
		return head.next;
	}
	
	/**
	 * 测试上面的各类方法
	 * @param args
	 */
	public static void main(String []args) {
		LinkedStack stack=new LinkedStack();
		
		stack.push(new Node(1));
		stack.push(new Node(2));
		stack.push(new Node(3));
		System.out.println("栈是否为空："+stack.isEmpty());
		System.out.println("栈的高度："+stack.getLength());
		System.out.println("栈顶元素："+stack.peek().data);
		Node res=stack.pop();
		System.out.println("出栈元素为："+res.data);
		System.out.println("栈顶元素："+stack.peek().data);
		
	}
}
