package com.xjtu.LinkedList;

/**
 * ����ǵ�����ڵ�����ݽṹ
 * @author Administrator
 *
 */
public class Node {
	public int data; //�������
	public Node next; //����¸��ڵ������
	public char letter;
	
	//���췽��
	public Node(int data) {
		this.data=data;
	}
	
	public Node(char letter) {
		this.letter=letter;
	}
	
}
