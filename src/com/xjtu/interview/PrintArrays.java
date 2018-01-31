package com.xjtu.interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrintArrays {

	private boolean []visited=new boolean[6];
	private String combination="";
	
	/**
	 * ��ӡ�����������ϵ����,Ҫ��3,5
	 * 3,5Ԫ�ز��������ڣ�4Ԫ�ز����ڵ�3��λ��
	 * @param array int[]
	 */
	private void printArrays(int []array) {
		int n=array.length;
		//ʹ��ͼ��ʵ����ϵ����
		int [][]graph=new int [n][n];
		//��ͼ���г�ʼ������
		for(int row=0; row<graph.length; row++) {
			for(int col=0; col<graph[0].length; col++) {
				if(row!=col) {
					graph[row][col]=1;
				}else {
					graph[row][col]=0;
				}
			}
		}
		//3,5�������ڵģ�
		graph[3][5]=0;
		graph[5][3]=0;
		//�Ӳ�ͬ�Ľڵ����������ȱ���
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
	 * ������ȱ���
	 * @param start ��ʼ�ڵ���±�
	 * @param set ��ͬ��ʼ�ڵ���γɵ��ַ���
	 */
	private void depthFirstSearch(int [][]graph, int []array, int start, Set<String> set) {
		//�����ʹ������飬���б��
		visited[start]=true;
		combination=combination+array[start];
		//�ݹ�ĳ���
		if(combination.length()==6) {
			//ֻ��������λ�ò���6��Ԫ����ӽ�������ȥ
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
	 * �������������ȱ������в���
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
