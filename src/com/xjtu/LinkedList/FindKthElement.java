package com.xjtu.LinkedList;

/**
 * Ѱ�������е�k��Ԫ��
 * 1. ʹ������ָ�룻
 * 2. ��������ܳ��ȼ�ȥk
 * @author Administrator
 *
 */
public class FindKthElement {

	/**
	 * ������ĵ�����k��Ԫ�أ�ʹ�ó��Ȳ
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node findKthElement(Node head, int k) {
		//�жϳ�ʼ����
		if(head==null) {
			return null;
		}
		int length=0;
		Node h=head;
		//���������ó���
		while(h!=null) {
			h=h.next;
			length++;
		}
		//�жϲ���k�Ƿ�Խ��
		if(length<k) {
			System.out.println("����k����������ĳ���");
			return null;
		}
		//Ѱ�ҵ�k��Ԫ��
		int delta=length-k;
		Node hh=head;
		while(delta>0) {
			hh=hh.next;
			delta--;
		}
		return hh;
	}
	
	/**
	 * ������ĵ�����k��Ԫ�أ�ʹ��˫ָ�뷨
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node findKthElement_1(Node head, int k) {
		Node left=head;
		Node right=head;
		int delta=k;
		//��ָ������k��
		while(delta>0 && right!=null) {
			right=right.next;
			delta--;
		}
		if(delta>0) {
			System.out.println("����k���������ȣ�");
			return null;
		}
		//����ָ�뵽������ĩβ��ʱ����ָ��ָ����ǵ�����k��Ԫ��
		while(right!=null) {
			right=right.next;
			left=left.next;
		}		
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ʹ�õ��Ǵ�ͷ���ĵ�����
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
