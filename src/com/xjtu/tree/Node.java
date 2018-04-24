package com.xjtu.tree;

public class Node {
	
	public int data;
	public char letter;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.data=data;
	}
	
	public Node(char letter) {
		this.letter=letter;
	}
	
	public Node() {
		
	}
}
