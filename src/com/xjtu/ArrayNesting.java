package com.xjtu;

import java.util.Arrays;

public class ArrayNesting {
	/**
	 * 完成数字接龙游戏，并返回最大的接龙长度
	 * 该算法思想属于最传统的，但是TLE，需要重新写算法,这段代码没有太多的问题，主要的是忘记了一个重要的信息：
	 * 如果可以形成环，那么，形成环的这些数总是闭合的，不会再次出现扩展，如果判断的过程中对这些已经形成环的数字进行标记
	 * 那么可以节省大量的时间
	 * @param nums
	 * @return
	 */
/*    public static int arrayNesting(int[] nums) {
        int []length=new int[nums.length]; // 用来存放每一个接龙的长度
        if(nums.length==0) {
        	return 0;
        }
        for(int i=0;i<nums.length;i++) {
        	int j=i,times=1;
        	while(nums[j]!=i) {
        		j=nums[j];
        		times++;
        	}
        	length[i]=times;
        }
        Arrays.sort(length);
    	return length[length.length-1];
    }*/
	
	/**
	 * 算法改进：因为上面用到了排序算法，而函数需要的额仅仅是最大长度
	 * @param nums
	 * @return
	 */
	public static int arrayNesting(int [] nums) {
		int max=0;
		int index=0;
        for(int i=0;i<nums.length;i++) {
        	int j=i,times=0;
        	while(nums[j]>=0) {
        		index=j;
        		j=nums[j];
        		nums[index]=-1;
        		times++;
        	}
        	max=times>max ? times : max;
        }
		return max;
	}
	public static void main(String []args) {
//		int []nums= {5,4,0,3,1,6,2};
		int []nums= {0,1,2};
//		int []nums= {2,2,2,2,2,2}; //该测试用例不可能因为测试元素是来自0--n-1
		
		int res=arrayNesting(nums);
		System.out.print(res+"\t");		
	}
}
