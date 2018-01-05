package com.xjtu.algorithm;

import java.util.List;
import java.util.ArrayList;

public class MergeAndSort {

	/**
	 * 使用分治法将两个有序数组合并成为一个有序数组，算法时间复杂度为o(nlogn)
	 * @param a
	 * @param b
	 */
	public static int[]  mergeSort(int []a,int []b) {
		List<Integer> list=new ArrayList<Integer>();
		if(a.length==0) { //在合并的过程中提前一个数组遍历完毕
			return b;
		}
		if(b.length==0) {
			return a;
		}
//		if(a[0]<b[0]) {
//			return list.add(a[0]) ;
//		}else {
//			return list.add(b[0]);
//		}
//		
		
		
		return b;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
