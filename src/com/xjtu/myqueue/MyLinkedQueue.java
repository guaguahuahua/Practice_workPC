package com.xjtu.myqueue;

import com.xjtu.LinkedList.Node;
import com.xjtu.LinkedList.SingleLinkedList;

public class MyLinkedQueue {
	private SingleLinkedList queue; //队列的主体
	private Node head;
	private Node tail;
	private int length;
	
	//单链表的初始化
	public MyLinkedQueue() {
		queue=new SingleLinkedList();
		head=queue.head; //让队列的头指针为指针均指向单链表的头结点
		tail=queue.head;
		length=0; //长度置为0
	}
	
	/**
	 * 判定当前的队列是否为空
	 * @return
	 */
	public synchronized boolean isEmpty() {
		if(head==tail && length==0) {
			return true;
		}
		return false;
	}
	/**
	 * 获取当前链式队列的长度
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * 入队列
	 * @param node 入队节点
	 * @return boolean
	 */
	public synchronized boolean append(Node node) {
		
		//入队
		node.next=tail.next;
		tail.next=node;
		tail=node;
		length++;
		return true;
	}
	
	/**
	 * 出队列
	 * @return Node
	 */
	public synchronized Node delete() {
		if(isEmpty()) {
			return null;
		}
		Node res=head.next; //获得该节点
		head.next=head.next.next; //删除当前头结点
		length--;
		return res;
	}
	
	/**
	 * 查看队列的队头元素
	 * @return Node 
	 */
	public synchronized Node peek() {
		//如果当前的队列为空
		if(isEmpty()) {
			return null;
		}
		return head.next;
	}
	
	/**
	 * 测试上面的方法
	 * @param args
	 */
	public static void main(String []args) {
		MyLinkedQueue queue=new MyLinkedQueue();
		queue.append(new Node(1));
		queue.append(new Node(2));
		queue.append(new Node(4));
		System.out.println("队列为空："+queue.isEmpty());
		System.out.println("队列头元素："+queue.peek().data);
		queue.delete();
		System.out.println("当前的头元素为："+queue.peek().data);
	}
}
