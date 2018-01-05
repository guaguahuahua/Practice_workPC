package com.xjtu.sort;

public class Show {
	
	/**
	 * 展示方法，用于输出最后的结果
	 * @param num 
	 */
	public static void show(int []num) {
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+"\t");
		}
		System.out.println();
	}
}
