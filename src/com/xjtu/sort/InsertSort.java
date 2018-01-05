package com.xjtu.sort;

public class InsertSort {

	/**
	 * 插入排序算法
	 * @param num 待排数组
	 */
	public static void insertSort(int []num) {
		System.out.println("排序之前：");
		Show.show(num);
		//进行插入排序的过程
		for(int i=1;i<num.length; i++) {
			//记录当前元素
			int tmp=num[i];
			while(i>0 && tmp<num[i-1]) {
				num[i]=num[i-1];
				i--;
			}
			//如果发生了移动位置的操作
			num[i]=tmp;
		}
		
		System.out.println("排序之后：");
		Show.show(num);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num= {38, 65, 97, 76, 13, 27, 49};
		insertSort(num);
	}

}
