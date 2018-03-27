package com.xjtu.tree;


public class MaxLengthOfBinaryTree {

	public static int findMaxDistance(Node root, int []depth) {
		
		if(root==null) {
			depth[0]=0;
			return 0;
		}
		
		int leftMax=findMaxDistance(root.left, depth);		
		int leftDepth=depth[0];
		
		int rightMax=findMaxDistance(root.right, depth);
		int rightDepth=depth[0];
		
		depth[0]=Math.max(leftDepth+1, rightDepth+1);
		
		return Math.max(Math.max(leftMax, rightMax), leftDepth+rightDepth+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root=new Node(10);
		Node n1=new Node(50);
		Node n2=new Node(32);
		Node n3=new Node(5);
		Node n4=new Node(76);
		Node n5=new Node(9);
		Node n6=new Node(40);
		Node n7=new Node(88);
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		int []depth=new int[1];
		int maxDis=findMaxDistance(root, depth);
		System.out.println(maxDis);

	}

}
