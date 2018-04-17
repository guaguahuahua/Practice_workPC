package com.xjtu.algorithm;

import com.xjtu.tree.Node;

public class ReconstructBintree {

	/**
	 * ����ǰ������������� ���ض������ĺ���������������Ҫ�ؽ�������
	 * �ݹ�ķ�ʽʵ��
	 * @param preOrder
	 * @param start1
	 * @param end1
	 * @param inOrder
	 * @param start2
	 * @param end2
	 * @return
	 */
	public static Node reconstructBintree(int []preOrder, int start1, int end1, int []inOrder, int start2, int end2) {
		
		//�ݹ�����ĳ���
		if(start1>end1 || start2>end2) {
			return null;
		}
		
		int rootData=preOrder[start1];
		Node root=new Node(rootData);
		//������������ҵ����ڵ�λ��
		int rootIndex=findIndexInArray(inOrder, rootData, start2, end2);
		//�������ĳ���
		int offset=rootIndex-start2-1;
		//������������
		Node left=reconstructBintree(preOrder, start1+1, start1+1+offset, inOrder, start2, start2+offset);
		//������������
		Node right=reconstructBintree(preOrder, start1+offset+2, end1, inOrder, rootIndex+1, end2);
		root.left=left;
		root.right=right;
		return root;
	}
	
	/**
	 * ��������Ѱ�Ҹ��ڵ��λ�ã�����ҵ��˷�������
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int findIndexInArray(int []array, int data, int start, int end) {
		//�ҵ��ýڵ������λ��                                                                                                                                                                                                                                                                
		for(int i=start; i<=end; i++) {
			if(array[i]==data) {
				return i;
			}
		}
		//����Ҳ�������-1
		return -1;
	}
	
	
	public static void postOrder(Node root) {
		
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []preOrder= {1,2,4,8,9,5,10,3,6,7};
		int []inOrder= {8,4,9,2,10,5,1,6,3,7};
		
		Node root=reconstructBintree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
		postOrder(root);
	}

}
