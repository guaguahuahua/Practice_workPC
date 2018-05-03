package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找数组中重复的数字
 * 数组的长度为n，数组中的数的范围在0--(n-1)内,数组中重复的元素可能有一个或者多个，只要返回其中一个即可
 * @author Administrator
 *
 */
public class RepeatedNums {
	
	/**
	 * 先对数组排序，排序之后找重复元素	
	 * @param nums
	 * @return
	 */
	public static int repeatedNums(int []nums) {
		
		//如果数组为空或者只有一个元素，那么肯定不存在重复元素
		if(nums.length==0 || nums.length==1) {
			return -1;
		}
		//数组中至少有一个元素
		Arrays.sort(nums);
		int left=0, right=1;
		while(right<nums.length) {
			if(nums[left]==nums[right]) {
				return nums[left];
			}else {
				left=right;
				right=right+1;
			}
		}
		//如果前面都没有找到
		return -1;
	}

	/**
	 * 使用高效的o(n)方法
	 * 没有检查边界，也就是数字的合法性
	 * @param nums
	 * @return
	 */
	public static int repeatedNums_1(int []nums) {
		boolean []flag=new boolean[nums.length];
		int index=-1;
		for(int i=0; i<nums.length; i++) {
			//取出对应索引的元素
			index=nums[i];
			if(!(index>=0 && index<=nums.length-2)) {
				return -1;
			}
			if(flag[index]==true) {
				return index;
			}else {
				//标记为已访问
				flag[index]=true;				
			}
		}
		return -1;
	}
	
	/**
	 * 使用list或者其他的集合类进行包装
	 * @param nums
	 * @return
	 */
	public static int repeatedNums_2(int []nums) {
		
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++) {
			int t=nums[i];
			//如果数据的范围不符合要求
			if(!(t>=0 && t<=nums.length-2)) {
				return -1;
			}
			if(!list.contains(t)) {
				list.add(t);
			}else {
				return t;
			}
		}
		return -1;
	}
	
	/**
	 * 使用map能有更好的效果
	 * @param nums
	 * @return
	 */
	public static int repeatedNums_4(int []nums) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			int t=nums[i];
			//检查数据的合法性
			if(!(t>=0 && t<=nums.length-2)) {
				return -1;
			}
			int times=map.getOrDefault(t, 0);
			if(times==1) {
				return t;
			}else {
				map.put(t, 1);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,3,2,0,2,5,3};
		int res=repeatedNums_4(nums);
		System.out.println(res);
	}

}
