package com.xjtu.LinkedList;

public class JohnsefRing {

	public static void johnsefRing(int people, int k) {
		//创建循环单链表
		Node start=CircleSingleLinkedList.createCircleList(people);
		CircleSingleLinkedList.show(start, people);
		Node temp=start;
		int count=k-2;
		while(temp.next!=temp) {
			//找到要删除节点的前一个位置
			while(count>0) {
				temp=temp.next;
				count--;
			}
			//删除该节点
			System.out.print(temp.next.data+"\t");
			//删除节点
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
