package com.xjtu.algorithm;

import java.util.List;
import java.util.ArrayList;

public class MergeAndSort {

	/**
	 * ʹ�÷��η���������������ϲ���Ϊһ���������飬�㷨ʱ�临�Ӷ�Ϊo(nlogn)
	 * @param a
	 * @param b
	 */
	public static int[]  mergeSort(int []a,int []b) {
		List<Integer> list=new ArrayList<Integer>();
		if(a.length==0) { //�ںϲ��Ĺ�������ǰһ������������
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
