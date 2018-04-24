package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xjtu.tree.Node;

/**
 * 给定一个整数值，返回所有二叉树的路径的和等于给定的整数的所有路径
 * @author Administrator
 *
 */
public class FindAllPaths {

	/**
	 * 给定的整数n，二叉树的根节点
	 * 每一个路径都对应一个list（路径序列）和sum（路径的和）
	 * @param n
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> findAllPaths(int n, Node root){
		//存放最终的返回结果
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
	 * 递归的实现这个算法
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
		//如果遍历到了叶子节点	
		}else {
			//这块存入的是进行list主要是为了防止if中对tempList 的修改导致map集合中的元素也发生了变化
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
