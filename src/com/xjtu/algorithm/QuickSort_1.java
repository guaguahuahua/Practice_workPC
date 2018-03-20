package com.xjtu.algorithm;

public class QuickSort_1 {

	/**
	 * 实现快排
	 * @param nums	int[]
	 */
	public static void quickSort(int []nums, int left, int right) {
		int l=left;
		int r=right;
		if(l>=r) {
			return ;
		}
		while(l<r) {
			while(l<r && nums[l]<=nums[r]) {
				r--;
			}
			if(l>r) {
				break;
			}
			int temp=nums[l];
			nums[l]=nums[r];
			nums[r]=temp;

			while(l<r && nums[l]<=nums[r]) {
				l++;
			}
			if(l>r) {
				break;
			}
			int tmp=nums[r];
			nums[r]=nums[l];
			nums[l]=tmp;
			
		}
		quickSort(nums, left, l);
		quickSort(nums, l+1, right);
	}
	
	/**
	 * 重载了快排算法，实现了对double型数据的排序
	 * @param nums	double
	 * @param left	int
	 * @param right	int
	 */
	public static void quickSort(double []nums, int left, int right) {
		int l=left;
		int r=right;
		if(l>=r) {
			return ;
		}
		while(l<r) {
			while(l<r && nums[l]<=nums[r]) {
				r--;
			}
			if(l>r) {
				break;
			}
			double temp=nums[l];
			nums[l]=nums[r];
			nums[r]=temp;

			while(l<r && nums[l]<=nums[r]) {
				l++;
			}
			if(l>r) {
				break;
			}
			double tmp=nums[r];
			nums[r]=nums[l];
			nums[l]=tmp;
			
		}
		quickSort(nums, left, l);
		quickSort(nums, l+1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {38, 65, 97, 76, 13, 27, 49};
		int []nums= {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
//		double []nums= {1.132, 1.321, 3.123, 3.213, 3.231, 2.123};
		quickSort(nums, 0, nums.length-1);
		for(double K:nums) {
			System.out.print(K+"\t");
		}
		System.out.println();
	}

}
