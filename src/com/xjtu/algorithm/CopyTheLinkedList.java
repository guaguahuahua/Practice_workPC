package com.xjtu.algorithm;

import com.xjtu.tree.Node;

/**
 * ��������ĸ��ƣ���������������ָ����
 * һ�����ڴ洢����ָ�룬һ�����ڴ洢ָ������ڵ��ָ��
 * @author Administrator
 *
 */
public class CopyTheLinkedList {

	/**
	 * ʹ�ö������Ľṹ��Ϊ��������ĵ����ڵ�ṹ
	 * ������Ϊleftָ��������������У���rightָ�����һ������Ľڵ�
	 * �������ȸ���left��ָ������У��ٸ���rightָ�������
	 * @param head
	 */
	public static Node copyTheLinkedList(Node head) {
		//��һ�θ��Ƴ���ڵ�
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
		//��Ҫ����ָ�룬һ��ָ�򱻸���������һ��ָ���Ƶ�������Ҫ�ǿ�������ָ��ָ��Ķ���
		//ָ��������ı�ͷ
		Node nHead=newHead;
		//ָ��
		//�ڶ��θ�������ָ��
		while(second!=null) {
			if(second.right!=null) {
				//�������ָ��ڵ�
				Node sp=second.right;
				Node s=head;
				Node nh=newHead;
				//ͨ��������ָ���ҵ�����ڵ��λ��
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
