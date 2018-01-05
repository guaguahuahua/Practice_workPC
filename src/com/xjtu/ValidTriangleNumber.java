package com.xjtu;

import java.util.Arrays;

public class ValidTriangleNumber {

	/**
	 * 获得三角形数，使用最朴素的算法， 枚举，从数组一个到最后一个,
	 * 暴力穷举法出现了TLE
	 * @param nums
	 * @return
	 */
    public static int triangleNumber_1(int[] nums) {
        int count=0;
        for(int index=0;index<=nums.length-1-2;index++) {
        	for(int i=index+1;i<=nums.length-1-1;i++) {
        		for(int j=i+1;j<=nums.length-1;j++) {
        			if(nums[index]+nums[i]>nums[j] && 
            				nums[index]+nums[j]>nums[i] && 
            						nums[j]+nums[i]>nums[index]) { //满足三角形的三边规则，那么count自增，否则继续下一轮
            			count++;
//            			System.out.println(nums[index]+"\t"+nums[i]+"\t"+nums[i+1]);
            		}
        		}
        		
        	}
        }
    	return count;
    }
    
    /**
     * 使用二分法查找合适的第三遍
     * @param nums  已经排好序的数组
     * @param start 搜索范围的开始索引
     * @param end 结束索引
     * @param sum 前两个数的和
     * @return 返回第一个符合条件的索引
     */ 
    public static int binarySearch(int []nums, int start, int end, int sum) {
    	
    	int mid;
    	while(start<=end && end<nums.length) {
//    		mid=start+(end-start)/2;
    		mid=(end+start)/2;
    		//如果找到的位置的值<前两边之和
    		if(nums[mid]>=sum) {
    			end=mid-1;
    		}else{
    			start=mid+1;
    		}
    	}
    	return start;
    }
    /**
     * 使用排序+二分查找的方式缩短时间复杂度为n^2(Log2n)
     * @param nums
     * @return
     */
    public static int triangleNumber_2(int[] nums) {
    	//首先对数组进行排序,排序之后判断三角数会出现一个优势就是：如果 a<=b<=c 那么只需要判断
    	// a+b>c是否满足即可，因为一旦有序，那么c+a>b, c+b>a都是成立的，将判定条件缩减为1个
    	Arrays.sort(nums);
    	//双层for循环查找合适的边，如果是nums[i]+nums[j]>nums[k], 那么j+1，到k之间的元素都是合理的三角边
    	int count=0; //统计所有的三角数的个数
    	for(int i=0; i<nums.length-2; i++) {
    		for(int j=i+1; j<nums.length-1 && nums[i]!=0; j++) {
    			int k=binarySearch(nums, i+2, nums.length-1, nums[i]+nums[j]);
    			System.out.println(k);
    			count+=k-j-1;
    		}
    	}
    	return count;
    }
    
    /**
     * 使用线性扫描法实现
     * @param nums
     * @return
     */
    public static int triangleNumber(int []nums) {
    	
    	int count=0;
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length-2; i++) {
    		int k=i+2;
    		for(int j=i+1; j<nums.length-1 && nums[i]!=0; j++) {
    			while(k<nums.length && nums[i]+nums[j]>nums[k]) {
    				k++;
    			}
    			count+=k-j-1;
    		}
    	}
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {2,2,3,4,9,562,5,3,78,56,16,456,46};
		int []nums= {2,2,3,4};
//		int []nums= {1,2,3,4,5,6};
//		int []nums= {2,5,6,7,9};
//		int []nums= {0,1,0,1};
		int res=triangleNumber(nums);
		System.out.println("triangle number :"+res);
	}

}
