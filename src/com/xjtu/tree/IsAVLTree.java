package com.xjtu.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 判断一棵树是否为平衡二叉树
 * @author Administrator
 *
 */
public class IsAVLTree {

	/**
	 * 只要这棵树中的每个节点的左右子树都满足高度差绝对值小于1那么就是AVL树
	 * 通过层序遍历的方式对每个节点进行遍历，求每个节点的左子树和右子树的深度然后判断高度差
	 * @param root
	 * @return
	 */
	public static boolean isAVLTree(Node root) {
		//层序遍历每一个节点
		
		LinkedList<Node> queue=new LinkedList<Node>();
		//如果根节点不为空，直接将根节点添加到队列中
		if(root!=null){
			queue.add(root);	
		}else {
			return false;
		}
		while(!queue.isEmpty()) {
			//队头出队列
			Node t=queue.poll();
			//判断队头的左右子树的高度差
			int lLen=depthOfBTree(t.left);
			int rLen=depthOfBTree(t.right);
			if(Math.abs(lLen-rLen)>1) {
				return false;
			}
			//将队头节点的左右子树添加到队列中去
			if(t!=null) {
				if(t.left!=null) {
					queue.add(t.left);
				}
				if(t.right!=null) {
					queue.add(t.right);
				}
			}
		}		
		return true;
	}
	
	/**
	 * 获得二叉树的深度
	 * 这个过程中低层的节点的深度会被多次重复运算
	 * 最好的方法是对每个节点做一个map映射，只经过一次遍历，就得到了所有的节点的深度
	 * 
	 * @param root
	 * @return
	 */
	public static int depthOfBTree(Node root) {
		if(root==null) {
			return 0;
		}else {
			int l=1+depthOfBTree(root.left);
			int r=1+depthOfBTree(root.right);
			return l>r ? l : r;
		}
	}
	
	/**
	 * 使用递归的方式进行
	 * @param root
	 * @return
	 */
	public static boolean isAVLTree_1(Node root) {

		//如果存在子树的情形
		if(root!=null){
			int l=depthOfBTree(root.left);
			int r=depthOfBTree(root.right);
			if(Math.abs(l-r)>1) {
				return false;
			}else {
				return isAVLTree_1(root.left) && isAVLTree_1(root.right);
			}
		}
		//如果存在子树，并且前面没有跳出，那么就是AVL树
		return true;
	}
	
	
	/**
	 * 递归的过程中将每个节点和他的深度保存下来
	 * @param root
	 * @param map
	 * @return
	 */
	public static int depthOfBTree(Node root, Map<Integer, Integer>map) {
		
		if(root==null) {
			return 0;
		}else {
			int key;
			int l=depthOfBTree(root.left, map);		
			int r=depthOfBTree(root.right, map);
			//找左子树和右子树中深度最大的那个
			int len=l>r ? l : r;
			//根据找到的根节点的深度做一个map
			if(root!=null) {
				map.put(root.data, len);
			}
			return len+1;
		}
		
	}
	
	/**
	 * 判断是否为平衡二叉树，
	 * @param root
	 * @return
	 */
	public static boolean isAVLTree_2(Node root) {
		if(root==null) {
			return false;
		}
		//只经过一次遍历得到了所有节点的深度
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		depthOfBTree(root, map);
		//根据层序遍历的方式判断每一个节点是否符合平衡二叉树
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		//如果队列不为空
		while(!queue.isEmpty()) {
			Node t=queue.poll();
			//获得左右子树的高度
			int l=map.get(root.left.data);
			int r=map.get(root.right.data);
			//判断高度差
			if(Math.abs(l-r)>1) {
				return false;
			}
			//将左右子树继续添加进队列
			if(t!=null) {
				if(t.left!=null) {
					queue.add(t.left);
				}
				if(t.right!=null) {
					queue.add(t.right);
				}
			}
		}
		return true;
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
		Node n8=new Node(9);
		
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		n7.right=n8;
		
//		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
//		depthOfBTree(root, (HashMap<Integer, Integer>) map);		
//		for(Entry e : map.entrySet()) {
//			System.out.println(e.getKey()+", "+e.getValue());
//		}
		
		boolean res=isAVLTree_2(root);
		System.out.println(res);
		
//		int res=depthOfBTree(root);
//		System.out.println(res);
	}

}
