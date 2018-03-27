package com.xjtu.algorithm;

import java.lang.reflect.Array;

public class AdjustMinHeap {

	/**
	 * 堆的创建
	 * @param a
	 * @param pos	调整的第一个父节点索引
	 * @param len	数组中的最后一个元素的索引，不是数组的长度，这个元素决定在比较的时候是用<=而不是<
	 */
	public static void adjustMinHeap(int []a, int pos, int len) {
		
		
		for( ;2*pos<len; ) {
			//计算孩子节点的索引
			int child=2*pos+1;
			//如果有右孩子并且比左孩子小,那么去两者中的最小值
			if(child+1<=len && a[child]>a[child+1]) {
				child++;
			}
			//如果孩子节点小于父节点，那么交换，这个交换也可以放在最终位置确定之后
			if(a[child]<a[pos]) {
				int temp=a[pos];
				a[pos]=a[child];
				a[child]=temp;
			}else {
				break;
			}
			pos=child;
		}
	}
	
	public static void show(int []nums) {
		for(int K:nums) {
			System.out.print(K+"\t");
		}
		System.out.println();
	} 
	
	/**
	 * 堆排序主体
	 * @param nums
	 */
	public static void heapSort(int []nums) {	
		//堆的初始创建
		for(int i=(nums.length)/2-1; i>=0; i--) {
			adjustMinHeap(nums, i, nums.length-1);
		}
		System.out.println("最小堆建立效果：");
		show(nums);
		//交换位置
		for(int j=nums.length-1; j>=0; j--) {
			
			int temp=nums[0];
			nums[0]=nums[j];
			nums[j]=temp;			
			adjustMinHeap(nums, 0, j-1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {5,4,9,8,7,6,0,1,3,2};
		show(nums);
//		int i;
//		int len=nums.length;
//		for(i=len/2-1; i>=0; i--) {
//			adjustMinHeap(nums, i, len-1);
//		}
		heapSort(nums);
		System.out.println("堆排序之后的结果：");
		show(nums);
	}

}
