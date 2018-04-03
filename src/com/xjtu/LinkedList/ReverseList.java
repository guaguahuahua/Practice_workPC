package com.xjtu.LinkedList;

public class ReverseList {

	/**
	 * �����ԭ������
	 * @param head
	 * @return
	 */
	public static Node reverseList(Node head) {
		//���ڵ㴦��
		if(head.next==null){
			return head;
		}
		Node p=head.next;
		Node q=p.next;
		//����һ���ڵ���Ϊβ�ڵ�
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
	 * �ϲ�������������
	 * ʹ�÷���������ָ�룬һ��ָ���������ߣ�һ������ָ��Ƚϵ�Ԫ��
	 * @param head1
	 * @param head2
	 */
	public static void mergeTwoLists(Node head1, Node head2) {
		
		//�ȿ��ǳ����������
		Node pre1=null;
		//�������ͷ���������������ͷ��С���Ǹ�
		Node head=(head1.data > head2.data ? head2 : head1);
		
		while(head1!=null && head2!=null) {
			if(head1.data<head2.data) {
				pre1=head1;
				head1=head1.next;				
			}else {
				pre1.next=head2;
				//����h1��h2��λ��
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
