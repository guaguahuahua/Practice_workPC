package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xjtu.tree.Node;

/**
 * ����һ������ֵ���������ж�������·���ĺ͵��ڸ���������������·��
 * @author Administrator
 *
 */
public class FindAllPaths {

	/**
	 * ����������n���������ĸ��ڵ�
	 * ÿһ��·������Ӧһ��list��·�����У���sum��·���ĺͣ�
	 * @param n
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> findAllPaths(int n, Node root){
		//������յķ��ؽ��
		List<List<Integer>> list=new ArrayList();
		Map<List<Integer>, Integer> map=new HashMap<List<Integer>, Integer>();
		backtrack(root, 0, new ArrayList(), map);
		for(Map.Entry m : map.entrySet()) {
			if((int)m.getValue()==n) {
				list.add((List<Integer>) m.getKey());
			}
			System.out.println(m.getKey()+", "+m.getValue());
		}
		return list;
	}
	
	/**
	 * �ݹ��ʵ������㷨
	 * @param root
	 * @param sum
	 * @param tempList
	 * @param map
	 */
	public static void backtrack(Node root, int sum, List<Integer>tempList, Map<List<Integer>, Integer> map) {
		if(root!=null) {
			sum+=root.data;
			tempList.add(root.data);
			backtrack(root.left, sum, tempList, map);
			backtrack(root.right, sum, tempList, map);
			tempList.remove(tempList.size()-1);
		//�����������Ҷ�ӽڵ�	
		}else {
			//��������ǽ���list��Ҫ��Ϊ�˷�ֹif�ж�tempList ���޸ĵ���map�����е�Ԫ��Ҳ�����˱仯
			map.put(new ArrayList(tempList), sum);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//				1
//			2		3
//		4	  5  6 	   7
		
		Node root=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		Node n5=new Node(6);
		Node n6=new Node(7);
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
//		LayerTraverse.layerTraverse(root);
		List res=findAllPaths(10, root);
		System.out.println(res);
	}

}
