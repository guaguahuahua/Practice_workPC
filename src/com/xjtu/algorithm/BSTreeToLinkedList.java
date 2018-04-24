package com.xjtu.algorithm;

import com.xjtu.tree.LayerTraverse;
import com.xjtu.tree.Node;

public class BSTreeToLinkedList {

	public static Node BSTreeToLinkedList(Node root) {
		
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		4
		//	  2   5
		// 1   3    7
		Node root=new Node(4);
		Node n1=new Node(2);
		Node n2=new Node(5);
		Node n3=new Node(1);
		Node n4=new Node(3);
		Node n5=new Node(7);
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.right=n5;
		
		LayerTraverse.layerTraverse(root);
		System.out.println();
		
		try {
			
			System.out.println("this is try block");
			System.exit(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("this is finally block");
		}
		
		try {
			System.out.println("this is try block");
		}finally{
			System.out.print("this is finally block");
		}
	}

}
