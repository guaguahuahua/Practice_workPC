package com.xjtu.LinkedList;

import java.util.ArrayList;

public class HasJoint {

	/**
	 * �ж����������Ƿ��н��㣬ʹ�ó��Ȳ�
	 * ����н�����ڣ���ô��β��ͷ�Ŀ���һ������ͬ�Ĳ��֣�
	 * ��ô��β����ͷ���ļ�����������ĳ�����ͬ�������±���
	 * ��һ����ַ��ͬ�Ľڵ�Ϊ������Ľ���
	 * @param head1	Node	 
	 * @param head2	Node	
	 * @return
	 */
	public static boolean hasJoint(Node head1, Node head2) {
		
		//���������Ϊ��
		if(head1==null || head2==null) {
			return false;
		}
		
		//���Ȼ����������ĳ���
		Node h1=head1;
		Node h2=head2;
		int len1=0, len2=0;
		while(h1!=null) {
			h1=h1.next;
			len1++;
		}
		while(h2!=null) {
			h2=h2.next;
			len2++;
		}
		
		//��ó��Ȳ�
		int delta=Math.abs(len1-len2);
		//�ó���ͷָ������
		Node l= (len1>=len2) ? head1 : head2;
		Node s= (l==head1) ? head2 : head1;
		while(delta>0) {
			l=l.next;
			delta--;
		}
		//�����ȽϽڵ�ĵ�ֵַ����һ����ͬ��Ԫ��Ϊ����
		while(s!=null) {
			if(s==l) {
				return true;
			}
			s=s.next;
			l=l.next;
		}
		return false;
	}
	
	/**
	 * ʹ�ô��ڵ����÷���
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static boolean hasJoint_1(Node head1, Node head2) {
		
		//���Ȼ����������ĳ���
		Node h1=head1, h2=head2;
		int len1=0, len2=0;
		while(h1!=null) {
			h1=h1.next;
			len1++;
		}
		while(h2!=null) {
			h2=h2.next;
			len2++;
		}
		//����������������
		Node l=(len1>=len2) ? head1 : head2;
		ReverseLinkedList.reverse(l);
		//�ж�δ�����õ�����ĳ���
		Node s=(l==head1) ? head2 : head1;
		int length=0;
		while(s!=null) {
			length++;
			s=s.next;
		}
		//������ý���֮������ĳ���û�з����ı䣬��ô��û�н���
		if(length==len1 || length==len2) {
			return false;
		}
		return true;
	}
	
	public static boolean circleJoint(Node head1, Node head2) {
		
		Node e1=HasCircle.hasCircle(head1);
		Node e2=HasCircle.hasCircle(head2);
		
		if(e1!=null) {
			//�������1�Ļ��ĳ���
			ArrayList<Character> list=new ArrayList<Character>();
			
			list.add(e1.letter);
			int len=1;
			Node node=e1.next;
			while(node!=e1) {
				list.add(node.letter);
				len++;
				node=node.next;
			}
			//��������2
			Node node2=e2.next;
			while(len>0 && node2!=e2) {
				if(list.contains(node2.letter)) {
					len--;
				}
				node2=node2.next;
			}
			if(list.contains(node2.letter)) {
				len--;
			}
			//�ж�����listԪ���Ƿ���ȫ������
			if(len==0) {
				return true;
			}
		}
		
		return false;
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
		
		Node head2=new Node('K');
		Node n21=new Node('M');
		Node n22=new Node('G');
		head2.next=n21;
		n21.next=n22;
		n22.next=n13;
		
//		boolean res=hasJoint_1(head1, head2);
//		System.out.println(res);
		boolean res=circleJoint(head1, head2);
		System.out.println(res);
	}

}
