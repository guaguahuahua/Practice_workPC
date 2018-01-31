package com.xjtu.interview;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
	public static void main(String []args) {
		int []a= {1,4,3,8,6,5};
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int K : a) {
			list.add(K);
		}
		Collections.sort(list);
		for(int K : list) {
			System.out.print(K+"\t");
		}
		System.out.println();		
	}
}
