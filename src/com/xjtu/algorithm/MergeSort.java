package com.xjtu.algorithm;

public class MergeSort {

	public static void mergeSort(int []nums) {
		binMergeSort(nums, 0, nums.length-1);
	}
	
	
	public static void binMergeSort(int []nums, int left, int right) {
		if(left<right) {
			int mid=left+(right-left)/2;
			binMergeSort(nums, left, mid);
			binMergeSort(nums, mid+1, right);
			merge(nums, left, right, mid);
		}
	}
	
	
	/**
	 * 一次二路归并
	 * @param nums
	 * @param left
	 * @param right
	 * @param mid
	 */
	public static void merge(int []nums, int left, int right, int mid) {
		int len1=mid-left+1;
		int len2=right-mid;
		//新创建两个数组存放左右两个分量
		int []part1=new int[len1];
		int []part2=new int[len2];
		//将数组中元素放入到左右两个元素中
		for(int i=0, j=left; i<len1; i++, j++) {
			part1[i]=nums[j];
		}
		
		for(int i=0, j=mid+1; i<len2; i++, j++) {
			part2[i]=nums[j];
		}
		
		int i, j, k;
		//将左右两个数组中的元素按照大小顺序放入到原数组中
		for(i=0, j=0, k=left; i<len1 && j<len2; ) {
			//我们以升序排列所有元素
			if(part1[i]<=part2[j]) {
				nums[k]=part1[i];
				i++;
			}else {
				nums[k]=part2[j];
				j++;
			}
			k++;
		}
		
		//将剩余的元素填入到原数组中去
		while(i<len1) {
			nums[k++]=part1[i++];
		}
		while(j<len2) {
			nums[k++]=part2[j++];
		}
		
	}
	
	public static void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {5,4,9,8,7,6,0,1,3,2};
		show(nums);
		mergeSort(nums);
		show(nums);
	}

}
