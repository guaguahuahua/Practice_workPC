package com.xjtu.LinkedList;

/**
 * 寻找链表中第k个元素
 * 1. 使用两个指针；
 * 2. 获得链表总长度减去k
 * @author Administrator
 *
 */
public class FindKthElement {

	/**
	 * 求链表的倒数第k个元素，使用长度差法
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node findKthElement(Node head, int k) {
		//判断初始条件
		if(head==null) {
			return null;
		}
		int length=0;
		Node h=head;
		//遍历链表获得长度
		while(h!=null) {
			h=h.next;
			length++;
		}
		//判断参数k是否越界
		if(length<k) {
			System.out.println("参数k超出了链表的长度");
			return null;
		}
		//寻找第k个元素
		int delta=length-k;
		Node hh=head;
		while(delta>0) {
			hh=hh.next;
			delta--;
		}
		return hh;
	}
	
	/**
	 * 求链表的倒数第k个元素，使用双指针法
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node findKthElement_1(Node head, int k) {
		Node left=head;
		Node right=head;
		int delta=k;
		//快指针先走k步
		while(delta>0 && right!=null) {
			right=right.next;
			delta--;
		}
		if(delta>0) {
			System.out.println("参数k超过链表长度！");
			return null;
		}
		//当快指针到达链表末尾的时候，慢指针指向的是倒数第k个元素
		while(right!=null) {
			right=right.next;
			left=left.next;
		}		
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//这块使用的是带头结点的单链表
		Node head=new Node(0);
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);
		Node n8=new Node(8);
		Node n9=new Node(9);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		n8.next=n9;
		
		Node res=findKthElement_1(head, 3);
		System.out.println(res.data);
	}

}
