package com.xjtu.myqueue;

import com.xjtu.LinkedList.Node;
import com.xjtu.LinkedList.SingleLinkedList;

public class MyLinkedQueue {
	private SingleLinkedList queue; //���е�����
	private Node head;
	private Node tail;
	private int length;
	
	//������ĳ�ʼ��
	public MyLinkedQueue() {
		queue=new SingleLinkedList();
		head=queue.head; //�ö��е�ͷָ��Ϊָ���ָ�������ͷ���
		tail=queue.head;
		length=0; //������Ϊ0
	}
	
	/**
	 * �ж���ǰ�Ķ����Ƿ�Ϊ��
	 * @return
	 */
	public synchronized boolean isEmpty() {
		if(head==tail && length==0) {
			return true;
		}
		return false;
	}
	/**
	 * ��ȡ��ǰ��ʽ���еĳ���
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * �����
	 * @param node ��ӽڵ�
	 * @return boolean
	 */
	public synchronized boolean append(Node node) {
		
		//���
		node.next=tail.next;
		tail.next=node;
		tail=node;
		length++;
		return true;
	}
	
	/**
	 * ������
	 * @return Node
	 */
	public synchronized Node delete() {
		if(isEmpty()) {
			return null;
		}
		Node res=head.next; //��øýڵ�
		head.next=head.next.next; //ɾ����ǰͷ���
		length--;
		return res;
	}
	
	/**
	 * �鿴���еĶ�ͷԪ��
	 * @return Node 
	 */
	public synchronized Node peek() {
		//�����ǰ�Ķ���Ϊ��
		if(isEmpty()) {
			return null;
		}
		return head.next;
	}
	
	/**
	 * ��������ķ���
	 * @param args
	 */
	public static void main(String []args) {
		MyLinkedQueue queue=new MyLinkedQueue();
		queue.append(new Node(1));
		queue.append(new Node(2));
		queue.append(new Node(4));
		System.out.println("����Ϊ�գ�"+queue.isEmpty());
		System.out.println("����ͷԪ�أ�"+queue.peek().data);
		queue.delete();
		System.out.println("��ǰ��ͷԪ��Ϊ��"+queue.peek().data);
	}
}
