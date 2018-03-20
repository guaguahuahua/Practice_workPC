package com.xjtu.tree;

public class BSTreeNode {
	public int data;
	public BSTreeNode left;
	public BSTreeNode right;
	
	public BSTreeNode(int data, BSTreeNode left, BSTreeNode right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public BSTreeNode(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
