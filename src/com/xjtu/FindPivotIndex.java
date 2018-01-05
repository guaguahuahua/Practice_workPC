package com.xjtu;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
    	//如果给的数组长度为0直接退出
    	if(nums.length==0) {
    		return -1;
    	}
    	//存放依次的从左至右将元素加起来结果
    	int []leftSum=new int[nums.length];
    	leftSum[0]=nums[0];
    	//存放依次的从右至左将元素加起来结果
    	int []rightSum=new int[nums.length];
    	rightSum[rightSum.length-1]=nums[nums.length-1];
    	//获得逐次求和结果
    	for(int i=1, j=nums.length-2; i<nums.length && j>-1; i++, j--) {
    		leftSum[i]=leftSum[i-1]+nums[i];
    		rightSum[j]=rightSum[j+1]+nums[j];
    	}    	
//    	//
//    	for(int K : leftSum) {
//    		System.out.print(K+"\t");
//    	}
//    	System.out.println();
//    	for(int K : rightSum) {
//    		System.out.print(K+"\t");
//    	}
//    	System.out.println();
    	//寻找位置
    	int position=-1;
    	for(int i=0; i<nums.length; i++) {
    		//如果在数组的开头或者末尾
    		if(i==0 || i==nums.length-1) {
        		if(i==0 && rightSum[i+1]==0) {
        			return i;
        		}
        		if(i==nums.length-1 && leftSum[i-1]==0) {
        			return i;
        		}
        	//如果位于数组的中间位置
    		}else {
        		if(i-1>-1 && i+1<nums.length && leftSum[i-1]==rightSum[i+1]) {
        			position=i;
        			break;
        		}
    		}
    		
    	}
        return position;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,7,3,6,5,6};
//		int []nums= {1,2,3};
//		int []nums= {-1, -1, -1, 0, 1, 1};
		int res=pivotIndex(nums);
		System.out.println("最终结果的位置是："+res);
	}

}
