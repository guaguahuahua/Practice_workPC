package com.xjtu.algorithm;

public class FindIn2DArray {
	
	/**
	 * 在给定的二维数组中寻找特定的数是否存在，存在返回true,不存在返回false
	 * brute force法
	 * @param nums
	 * @return
	 */
	public static boolean find(int [][]nums, int target) {
		
		//双层for循环，但是没有利用题目给定的从左到右从上倒下依次是有序的
		for(int row=0; row<nums.length; row++) {
			for(int col=0; col<nums.length; col++) {
				if(nums[row][col]==target) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 使用分治法进行搜索，搜索起始点有两个，左下角和右上角
	 * 采用这样的方式的主要原因是减少了搜索的方向，如果搜索存在两个方向
	 * 那么会增加重复性的工作
	 * 我们选择右上角开始搜索
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean find_1(int [][]array, int target) {
		
//		for(int col=nums.length-1; col>=0; ) {
//			for(int row=0; row<nums.length; ) {
//				//当前元素小于target，那么查找当前元素的下部
//				if(nums[row][col]>target) {
//					col--;
//				}else if(nums[row][col]<target) {
//					row++;
//				}else {
//					return true;
//				}
//			}
//		}
		//如果数组为空
		if(array.length==1 && array[0].length==0) {
			return false;
		}
		
		int row=0, col=array.length-1;
		while(row<array.length && col>=0) {
			if(array[row][col]==target) {
				return true;
			}else if(array[row][col]>target) {
				col--;
			}else if(array[row][col]<target){
				row++;
			}
		}
		return false;
	}
	
	public static void main(String []args) {
//		int [][]nums= {
//				{1,2,8, 9 },
//				{2,4,9, 12},
//				{4,7,10,13},
//				{6,8,11,15}
//		};
//		int [][]nums= {{}};
		int [][]nums= {{1,23,5,8}}; 
		int target=8;
		boolean res=find_1(nums, target);
		System.out.println(res);
	}
}
