package com.xjtu.algorithm;

public class MaxSubArray {
	
	/**
	 * 暴力枚举法，从长度为1的子串一直到长度为本身的子串
	 * @param nums	int[]
	 * @return	int
	 */
	public static int maxSubArray(int []nums) {
		int max=Integer.MIN_VALUE;
		for(int len=1; len<=nums.length; len++) {
			//每次开始的索引位置
			for(int start=0; start<=nums.length-len; start++) {
				//取len长度个元素
				int length=len;
				int temp=0;
				int tIndex=start;
				while(length>0) {
					temp+=nums[tIndex];
					tIndex++;
					length--;
				}
				//和最大值进行比较
				if(temp>max) {
					max=temp;
				}
			}
		}
		System.out.println(max);
		return max;
	}
	
	/**
	 * 最大子数组的的贪婪算法解决
	 * @param nums	int []
	 * @return	int
	 */
	public static int maxSubArray_1(int []nums) {
		int max=Integer.MIN_VALUE;
		int temp=0;
		for(int index=0; index<nums.length; index++) {
			temp+=nums[index];
			if(temp>max) {
				max=temp;
			}
			if(temp<0) {
				temp=0;
			}
			
		}
		System.out.println(max);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,-2,3,10,-4,7,2,-5};
		maxSubArray_1(nums);
	}

}
