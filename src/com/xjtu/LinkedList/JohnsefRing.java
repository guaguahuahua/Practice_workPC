package com.xjtu.LinkedList;

public class JohnsefRing {

	public static void johnsefRing(int people, int k) {
		//����ѭ��������
		Node start=CircleSingleLinkedList.createCircleList(people);
		CircleSingleLinkedList.show(start, people);
		Node temp=start;
		int count=k-2;
		while(temp.next!=temp) {
			//�ҵ�Ҫɾ���ڵ��ǰһ��λ��
			while(count>0) {
				temp=temp.next;
				count--;
			}
			//ɾ���ýڵ�
			System.out.print(temp.next.data+"\t");
			//ɾ���ڵ�
			temp.next=temp.next.next;
			temp=temp.next;
			count=k-2;
		}
		
		System.out.print(temp.data+"\t");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int people=7;
		int k=20;
		johnsefRing(people, k);
		
	}
}
