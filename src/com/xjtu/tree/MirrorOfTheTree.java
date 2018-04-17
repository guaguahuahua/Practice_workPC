package com.xjtu.tree;

import java.util.LinkedList;

/**
 * 求二叉树的镜像
 * @author Administrator
 *
 */
public class MirrorOfTheTree {

	/**
	 * 使用递归的方式，递归的交换二叉树的左子树右子树，
	 * @param root
	 * @return
	 */
	public static Node mirrorOfTheTree(Node root) {
		
		if(root!=null) {
			swap(root, root.left, root.right);
		}
		return root;
	}

	
	/**
	 * 交换左右子树
	 * @param left
	 * @param right
	 */
	public static void swap(Node root, Node left, Node right) {
		//交换左右子树
		Node temp=left;
		root.left=right;
		root.right=temp;
		
		if(root.left!=null) {
			swap(root.left, root.left.left, root.left.right);
		}
		if(root.right!=null) {
			swap(root.right, root.right.left, root.right.right);
		}	
	}
	
	/**
	 * 层序遍历输出二叉树的遍历结果
	 * @param root
	 */
	public static void traverse(Node root) {
		if(root!=null) {
			LinkedList<Node> queue=new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node t=queue.poll();
				if(t!=null) {
					queue.add(t.left);
					queue.add(t.right);
					System.out.print(t.data+"\t");	
				}
				
			}
		}
		System.out.println();
	}
	
	/**
	 * 使用非递归的方式实现
	 * 层序遍历，并逐个的交换根节点的左子树右子树
	 * @param root
	 */
	public static Node mirrorOfTheTree_1(Node root) {
		if(root==null) {
			return null;
		}
		//层序遍历
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node t=queue.poll();
			if(t!=null) {
				//交换左右子树
				Node temp=t.left;
				t.left=t.right;
				t.right=temp;
				queue.add(t.left);
				queue.add(t.right);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node r1=new Node(8);
		Node n1=new Node(10);
		Node n2=new Node(6);
		Node n3=new Node(11);
		Node n4=new Node(9);
		Node n5=new Node(7);
		Node n6=new Node(5);
		r1.left=n1;
		r1.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		
		traverse(r1);
		Node res=mirrorOfTheTree_1(r1);
		traverse(res);
	}

}
