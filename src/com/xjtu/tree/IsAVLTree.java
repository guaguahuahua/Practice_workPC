package com.xjtu.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * �ж�һ�����Ƿ�Ϊƽ�������
 * @author Administrator
 *
 */
public class IsAVLTree {

	/**
	 * ֻҪ������е�ÿ���ڵ����������������߶Ȳ����ֵС��1��ô����AVL��
	 * ͨ����������ķ�ʽ��ÿ���ڵ���б�������ÿ���ڵ���������������������Ȼ���жϸ߶Ȳ�
	 * @param root
	 * @return
	 */
	public static boolean isAVLTree(Node root) {
		//�������ÿһ���ڵ�
		
		LinkedList<Node> queue=new LinkedList<Node>();
		//������ڵ㲻Ϊ�գ�ֱ�ӽ����ڵ���ӵ�������
		if(root!=null){
			queue.add(root);	
		}else {
			return false;
		}
		while(!queue.isEmpty()) {
			//��ͷ������
			Node t=queue.poll();
			//�ж϶�ͷ�����������ĸ߶Ȳ�
			int lLen=depthOfBTree(t.left);
			int rLen=depthOfBTree(t.right);
			if(Math.abs(lLen-rLen)>1) {
				return false;
			}
			//����ͷ�ڵ������������ӵ�������ȥ
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
	 * ��ö����������
	 * ��������еͲ�Ľڵ����Ȼᱻ����ظ�����
	 * ��õķ����Ƕ�ÿ���ڵ���һ��mapӳ�䣬ֻ����һ�α������͵õ������еĽڵ�����
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
	 * ʹ�õݹ�ķ�ʽ����
	 * @param root
	 * @return
	 */
	public static boolean isAVLTree_1(Node root) {

		//�����������������
		if(root!=null){
			int l=depthOfBTree(root.left);
			int r=depthOfBTree(root.right);
			if(Math.abs(l-r)>1) {
				return false;
			}else {
				return isAVLTree_1(root.left) && isAVLTree_1(root.right);
			}
		}
		//�����������������ǰ��û����������ô����AVL��
		return true;
	}
	
	
	/**
	 * �ݹ�Ĺ����н�ÿ���ڵ��������ȱ�������
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
			//��������������������������Ǹ�
			int len=l>r ? l : r;
			//�����ҵ��ĸ��ڵ�������һ��map
			if(root!=null) {
				map.put(root.data, len);
			}
			return len+1;
		}
		
	}
	
	/**
	 * �ж��Ƿ�Ϊƽ���������
	 * @param root
	 * @return
	 */
	public static boolean isAVLTree_2(Node root) {
		if(root==null) {
			return false;
		}
		//ֻ����һ�α����õ������нڵ�����
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		depthOfBTree(root, map);
		//���ݲ�������ķ�ʽ�ж�ÿһ���ڵ��Ƿ����ƽ�������
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		//������в�Ϊ��
		while(!queue.isEmpty()) {
			Node t=queue.poll();
			//������������ĸ߶�
			int l=map.get(root.left.data);
			int r=map.get(root.right.data);
			//�жϸ߶Ȳ�
			if(Math.abs(l-r)>1) {
				return false;
			}
			//����������������ӽ�����
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
