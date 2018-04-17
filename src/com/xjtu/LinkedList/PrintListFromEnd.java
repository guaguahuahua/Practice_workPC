package com.xjtu.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PrintListFromEnd {

	/**
	 * �������β�������ӡ��������нڵ��ֵ
	 * 3�ַ�ʽ�����޸�����Ľṹ��ʹ��ջ�ķ�ʽ���ڶ����ǽ���������������ã�
	 * �����֣�ʹ�õݹ�ķ�ʽʵ��
	 * @param head
	 * @return
	 */
	public static Node printListFromEnd(Node head) {
		
		Node newHead=reverse(head);
		show(newHead);
		return null;
	}
	
	/**
	 * �����������������
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
	 * ʹ��ջ�ṹ����һ�α�����Ԫ����ӵ�ջ�У� �ڶ��ν�ջ�е�Ԫ��ȫ����ս
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
	 * ʹ�õݹ�ķ�ʽʵ�ִ�ͷ��β��ӡ����
	 * ������һ��ʵ�ֲ���
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
