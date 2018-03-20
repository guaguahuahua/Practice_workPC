package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PermutationII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> list=new ArrayList<List<Integer>>();
    	backtrack(list, nums, 0, nums.length-1);
        return list;
    }
    
    public static void backtrack(List<List<Integer>> list, int []nums, int start, int end) {
    	if(start==end) {
    		//判断list是否存在该元素
    		boolean has=false;
    		//将数组转化为list类型
    		List<Integer>tempList=new ArrayList<Integer>();
    		for(int i=0; i<nums.length; i++) {
    			tempList.add(nums[i]);
    		}
    		//在list中查找是否存在该元素
    		for(int i=0; i<list.size(); i++) {
    			if(list.get(i).equals(tempList)) {
    				has=true;
    			}
    		}
    		//如果没有该元素，添加进去
    		if(!has) {
    			list.add(tempList);
    		}
    		
    	}else {
    		for(int i=start; i<=end; i++) {
    			swap(nums, i, start);
    			backtrack(list, nums, start+1, end);
    			swap(nums, start, i);
    		}
    	}
    }
	
    /**
     * 交换两个位置的元素
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int []nums, int i, int j) {
    	
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    
    public static List<List<Integer>> permuteUnique_1(int[] nums) {
    	List<List<Integer>>list=new ArrayList<List<Integer>>();
    	backtrack_1(list, new ArrayList(), nums);
    	return list;
    }
    public static void backtrack_1(List<List<Integer>> list, List<Integer> tempList, int []nums) {

    	if(tempList.size()==nums.length) {
    		list.add(new ArrayList(tempList));
    	}else {
    		for(int i=0; i<nums.length; i++) {
    			if(tempList.contains(nums[i])) {
    				continue;
    			}
    			tempList.add(nums[i]);
    			backtrack_1(list, tempList, nums);
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
    
    public static List<List<Integer>> permuteUnique_2(int[] nums) {
    	
    	List<List<Integer>> list=new ArrayList();
    	backtrack_2(list, new ArrayList(), nums, 0);
    	return list;
    }
    
    public static void backtrack_2(List<List<Integer>>list, List<Integer> tempList, int []nums, int cur) {
    	if(tempList.size()==nums.length) {
    		list.add(new ArrayList(tempList));
    	}else {
    		for(int i=0; i<nums.length; i++) {

    			tempList.add(nums[i]);
    			backtrack_2(list, tempList, nums, cur+1);
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {1,1,2};
//		int []nums= {1,3,4,5,7,8};
		int []nums= {1,2,3};
		List<List<Integer>> list=permuteUnique_2(nums);
		System.out.println(list);
	}

}
