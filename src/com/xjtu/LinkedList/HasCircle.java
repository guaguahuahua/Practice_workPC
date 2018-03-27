package com.xjtu.LinkedList;

public class HasCircle {

	public static Node hasCircle(Node head) {
		
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) {
				break;
			}
		}
		
		Node h=null;
		//如果有环，寻找环入口
		if(fast==slow) {
			h=head;
			while(h.letter!=fast.letter) {
				h=h.next;
				fast=fast.next;
			}
		}		
		return h;
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
		
		Node res=hasCircle(head1);
		System.out.println(res.letter);
	}

}
