package com.xjtu;

import java.util.ArrayList;
import java.util.List;

public class GetIntersectionNode {

	/**
	 * ����������������Ŀ�ʼ��
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		int len1=0;
		int len2=0;
		//��ȡ�����
		List get=hasIntersection(headA, headB);
		//������ĳ���Ϊ1��˵��û����
		if(1==get.size()) {
			return null;
		}else {
			//��ȡ����������ĳ���
			len1=(int) get.get(1);
			len2=(int) get.get(2);
		}
		//�õ�������ĳ��Ȳ���ϳ���ͷָ���ƶ���϶̵Ķ���
		int distance=Math.abs(len1-len2);
		//h1��¼�ϳ����Ǹ��������ָ��
		ListNode h1=null;
		ListNode h2=null;
		if(len1>len2) {
			h1=headA;
			h2=headB;			
		}else {
			h1=headB;
			h2=headA;
		}
		//�ƶ��ϳ������ͷָ��,�����˳�����������
		while(distance>0) {
			h1=h1.next;
			distance--;
		}
		//ͬʱ�ƶ�����ָ�룬��һ����ͬ�Ľڵ���ǽ����Ŀ�ʼ
		while(h1!=h2) {
			h1=h1.next;
			h2=h2.next;
		}
		return h1;
	}
	/**
	 * �����ж�������������û�н���
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static List hasIntersection(ListNode headA, ListNode headB) {
		List res=new ArrayList();
		if(headA==null || headB==null) {
			res.add(false);
			return res;
		}
		int length1=1;
		int length2=1;
				
		//��������������β�ڵ�
		while(headA.next!=null || headB.next!=null) {
			if(headA.next!=null) {
				headA=headA.next;
				length1++;
			}
			if(headB.next!=null) {
				headB=headB.next;
				length2++;
			}
		}
		if(headA==headB) {
			res.add(true);
			res.add(length1);
			res.add(length2);
			return res;
			
		}else {
			res.add(false);
			return res;
		}
	}
	
	/**
	 * ����ͷ���������Ԫ�ؽ������
	 * @param head
	 */
	public static void show(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"\t");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(7);
		ListNode l3=new ListNode(6);
		ListNode l4=new ListNode(3);
		ListNode l5=new ListNode(4);
		ListNode l6=new ListNode(5);
		ListNode l7=new ListNode(3);
		ListNode l8=new ListNode(9);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l7;
		l7.next=l8;
		
		
		ListNode s1=new ListNode(12);
		ListNode s2=new ListNode(22);
		ListNode s3=new ListNode(32);
		s1.next=s2;
		s2.next=s3;
//		s3.next=l1;
		
		//������1
		show(l1);
		//������2
		show(s1);
		
		//�ж����޽���
		List res=hasIntersection(l1, s1);
//		System.out.println("res: "+res.size()+","+(int)res.get(1)+", "+(int) res.get(2));
			
		ListNode node=getIntersectionNode(l1, s1);
//		System.out.println(node);
//		System.out.println("���㣺"+node.val);
	}

}
