package com.xjtu.LinkedList;

/**
 * 这块是单链表节点的数据结构
 * @author Administrator
 *
 */
public class Node {
	public int data; //存放数据
	public Node next; //存放下个节点的引用
	
	//构造方法
	public Node(int data) {
		this.data=data;
	}
}
