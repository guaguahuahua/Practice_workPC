package com.xjtu.LinkedList;

/**
 * 删除单链表中重复节点，链表已经有序
 * @author Administrator
 *
 */
public class DeleteRepeatedNodes {

	/**
	 * 使用两个指针，判断相邻的两个节点是否为相同节点
	 * 如果是右指针移动，如果不是，左指针移动
	 * @param head
	 * @return
	 */
	public static Node deleteRepeatedNodes(Node head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		Node left=head;
		Node right=left.next;
		while(right!=null){
			if(left.data==right.data) {
				right=right.next;
			}else {
				left.next=right;
				left=right;
			}
		}		
		return head;
	}
	
	public static void show(Node head) {
		Node h=head;
		while(h!=null){
			System.out.print(h.data+"\t");
			h=h.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(1);
		Node n2=new Node(1);
		Node n3=new Node(1);
		Node n4=new Node(1);
		Node n5=new Node(4);
		Node n6=new Node(4);
		Node n7=new Node(5);
		
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		show(head);
		Node res=deleteRepeatedNodes(head);
		show(res);
	}

}
