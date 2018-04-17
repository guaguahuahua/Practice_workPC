package com.xjtu.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PrintListFromEnd {

	/**
	 * 从链表的尾部逆向打印链表的所有节点的值
	 * 3种方式，不修改链表的结构，使用栈的方式；第二种是将整个链表进行逆置；
	 * 第三种，使用递归的方式实现
	 * @param head
	 * @return
	 */
	public static Node printListFromEnd(Node head) {
		
		Node newHead=reverse(head);
		show(newHead);
		return null;
	}
	
	/**
	 * 将整个链表进行逆置
	 * @param head
	 * @return
	 */
	public static Node reverse(Node head) {
		
		if(head.next==null) {
			return head;
		}
		
		Node p=head.next;
		Node q=p.next;
		head.next=null;
		while(p!=null) {
			p.next=head;
			head=p;
			p=q;
			if(q!=null) {
				q=q.next;
			}
		}
		
		return head;
	}
	
	public static void show(Node head) {
		Node h=head;
		while(h!=null) {
			System.out.print(h.data+"\t");
			h=h.next;
		}
		System.out.println();
	}
	
	/**
	 * 使用栈结构，第一次遍历将元素添加到栈中， 第二次将栈中的元素全部出战
	 * @param head
	 */
	public static void printListFromEnd_1(Node head) {
		List<Integer> list=new ArrayList<Integer>();
		Node h=head;
		while(h!=null) {
			list.add(h.data);
			h=h.next;
		}
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i)+"\t");
		}
	}
	
	/**
	 * 使用递归的方式实现从头到尾打印链表
	 * 尝试了一下实现不了
	 * @param head
	 */
	public static void printListFromEnd_2(Node head) {
		
		if(head.next==null) {
			System.out.print(head.data+"\t");
		}else {
			printListFromEnd_2(head.next);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
//		show(head);
		printListFromEnd_2(head);
		
		
		
//		Node res=reverse(head);
//		show(res);
		
	}

}
