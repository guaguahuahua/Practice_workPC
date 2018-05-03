package com.xjtu.LinkedList;

import java.util.LinkedList;

/**
 * ������������Ĺ�ͬ�ڵ�
 * @author Administrator
 *
 */
public class FindTheFirstNodeOfTwoLinkedList {

	/**
	 * ��������������ȣ����ݳ��Ȳ����±������õ��ĵ�һ����ͬ�ڵ��ֵ���ǹ�ͬ�ڵ�
	 * @param h1
	 * @param h2
	 * @return
	 */
	public static Node findTheFirstNodeOfTwoLinkedList(Node h1, Node h2) {

		if(h1==null || h2==null) {
			return null;
		}
		//���Ȼ����������ĳ���
		int len1=0, len2=0;
		Node head1=h1, head2=h2;
		while(head1!=null) {
			head1=head1.next;
			len1++;
		}
		while(head2!=null) {
			head2=head2.next;
			len2++;
		}
		int delta=(int) Math.abs(len1-len2);
		//��ýϳ�������ͷ���
		Node head=len1>len2 ? h1 : h2;
		//��ý϶̵�����ͷ���
		Node h=(head==h1) ? h2 : h1;
		while(delta>0) {
			head=head.next;
			delta--;
		}
		while(head!=null && h!=null && head.data!=h.data) {
			head=head.next;
			h=h.next;
		}
		return head;
	}
	
	/**
	 * ʹ���Ҷ���ķ�ʽ��������������н��㣬��ô���������״��Y�͵ģ���
	 * ֻҪ�Ҷ˶��룬��ô�����ҵ��ý���
	 * ʹ��ջ��ʵ��
	 * 2��������ջ��ÿ�γ�ջһ��Ԫ�أ��жϳ�ջԪ���Ƿ���ͬ�������ͬ��������ջ
	 * �����ͬ�����ص�ǰ�ڵ��next�ڵ㼴��
	 * @param h1
	 * @param h2
	 * @return
	 */
	public static Node findTheFirstNodeOfTwoLinkedList_1(Node h1, Node h2){
		
		
		LinkedList<Node> stack1=new LinkedList<Node>();
		LinkedList<Node> stack2=new LinkedList<Node>();
		while(h1!=null) {
			stack1.push(h1);
			h1=h1.next;
		}
		while(h2!=null) {
			stack2.push(h2);
			h2=h2.next;
		}
		Node pre1=stack1.pop();
		Node pre2=stack2.pop();
		while(pre1.data==pre2.data) {
			pre1=stack1.pop();
			pre2=stack2.pop();
		}
		
		return pre1.next;
	}
	
	/**
	 * ����������ƴ��������ͨ��
	 * @param h1
	 * @param h2
	 * @return
	 */
	public static Node findTheFirstNodeOfTwoLinkedList_2(Node h1, Node h2){
		
		Node head1=h1;
		Node head2=h2;
		//����������ֱ�ƴ������
		while(head1.next!=null) {
			head1=head1.next;
		}
		head1.next=h2;
		while(head2.next!=null) {
			head2=head2.next;
		}
		head2.next=h1;
		//������
		while(h1.data!=h2.data) {
			h1=h1.next;
			h2=h2.next;
		}
		return h1;
	}
	
	
	public static void show(Node head) {
		Node h=head;
		while(h!=null) {
			System.out.print(h.data+"\t");
			h=h.next;
		}
		System.out.println();
	}
	
	public static void main(String []args) {
		Node h1=new Node(1);
		Node n1=new Node(3);
		Node n2=new Node(5);
		Node n3=new Node(9);
		Node n4=new Node(8);
		h1.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
//		show(h1);
		Node h2=new Node(6);
		Node n21=new Node(2);
		Node n22=new Node(4);
		h2.next=n21;
		n21.next=n22;
		n22.next=n2;
//		show(h2);
		
		Node res=findTheFirstNodeOfTwoLinkedList_1(h1, h2);
		System.out.println(res.data);
	}
}
