package com.xjtu.LinkedList;

import com.xjtu.interview.FindKthToTail;

public class CircleSingleLinkedList {

	/**
	 * ����ѭ��������
	 * @param len	int 	������
	 * @return
	 */
	public static Node createCircleList(int len) {
		//��ͷ����ѭ��������
		Node head=new Node(Integer.MIN_VALUE);
		Node rear=head;
		//ʹ��β�巨
		for(int i=0; i<len; i++) {
			Node node=new Node(i+1);
			rear.next=node;
			rear=node;
		}
		//��βָ��ָ��ͷ���
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
