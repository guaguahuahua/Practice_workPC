package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {};
		List<List<Integer>> res=subsets(nums);
		System.out.println(res);
	}
	/**
	 * 求解一个集合的所有子集算法，
	 * 集合的所有子集的模为2^n,所以用该范围二进制的数子1的个数来表示子集元素
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> subsets(int[] nums) {
    	int len=1<<nums.length;
    	List<List<Integer>> outer=new ArrayList<List<Integer>>();
    	for(int i=0; i<len; i++) {
    		int j=i;
    		int k=0;
    		List<Integer>inner=new ArrayList<Integer>();
    		while(j>0) {
    			if((j & 1)!=0) {
    				inner.add(nums[k]);
    			}
    			j=j>>1;
    			k++;
    		}
    		outer.add(inner);
    	}
        return outer;
    }

}
