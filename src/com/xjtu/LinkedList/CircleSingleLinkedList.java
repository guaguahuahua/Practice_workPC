package com.xjtu.LinkedList;

import com.xjtu.interview.FindKthToTail;

public class CircleSingleLinkedList {

	/**
	 * 创建循环单链表
	 * @param len	int 	链表长度
	 * @return
	 */
	public static Node createCircleList(int len) {
		//带头结点的循环单链表
		Node head=new Node(Integer.MIN_VALUE);
		Node rear=head;
		//使用尾插法
		for(int i=0; i<len; i++) {
			Node node=new Node(i+1);
			rear.next=node;
			rear=node;
		}
		//让尾指针指向头结点
		rear.next=head.next;
		return head.next;
	}
	
	public static void show(Node head, int len) {
		Node h=head;
		while(len>0) {
			System.out.print(h.data+"\t");
			h=h.next;
			len--;
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len=7;
		show(createCircleList(len), len);
		
	}

}
