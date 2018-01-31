package com.xjtu.interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrintArrays {

	private boolean []visited=new boolean[6];
	private String combination="";
	
	/**
	 * 打印数组的所有组合的输出,要求3,5
	 * 3,5元素不可以相邻，4元素不能在第3个位置
	 * @param array int[]
	 */
	private void printArrays(int []array) {
		int n=array.length;
		//使用图来实现组合的输出
		int [][]graph=new int [n][n];
		//对图进行初始化过程
		for(int row=0; row<graph.length; row++) {
			for(int col=0; col<graph[0].length; col++) {
				if(row!=col) {
					graph[row][col]=1;
				}else {
					graph[row][col]=0;
				}
			}
		}
		//3,5不能相邻的，
		graph[3][5]=0;
		graph[5][3]=0;
		//从不同的节点进行深度优先遍历
		Set<String> set=new HashSet<String>();
		for(int i=0; i<n; i++) {
			this.depthFirstSearch(graph, array, i, set);
		}
		Iterator it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());			
		}
		System.out.println(set.size());
	}
	
	/**
	 * 深度优先遍历
	 * @param start 开始节点的下标
	 * @param set 不同开始节点的形成的字符串
	 */
	private void depthFirstSearch(int [][]graph, int []array, int start, Set<String> set) {
		//将访问过的数组，进行标记
		visited[start]=true;
		combination=combination+array[start];
		//递归的出口
		if(combination.length()==6) {
			//只将第三个位置不是6的元素添加进集合中去
			if(combination.indexOf("4")!=2) {
				set.add(combination);
			}
		}
		
		for(int j=0; j<array.length; j++) {
			if(graph[start][j]==1 && visited[j]==false) {
				depthFirstSearch(graph, array, j, set);
			}
		}
//		System.out.println("uncutted:"+combination);
		combination=combination.substring(0, combination.length()-1);
//		System.out.println("cutted  :"+combination);
		visited[start]=false;
	}
	
	/**
	 * 对上面的深度优先遍历进行测试
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array= {1, 2, 2, 3, 4, 5};
//		int []array= {1, 2, 3};
		PrintArrays pa=new PrintArrays();
		pa.printArrays(array);
	}

}
