package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.xjtu.tree.Node;

/**
 * ������������ת��Ϊ˫������
 * @author Administrator
 *
 */
public class BSTreeToBLinkedList {

	/**
	 * �Եݹ����ʽ��ɶ���������ת��Ϊ˫������
	 * @param root
	 * @return
	 */
	public static Node BSTreeToBLinkedList_1(Node root) {
		
		Node node=new Node();
//		backtrack_1(root, lastNode);
		Node lastNode=backtrack_1(root, node);
		while(lastNode!=null && lastNode.left!=null) {
			lastNode=lastNode.left;
		}
		return lastNode;
	}
	
	public static void backtrack(Node root, Node lastNode) {
		if(root==null) {
			return ;
		}
		Node pre=root;
		if(root.left!=null) {
			backtrack(root.left, lastNode);
		}
		pre.left=lastNode;
		if(lastNode!=null) {
			lastNode.right=pre;
		}
		lastNode=pre;
		if(root.right!=null) {
			backtrack(root.right, lastNode);
		}
	}
	
	public static Node backtrack_1(Node root, Node lastNode) {
		if(root==null) {
			return null;
		}
		Node pre=root;
		if(root.left!=null) {
			backtrack(root.left, lastNode);
		}
		pre.left=lastNode;
		if(lastNode!=null) {
			lastNode.right=pre;
		}
		lastNode=pre;
		if(root.right!=null) {
			backtrack(root.right, lastNode);
		}
		return lastNode;
	}
	
	
	
	
	/**
	 * ʹ�÷ǵݹ����ʽ����ͨ���ݹ���������������У��ٴ��������
	 * @param root
	 * @return
	 */
	public static Node BSTreeToBLinkedList(Node root) {
		
		List<Node> list=new ArrayList<Node>();
		//��������������
		inOrder(root, list);
		System.out.println();
		//�������ת��Ϊ����
		for(int i=1; i<list.size(); i++) {
			Node pre=list.get(i-1);
			Node cur=list.get(i);
			pre.right=cur;	
			cur.left=pre;			
		}
		//��β�ڵ㻥ͨ
		list.get(0).left=list.get(list.size()-1);
		list.get(list.size()-1).right=list.get(0);
		return list.get(0);
	}
	
	/**
	 * ˫��ѭ������ı���
	 * @param start
	 */
	public static void traverse(Node start) {
		if(start!=null) {
			Node head=start.right;
			while(head!=start) {
				System.out.println(head.data+", "+head.left.data);
				head=head.right;
			}
			System.out.println(head.data+", "+head.left.data);
		}
	}
	
	
	/**
	 * ���������������
	 * @param root
	 * @param list
	 */
	public static void inOrder(Node root, List<Node> list) {
		
		if(root!=null) {
			inOrder(root.left, list);
			System.out.print(root.data+"\t");
			list.add(root);
			inOrder(root.right, list);
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	    	10
		//  	7		  14
		//   4    9    11    15
		// 3   5          13
		
		Node root=new Node(10);
		Node n1=new Node(7);
		Node n2=new Node(14);
		Node n3=new Node(4);
		Node n4=new Node(9);
		Node n5=new Node(11);
		Node n6=new Node(15);
		Node n7=new Node(3);
		Node n8=new Node(5);
		Node n9=new Node(13);
		
		root.left=n1;
		root.right=n2;		
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		n3.right=n8;
		n5.right=n9;
		
		Node res=BSTreeToBLinkedList_1(root);
		traverse(res);
		
		
		
//		List <Node> list=new ArrayList<Node>();
//		inOrder(root, list);
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i).data+"\t");
//		}
//		System.out.println();
	}

}
