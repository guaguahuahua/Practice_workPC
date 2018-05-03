package com.xjtu.tree;

import java.util.LinkedList;

/**
 * ���ض����������
 * @author Administrator
 *
 */
public class DepthOfBiTree {

	public static int depthOfBiTree(Node root) {
		return backtrack(root);
	}
	
	/**
	 * �ݹ�ʵ�ֶ����������
	 * ˼��Ƚ����أ������ǰ�ڵ�Ϊ�գ���ôֱ�ӷ���Ϊ0��
	 * �����Ϊ�գ���ô����������+1�������������ĸ߶ȣ�֮�󣬷��ص�ǰ����������������ߵ��Ǹ�
	 * Ҳ�������Ϊ�գ���ô���ظ߶�Ϊ0�������Ϊ�գ���ô���ظ߶�Ϊ+1
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
	 * ʹ�ò�������ķ�ʽ��Ķ������ĸ߶�
	 * ���ַ��������Ի�ö�����������ȣ�
	 * @param root
	 * @return
	 */
	public static int depthOfBiTree_2(Node root) {
		int width=Integer.MIN_VALUE;
		//ʹ�ö���
		LinkedList<Node> queue=new LinkedList<Node>();
		//�����ڵ���뵽������
		if(root!=null) {
			queue.add(root);
		}else {
			return 0;
		}
		int height=0;
		while(!queue.isEmpty()) {
			height=height+1;
			//��õ�ǰ���Ԫ�ظ���
			int size=queue.size();
			//��������������Ŀ��
			if(width<size) {
				width=size;
			}
			int i=0;
			//����һ��Ԫ��ȫ��������
			while(i<size) {
				Node t=queue.poll();
				if(t!=null) {
					//�����Ϊ�˷�ֹ��nullֵ��ӵ�������ȥ�������ᵼ�²�߳���
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
		System.out.println("�����������Ŀ���ǣ�"+width);
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
