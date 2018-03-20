package com.xjtu.minstack;

import com.xjtu.LinkedList.Node;

/**
 * ��ʽ��ջ��ͷ�巨
 * ͨ��ά�����������ʽ��ά����Сջ
 * @author Administrator
 * 
 */
public class MinStack {
	//���ջ����
	public int size;
	//���ջ��
	public Node top;
	
	public Node minNode;
	
	/**
	 * ��ʼ����Сջ
	 */
	public MinStack() {
		this.size=0;
		this.top=null;
		this.minNode=null;
	}
	
	/**
	 * ��ջ
	 * @param node
	 */
	public void push(Node node) {
		node.next=top;
		top=node;
		this.size++;
		minElePush(node);
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public Node pop() {
		Node t=null;
		//ջΪ��
		if(size==0) {
			System.out.println("ջ�ѿգ�");
		//ջ��Ϊ��	
		}else {
			t=top;
			top=top.next;
			t.next=null;
			size--;
			minElePop(t);
		}
		return t;
	}
	
	/**
	 * ��ǰջ����Сֵ��ά�����������ʽ
	 * 
	 * @return
	 */
	public void minElePush(Node node) {
		//���ջΪ�գ�ֱ�ӽ�����Ԫ����Ϊ��СԪ
		if(minNode==null) {
			minNode=node;
		//ջ��Ϊ�յ����	
		}else {
			//�����ջԪ�ر���Сֵ����ôά����СԪ�ز���
			if(node.data>=minNode.data) {
				Node t=new Node(minNode.data);
				t.next=minNode;
				minNode=t;
			//�����ջԪ�رȵ�ǰ����СջԪ�ػ�ҪС	
			}else {
				Node t=new Node(node.data);
				t.next=minNode;
				minNode=t;
			}
		}
	}
	
	/**
	 * ��ջ��ͬʱά��������
	 * @param node	Node	��ջ�ڵ�
	 */
	public void minElePop(Node node) {
		//ջΪ�յ�����
		if(minNode==null) {
			System.out.println("ջ�ѿգ�");
			return;
			
		//ջ��Ϊ�յ�����,ֱ��ɾ����ǰ������Ԫ�ؼ���	
		}else {
			Node t=minNode;
			minNode=minNode.next;
			t.next=null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack stack=new MinStack();
		Node n1=new Node(5);
		stack.push(n1);
		stack.push(new Node(9));
		stack.push(new Node(2));
		stack.push(new Node(3));
		stack.push(new Node(5));
		stack.push(new Node(8));
		stack.push(new Node(1));

		//���ջ��Ԫ��
		System.out.println(stack.top.data);
		System.out.println(stack.size);
		//��ǰ��СԪ��
		System.out.println(stack.minNode.data);
		
		for(int i=stack.size; i>0; i--) {
			System.out.print(stack.pop().data+"\t");
			if(stack.minNode!=null) {
				System.out.print(stack.minNode.data+"\t");
			}else {
				System.out.print(null+"\t");
			}			
			System.out.print(stack.size+"\t");
			System.out.println();			
		}
		
	}

}
