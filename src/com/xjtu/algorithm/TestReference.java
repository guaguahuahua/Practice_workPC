package com.xjtu.algorithm;

import com.xjtu.tree.Node;

public class TestReference {

	public static void testReference(Node node) {
		node.data=1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node=new Node();
		testReference(node);
		System.out.println(node.data);
	}

}
