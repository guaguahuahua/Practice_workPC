package com.xjtu.algorithm;

/**
 * 求子数组的最大的和
 * @author Administrator
 *
 */
public class MaxSubArray_1 {

	/**
	 * 暴力枚举
	 * @param nums
	 * @return
	 */
	public static int maxSubArray_1(int []nums) {
		
		int max=Integer.MIN_VALUE;
		//长度逐渐从1加长
		for(int len=1; len<=nums.length; len++) {
			for(int i=0; i<=nums.length-len; i++) {
				int temp=0;
				//取出len长度个元素
				for(int j=i; j<i+len; j++) {
					temp+=nums[j];
				}
				//判断与最大值之间的差距
				if(temp>max) {
					max=temp;
				}
			}
		}
		return max;
	}
	
	/**
	 * 尝试贪心算法
	 * @param nums
	 * @return
	 */
	public static int maxSubArray_2(int []nums){
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			if(sum>max) {
				max=sum;
			}
			if(sum<0) {
				sum=0;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={6,-3,-2,7,-15,1,2,2};
		int []nums= {-1,-3,-6,-87};
		int res=maxSubArray_2(nums);
		System.out.println(res+"\t");
	}

}
