package com.xjtu;

public class LongestContinueIncreasingSubsequence {
	/**
	 * 求最长递增子序列
	 * @param nums
	 * @return
	 */
    public static int findLengthOfLCIS(int[] nums) {
    	int times=1,length=0;
    	if(nums.length==0) {
    		return 0;
    	}
    	for(int i=0;i<nums.length-1;i++) { 
    		if(nums[i+1]>nums[i]) {
    			times++;
    		}else {
    			length=times>length ? times : length;
    			times=1;
    		}
    	}
        return times>length ? times : length;
    }
	
	public static void main(String []args) {
		int []nums= {1,3,5,4,7};
//		int []nums= {2,2,2};
//		int []nums= {1,3,2,6,8,9,10};
		int res=findLengthOfLCIS(nums);
		System.out.print(res+"\n");
	}

}
