package com.xjtu.tree;

import java.util.LinkedList;

public class LayerTraverse {

	public static void layerTraverse(Node root) {
		if(root==null) {
			return ;
		}
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			if(temp!=null) {
				System.out.print(temp.data+"\t");
				queue.add(temp.left);
				queue.add(temp.right);				
			}

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
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		
		layerTraverse(root);
	}

}
