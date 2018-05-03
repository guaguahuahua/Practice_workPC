package com.xjtu.tree;

import java.util.LinkedList;

/**
 * 返回二叉树的深度
 * @author Administrator
 *
 */
public class DepthOfBiTree {

	public static int depthOfBiTree(Node root) {
		return backtrack(root);
	}
	
	/**
	 * 递归实现二叉树的深度
	 * 思想比较朴素，如果当前节点为空，那么直接返回为0，
	 * 如果不为空，那么左右子树都+1操作，增加树的高度，之后，返回当前树中左右子树中最高的那个
	 * 也就是如果为空，那么返回高度为0，如果不为空，那么返回高度为+1
	 * @param root
	 * @return
	 */
	public static int backtrack(Node root) {
		
		if(root==null) {
			return 0;
		}
		int l=1+backtrack(root.left);
		int r=1+backtrack(root.right);
		return l>r ? l : r;
	}
	
	public static int depthOfBiTree_1(Node root){
		if(root==null) {
			return 0;
		}else {
			int left=depthOfBiTree_1(root.left);
			int right=depthOfBiTree_1(root.right);
			return Math.max(left, right)+1;
		}
	}
	
	/**
	 * 使用层序遍历的方式求的二叉树的高度
	 * 这种方法还可以获得二叉树的最大宽度，
	 * @param root
	 * @return
	 */
	public static int depthOfBiTree_2(Node root) {
		int width=Integer.MIN_VALUE;
		//使用队列
		LinkedList<Node> queue=new LinkedList<Node>();
		//将根节点放入到队列中
		if(root!=null) {
			queue.add(root);
		}else {
			return 0;
		}
		int height=0;
		while(!queue.isEmpty()) {
			height=height+1;
			//获得当前层的元素个数
			int size=queue.size();
			//计算二叉树的最大的宽度
			if(width<size) {
				width=size;
			}
			int i=0;
			//将这一层元素全部出队列
			while(i<size) {
				Node t=queue.poll();
				if(t!=null) {
					//这块是为了防止将null值添加到队列中去，这样会导致层高出错
					if(t.left!=null) {
						queue.add(t.left);
					}
					if(t.right!=null) {
						queue.add(t.right);
					}
				}
				i++;
			}
		}
		System.out.println("二叉树的最大的宽度是："+width);
		return height;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//			1
		//		2		3
		//    4  5     6  7
		//  8
		Node root=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		Node n5=new Node(6);
		Node n6=new Node(7);
		Node n7=new Node(8);
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		
		int res=depthOfBiTree_2(root);
		System.out.println(res);
//		LayerTraverse.layerTraverse(root);
		
	}

}
