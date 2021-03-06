package com.xjtu.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 找到数组中出现次数超过一般的元素
 * @author Administrator
 *
 */
public class FindHalfTimesElement {

	/**
	 * 进行排序，排序之后从头到尾进行遍历，统计每个元素出现次数，如果次数大于数组的一半
	 * 那么就跳出循环，否则继续
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement(int []nums) {
		
		if(nums.length==0) {
			return -1;
		}
		Arrays.sort(nums);
		//数组一半的长度
		int max=nums.length/2;
		//统计元素出现的次数
		int times=1;
		//存放超过一半的元素
		int ele=0;
		int l=0, r=1; 
		while(r<nums.length) {
			if(nums[l]==nums[r]) {
				times++;
				r++;
			}else {
				if(times>max) {
					ele=nums[l];
					break;
				}
				//如果没找到
				times=1;
				l=r;
				r=r+1;
			}
		}
		return ele;
	}
	
	/**
	 * 使用map记录每个数出现的次数，时间复杂度小于前一种
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement_1(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		//生成每个元素和它对应的次数
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		//遍历map寻找出现次数超过一半的元素
		int max=nums.length/2;
		for(Entry<Integer, Integer> es:map.entrySet()) {
			if(map.get(es.getKey())>max) {
				return es.getKey();
			}
		}
		return -1;
	}
	
	/**
	 * 元素出现的次数超过了一半，那么该元素的出现次数比其他元素出现次数的和还要多
	 * 那么使用对阵法，如果是相同的，那么+1，否则-1，那么最后剩下的就是超过一半次数的元素
	 * @return
	 */
	public static int findHalfTimesElement_2(int []nums) {
		
		int count=1;
		int ele=-1;
		int l=0, r=1;
		while(r<nums.length) {
			//ele指向能使count++的元素，
			if(nums[l]==nums[r]){
				count++;
				ele=nums[l];
				r++;
				
			//如果不是相同元素，	
			}else {
				l=r;
				r=r+1;
				count=count-1;
			}
		}
		return ele;
	}
	
	/**
	 * 对2进行改进，
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement_3(int []nums) {
		if(nums.length==0) {
			return -1;
		}
		int count=1;
		int ele=nums[0];
		for(int i=1; i<nums.length; i++) {
			//相同元素+1
			if(nums[i]==ele) {
				count++;
			//否则-1	
			}else {
				count--;
			}
			if(count==0) {
				ele=nums[i];
			}			
		}
		return ele;
	}
	
	/**
	 * 如果一个数出现的次数超过数组元素的一半，那么经过排序之后，数组中间的那个元素就是超过一半的那个元素
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement_4(int []nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3,4,5,2,2,2,2,2};
		int res=findHalfTimesElement_4(nums);
		System.out.println(res);
	}

}
