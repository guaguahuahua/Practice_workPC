package com.xjtu.algorithm;

import com.xjtu.tree.Node;

/**
 * 复杂链表的复制，复杂链表有两个指针域，
 * 一个用于存储常规指针，一个用于存储指向任意节点的指针
 * @author Administrator
 *
 */
public class CopyTheLinkedList {

	/**
	 * 使用二叉树的结构作为复杂链表的单个节点结构
	 * 我们认为left指向的是正常的序列，而right指向的是一个任意的节点
	 * 我们首先复制left的指向的序列，再复制right指向的序列
	 * @param head
	 */
	public static Node copyTheLinkedList(Node head) {
		//第一次复制常规节点
		Node first=head, second=head;
		Node pre=null, newHead = null;
		boolean isHead=true;
		while(first!=null) {

			Node t=new Node(first.letter);
			if(isHead) {
				newHead=t;
				isHead=false;
			}
			if(pre!=null) {
				pre.left=t;
			}
			pre=t;
			first=first.left;
		}
		
//		show(newHead);
		//需要两个指针，一个指向被复制链表，另一个指向复制的链表，主要是控制特殊指针指向的对象；
		//指向复制链表的表头
		Node nHead=newHead;
		//指向
		//第二次复制特殊指针
		while(second!=null) {
			if(second.right!=null) {
				//获得特殊指针节点
				Node sp=second.right;
				Node s=head;
				Node nh=newHead;
				//通过正常的指针找到特殊节点的位置
				while(s.letter!=sp.letter) {
					s=s.left;
					nh=nh.left;
				}
				nHead.right=nh;
				
			}else {
				nHead.right=null;
			}
			second=second.left;
			nHead=nHead.left;
		}
		return newHead;
	}
	
	
	public static void show(Node head) {
		Node h=head;
		while(h!=null) {
			System.out.print(h.letter+"\t");
			h=h.left;
		}
		System.out.println();
	}
	
	public static void nodeShow(Node node) {
		if(node!=null) {
			if(node.right!=null) {
				System.out.print(node.right.letter+"\t");
			}else {
				System.out.print("null"+"\t");
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node('a');
		Node n1=new Node('b');
		Node n2=new Node('c');
		Node n3=new Node('d');
		Node n4=new Node('e');
		
		head.left=n1;
		n1.left=n2;
		n2.left=n3;
		n3.left=n4;
		
		head.right=n2;
		n1.right=n4;
		n2.right=null;
		n3.right=n1;
		n4.right=null;
		Node h=copyTheLinkedList(head);
		while(h!=null) {
			nodeShow(h);
			h=h.left;
		}

	}

}
