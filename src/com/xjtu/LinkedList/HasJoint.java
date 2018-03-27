package com.xjtu.LinkedList;

import java.util.ArrayList;

public class HasJoint {

	/**
	 * 判断两个链表是否有交点，使用长度差
	 * 如果有交点存在，那么从尾到头的看，一定有相同的部分，
	 * 那么从尾部到头部的剪，两个链表的长度相同的情形下遍历
	 * 第一个地址相同的节点为两链表的交点
	 * @param head1	Node	 
	 * @param head2	Node	
	 * @return
	 */
	public static boolean hasJoint(Node head1, Node head2) {
		
		//如果有链表为空
		if(head1==null || head2==null) {
			return false;
		}
		
		//首先获得两个链表的长度
		Node h1=head1;
		Node h2=head2;
		int len1=0, len2=0;
		while(h1!=null) {
			h1=h1.next;
			len1++;
		}
		while(h2!=null) {
			h2=h2.next;
			len2++;
		}
		
		//获得长度差
		int delta=Math.abs(len1-len2);
		//让长链头指针先走
		Node l= (len1>=len2) ? head1 : head2;
		Node s= (l==head1) ? head2 : head1;
		while(delta>0) {
			l=l.next;
			delta--;
		}
		//挨个比较节点的地址值，第一个相同的元素为交点
		while(s!=null) {
			if(s==l) {
				return true;
			}
			s=s.next;
			l=l.next;
		}
		return false;
	}
	
	/**
	 * 使用存在的逆置方法
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static boolean hasJoint_1(Node head1, Node head2) {
		
		//首先获得两个链表的长度
		Node h1=head1, h2=head2;
		int len1=0, len2=0;
		while(h1!=null) {
			h1=h1.next;
			len1++;
		}
		while(h2!=null) {
			h2=h2.next;
			len2++;
		}
		//用最长的链表进行逆置
		Node l=(len1>=len2) ? head1 : head2;
		ReverseLinkedList.reverse(l);
		//判断未被逆置的链表的长度
		Node s=(l==head1) ? head2 : head1;
		int length=0;
		while(s!=null) {
			length++;
			s=s.next;
		}
		//如果逆置结束之后链表的长度没有发生改变，那么就没有交叉
		if(length==len1 || length==len2) {
			return false;
		}
		return true;
	}
	
	public static boolean circleJoint(Node head1, Node head2) {
		
		Node e1=HasCircle.hasCircle(head1);
		Node e2=HasCircle.hasCircle(head2);
		
		if(e1!=null) {
			//获得链表1的环的长度
			ArrayList<Character> list=new ArrayList<Character>();
			
			list.add(e1.letter);
			int len=1;
			Node node=e1.next;
			while(node!=e1) {
				list.add(node.letter);
				len++;
				node=node.next;
			}
			//搜索链表2
			Node node2=e2.next;
			while(len>0 && node2!=e2) {
				if(list.contains(node2.letter)) {
					len--;
				}
				node2=node2.next;
			}
			if(list.contains(node2.letter)) {
				len--;
			}
			//判断最后的list元素是否完全被遍历
			if(len==0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1=new Node('A');
		Node n11=new Node('B');
		Node n12=new Node('C');
		Node n13=new Node('D');
		Node n14=new Node('E');
		head1.next=n11;
		n11.next=n12;
		n12.next=n13;
		n13.next=n14;
		n14.next=n12;
		
		Node head2=new Node('K');
		Node n21=new Node('M');
		Node n22=new Node('G');
		head2.next=n21;
		n21.next=n22;
		n22.next=n13;
		
//		boolean res=hasJoint_1(head1, head2);
//		System.out.println(res);
		boolean res=circleJoint(head1, head2);
		System.out.println(res);
	}

}
