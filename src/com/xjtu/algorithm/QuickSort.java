package com.xjtu.algorithm;

import com.xjtu.sort.Show;

public class QuickSort {

	public static void quickSort(int []num, int left, int right) {
		System.out.println("排序之前：");
		Show.show(num);
		//递归终止条件
		if(right<=left) {
			return ;
		}
		
		//一次排序
		int i=left,j=right;
		int temp;
		for(; i<j; ) {
			
			//向左移动右指针，直到右侧的元素大于左侧的元素
			while(i<j && num[i]<num[j]) {
				j--;
			}
			temp=num[i];
			num[i]=num[j];
			num[j]=temp;
			
			//游移左侧的指针，直到左侧的元素大于右侧元素
			while(i<j && num[j]>num[i]) {
				i++;
			}
			temp=num[j];
			num[j]=num[i];
			num[i]=temp;
		}
//		System.out.println("i:"+i+", "+"j:"+j);
		//找到中间位置之后对两侧进行快排
		quickSort(num, left, i-1);
		quickSort(num, i+1, right);
		
		
		System.out.println("排序之后：");
		Show.show(num);
	}
	
	public static void main(String []args) {
//		int []num= {38, 65, 97, 76, 13, 27, 49};
		int []num= {45, 35};
		quickSort(num, 0, num.length-1);
	}
	
}
