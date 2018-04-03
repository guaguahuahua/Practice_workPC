package com.xjtu.LinkedList;

public class ReverseList {

	/**
	 * 链表的原地逆置
	 * @param head
	 * @return
	 */
	public static Node reverseList(Node head) {
		//单节点处理
		if(head.next==null){
			return head;
		}
		Node p=head.next;
		Node q=p.next;
		//将第一个节点置为尾节点
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
	 * 合并两个有序单链表
	 * 使用方法：两个指针，一个指针用来连线，一个用来指向比较的元素
	 * @param head1
	 * @param head2
	 */
	public static void mergeTwoLists(Node head1, Node head2) {
		
		//先考虑长链表的情形
		Node pre1=null;
		//新链表的头结点是两个链表中头较小的那个
		Node head=(head1.data > head2.data ? head2 : head1);
		
		while(head1!=null && head2!=null) {
			if(head1.data<head2.data) {
				pre1=head1;
				head1=head1.next;				
			}else {
				pre1.next=head2;
				//交换h1和h2的位置
				Node t=head1;
				head1=head2;
				head2=t;
			}
		}
		pre1.next=head2;
		
		show(head);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);
		Node n1=new Node(1);
		Node n2=new Node(3);
		Node n3=new Node(5);
		
		Node head2=new Node(2);
		Node n4=new Node(4);
		Node n5=new Node(6);
		Node n6=new Node(8);
		Node n7=new Node(10);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		
		head2.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
//		mergeTwoLists(head, head2);		
//		show(head);
//		show(reverseList(head));
		
		byte b1=1, b2=2, b3, b4;
		b3=(byte) (b1+b2);
		
	}

}
