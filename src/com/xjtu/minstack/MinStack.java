package com.xjtu.minstack;

import com.xjtu.LinkedList.Node;

/**
 * 链式堆栈，头插法
 * 通过维护单链表的形式来维护最小栈
 * @author Administrator
 * 
 */
public class MinStack {
	//存放栈容量
	public int size;
	//存放栈顶
	public Node top;
	
	public Node minNode;
	
	/**
	 * 初始化最小栈
	 */
	public MinStack() {
		this.size=0;
		this.top=null;
		this.minNode=null;
	}
	
	/**
	 * 入栈
	 * @param node
	 */
	public void push(Node node) {
		node.next=top;
		top=node;
		this.size++;
		minElePush(node);
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public Node pop() {
		Node t=null;
		//栈为空
		if(size==0) {
			System.out.println("栈已空！");
		//栈不为空	
		}else {
			t=top;
			top=top.next;
			t.next=null;
			size--;
			minElePop(t);
		}
		return t;
	}
	
	/**
	 * 求当前栈的最小值，维护单链表的形式
	 * 
	 * @return
	 */
	public void minElePush(Node node) {
		//如果栈为空，直接将输入元素作为最小元
		if(minNode==null) {
			minNode=node;
		//栈不为空的情况	
		}else {
			//如果入栈元素比最小值大，那么维护最小元素不变
			if(node.data>=minNode.data) {
				Node t=new Node(minNode.data);
				t.next=minNode;
				minNode=t;
			//如果入栈元素比当前的最小栈元素还要小	
			}else {
				Node t=new Node(node.data);
				t.next=minNode;
				minNode=t;
			}
		}
	}
	
	/**
	 * 出栈，同时维护单链表
	 * @param node	Node	出栈节点
	 */
	public void minElePop(Node node) {
		//栈为空的情形
		if(minNode==null) {
			System.out.println("栈已空！");
			return;
			
		//栈不为空的情形,直接删除当前链表首元素即可	
		}else {
			Node t=minNode;
			minNode=minNode.next;
			t.next=null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack stack=new MinStack();
		Node n1=new Node(5);
		stack.push(n1);
		stack.push(new Node(9));
		stack.push(new Node(2));
		stack.push(new Node(3));
		stack.push(new Node(5));
		stack.push(new Node(8));
		stack.push(new Node(1));

		//输出栈顶元素
		System.out.println(stack.top.data);
		System.out.println(stack.size);
		//当前最小元素
		System.out.println(stack.minNode.data);
		
		for(int i=stack.size; i>0; i--) {
			System.out.print(stack.pop().data+"\t");
			if(stack.minNode!=null) {
				System.out.print(stack.minNode.data+"\t");
			}else {
				System.out.print(null+"\t");
			}			
			System.out.print(stack.size+"\t");
			System.out.println();			
		}
		
	}

}
