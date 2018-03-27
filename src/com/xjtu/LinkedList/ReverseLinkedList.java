package com.xjtu.LinkedList;

public class ReverseLinkedList {

	public static Node reverse(Node head) {
		
		//ֻ��һ���ڵ��ֱ�ӷ���
		if(head.next==null) {
			return head;
		}
		//���������ڵ�
		Node h=head;
		Node p=head.next;
		Node q=p.next;
		while(p!=null){
			p.next=head;
			head=p;
			p=q;
			if(q!=null) {
				q=q.next;
			}else {
				break;
			}
		}
		//��ԭ����ͷ�����Ϊ��
		h.next=null;
		return head;
	}
	
	public static void show(Node head) {
		Node h=head;
		while(h!=null) {
			System.out.print(h.letter+"\t");
			h=h.next;			
		}
		System.out.println();
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
		
		show(head1);
		Node head=reverse(head1);
		show(head);
	}

}
