package com.xjtu.tree;

import java.util.LinkedList;

/**
 * 按照之字形打印二叉树
 * @author Administrator
 *
 */
public class PrintBiTree {

	/**
	 * 使用队列实现
	 * @param root
	 */
	public static void printBiTree(Node root) {
		if(root==null) {
			System.out.println("二叉树为空");
		}
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		boolean ltor=false;
		//如果队列不为空
		while(!queue.isEmpty()) {
			int len=0;
			int size=queue.size();
			while(len<size) {
				Node t;
				//从左向右打印
				if(ltor==true) {
					t=queue.poll();
					System.out.print(t.data+"\t");
					if(t.left!=null) {
						queue.add(t.left);	
					}
					if(t.right!=null) {
						queue.add(t.right);
					}
					
				//从右向左打印	
				}else {
					t=queue.pollLast();
					System.out.print(t.data+"\t");
					if(t.right!=null) {
						queue.push(t.right);	
					}
					if(t.left!=null) {
						queue.push(t.left);
					}
				}		
				len++;
			}
			ltor= (ltor==false) ? true : false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(1);
		Node n1=new Node(4);
		Node n2=new Node(2);
		Node n3=new Node(5);
		Node n4=new Node(6);
		Node n5=new Node(3);
		Node n6=new Node(7);
		Node n7=new Node(8);
		Node n8=new Node(9);
		Node n9=new Node(10);
		Node n10=new Node(11);
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		n3.right=n8;
		n4.left=n9;
		n4.right=n10;
		printBiTree(root);
	}

}
