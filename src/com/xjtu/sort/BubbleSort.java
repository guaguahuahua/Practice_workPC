package com.xjtu.sort;

public class BubbleSort {

	/**
	 * 使用冒泡排序算法
	 * @param num
	 */
	public static void bubbleSort(int []num) {
		System.out.println("排序之前");
		Show.show(num);
		//冒泡排序
		for(int j=0; j<num.length; j++) {
			
			for(int i=1; i<num.length-j; i++) {
				//当前位置的值较大的时候交换
				if(num[i]<num[i-1]) {
					int tmp=num[i];
					num[i]=num[i-1];
					num[i-1]=tmp;
				}
			}
		}

		System.out.println("排序之后");
		Show.show(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num= {38, 65, 97, 76, 13, 27, 49};
//		int []num= {};
		bubbleSort(num);
		System.out.println(new BubbleSort().getClass().getName());
	}

}
