package com.xjtu.tree;

import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断一个二叉树是否为另一个二叉树的子结构
 * @author Administrator
 *
 */
public class IsPart {
	
	private static Node res=null;
	/**
	 * 首先去找有没有和r2根节点相同的节点，如果有那么遍历r2也遍历r1中那个节点，判断他们的序列是否相同
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart(Node r1, Node r2) {
		find(r1, r2);
		//如果找到了r2中的根节点
		if(res!=null) {
			List<Integer> l1=new ArrayList<Integer>();
			List<Integer> l2=new ArrayList<Integer>();
			preOrder(res, l1);
			preOrder(r2, l2);
			//判断序列中的元素是否都是相同的
			for(int i=0; i<l2.size(); i++) {
				if(l1.get(i)!=l2.get(i)) {
					return false;
				}
			}
		//如果没找着r2的根节点	
		}else {
			return false;	
		}
		return true;
	}
	
	/**
	 * 使用先序遍历的方式得到它们序列，如果序列完全一致，那么说明r2就是r1的子结构
	 * @param root
	 * @param list
	 */
	public static void preOrder(Node root, List<Integer> list) {
		if(root!=null) {
			list.add(root.data);
			preOrder(root.left, list);
			preOrder(root.right, list);
		}
	} 
	
	
	
	
	/**
	 * 使用先序遍历的方式寻找子结构r2，如果可以找到，那么返回找到的开始节点
	 */
	public static void find(Node r1, Node r2) {
		//出口，找到就退出，否则递归
		if(r1!=null) {
			if(r1.data==r2.data) {
				res=r1;
				return ;
			}else {
				find(r1.left, r2);
				find(r1.right, r2);
			}	
		}
	}
	
	/**
	 * 使用先序遍历的方式输出所有的节点
	 * @param root
	 */
	public static void show(Node root) {
		if(root!=null) {
			System.out.print(root.data+"\t");
			show(root.left);
			show(root.right);
		}
	}
	
	/**
	 * 如果在遍历的过程中找到了值相同的节点，那么就直接进行数值的比对
	 * 这块使用了递归的嵌套，比较难理解
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart_1(Node r1, Node r2) {
		//如果母树为空，那就是没有找到对应的节点
		if(r1==null) {
			return false;
		}
		//如果子树为空，那么认为找到了
		if(r2==null) {
			return true;
		}
		boolean res1=false,res2=false;
		//如果当前节点的值相等，那么从当前节点开始搜索
		if(r1.data==r2.data) {
			res1=compare(r1, r2);
			return res1;
		}else {
			res1=isPart_1(r1.left, r2);
			res2=isPart_1(r1.right, r2);
			return res1 || res2;
		}
		
//		return res1;
	}
	
	/**
	 * 递归的比较树的元素是否完全一致
	 * @param r1
	 * @param r2
	 */
	public static boolean compare(Node r1, Node r2) {
		boolean res1 = false,res2 = false;
		if(r1==null && r2!=null) {
			return false;
		}else if(r1==null && r2==null) {
			return true;
		}else if(r1!=null && r2==null) {
			return true;
		}else {
			if(r1.data==r2.data) {
				res1=compare(r1.left, r2.left);
				res2=compare(r1.right, r2.right);
			}
		}
		return res1 && res2;
	}
	
	/**
	 * 使用层序遍历的方式寻找根节点，找到相同值节点之后再进行递归的寻找
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart_2(Node r1, Node r2) {
		
		LinkedList<Node> stack=new LinkedList<Node>();
		stack.push(r1);
		boolean res=false;
		//如果栈不为空
		while(!stack.isEmpty()) {
			Node t=stack.pop();
			//如果当前节点的值和r2的值不一样
			if(t.data!=r2.data) {
				stack.push(t.left);
				stack.push(t.right);
			}else {
				//递归的方式比较它们的值是否完全一致
				res=compare(t, r2);
				break;
			}
		}
		return res;
	}
	
	/**
	 * isPart_2是错误的，虽然结果正确，但是不是按照我的思路来的，层序遍历使用的数据结构是队列，
	 * 而不是堆栈
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart_3(Node r1, Node r2) {
		
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(r1);
		boolean res=false;
		//如果栈不为空
		while(!queue.isEmpty()) {
			Node t=queue.poll();
			//如果当前节点的值和r2的值不一样
			if(t.data!=r2.data) {
				queue.add(t.left);
				queue.add(t.right);
			}else {
				//递归的方式比较它们的值是否完全一致
				res=compare(t, r2);
				break;
			}
		}
		return res;
	}
	
	public static void main(String []args) {
		Node r1=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		Node n5=new Node(6);
		r1.left=n1;
		r1.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		
		Node r2=new Node(3);
		Node n21=new Node(9);
		r2.left=n21;
//		show(r2);
		Boolean res=isPart_3(r1, r2);
		System.out.print(res);
	}

}
