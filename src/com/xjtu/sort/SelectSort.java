package com.xjtu.sort;

public class SelectSort {

	/**
	 * 使用选择排序法实现排序的过程
	 * @param num
	 */
	public static void selectSort(int[] num) {
		System.out.println("排序之前：");
		show(num);

		int index=0;
		//排序过程
		for(int j=0; j<num.length; j++) {
			int min=Integer.MAX_VALUE;
			for(int i=j; i<num.length; i++) {
				//比较，寻找当前序列中最大值
				if(min>num[i]) {
					min=num[i];
					index=i;
				}
			}
			//交换最小值和序列中存放点的位置
			num[index]=num[j];
			num[j]=min;
		}
		
		System.out.println("排序之后：");
		show(num);
	}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num= {38, 65, 97, 76, 13, 27, 49};
		selectSort(num);
	}

}
