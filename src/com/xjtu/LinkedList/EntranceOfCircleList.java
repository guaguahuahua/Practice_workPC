package com.xjtu.LinkedList;

/**
 * 找到环的入口节点
 * @author Administrator
 *
 */
public class EntranceOfCircleList {

	/**
	 * 链表中存在环，使用双指针的方式
	 * @param head
	 * @return
	 */
	public static Node entranceOfCircleList(Node head) {
		if(head==null) {
			return null;
		}
		Node fast=head;
		Node slow=head;
		//首先让两个指针相遇
		while(fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast) {
				break;
			}
		}
		if(fast==null) {
			return null;
		}else if(fast==slow && fast!=null) {
			slow=head;
			while(slow!=fast) {
				slow=slow.next;
				fast=fast.next;
			}
			return fast;
		}
		return null;
	}
	
	/**
	 * 使用断链法，每访问一个节点，就将该节点从链表上断开，如果存在环，那么最后一点会返回到环的入口节点
	 * 这种方式会破坏链表的结构
	 * @param head
	 * @return
	 */
	public static Node entranceOfCircleList_1(Node head) {
		
		if(head==null) {
			return head;
		}
		Node cur=head;
		Node pre;
		while(cur.next!=null) {
			pre=cur;
			cur=cur.next;
			pre.next=null;
		}		
		return cur;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);
		Node n2=new Node(1);
		Node n3=new Node(2);
		Node n4=new Node(3);
		Node n5=new Node(4);
		Node n6=new Node(5);
		Node n7=new Node(6);
		
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n4;
		Node res=entranceOfCircleList_1(head);
		System.out.println(res.data);
	}

}
