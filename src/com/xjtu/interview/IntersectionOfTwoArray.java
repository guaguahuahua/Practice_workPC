package com.xjtu.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArray {

	/**
	 * 获取两个有序数组的交集
	 * 自己的方法：使用HashSet 两个数组同时往HashMap写入元素，如果HashMap
	 * 中已经存在那么该元素就是一个交集中的元素
	 * @param nums1
	 * @param nums2
	 * @return int[]
	 */
	private int [] intersectionOfTwoArray(int []nums1, int []nums2) {
		List<Integer> intersect=new ArrayList<Integer>();
		int i=0,j=0;
		Set<Integer> set=new HashSet<Integer>();
		while(i<nums1.length || j<nums2.length) {
			while(i<nums1.length) {
				//如果集合存在，那么认为是交集元素
				if(set.contains(nums1[i])) {
					intersect.add(nums1[i]);
				//集合中不存在，那么添加到集合中	
				}else {
					set.add(nums1[i]);
				}
				i++;
			}
			while(j<nums2.length) {
				if(set.contains(nums2[j])) {
					intersect.add(nums2[j]);
				}else {
					set.add(nums2[j]);
				}
				j++;
			}
		}
		//这块是将交集转放到数组中去
		int []intersection=new int[intersect.size()];
		for(int k=0; k<intersect.size(); k++) {
			intersection[k]=intersect.get(k);
		}
		return intersection;
	}
	
	/**
	 * 使用HashMap的方式实现
	 * @param nums1
	 * @param nums2
	 * @return int[]
	 */
	private int [] intersectionOfTwoArray_1(int []nums1, int []nums2){
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		List<Integer> list=new ArrayList<Integer>();
		int i=0,j=0;
		while(i<nums1.length || j<nums2.length) {
			while(i<nums1.length) {
				if(map.containsKey(nums1[i])) {
					list.add(nums1[i]);
				}else {
					map.put(nums1[i], 1);
				}
				i++;
			}
			while(j<nums2.length) {
				if(map.containsKey(nums2[j])) {
					list.add(nums2[j]);
				}else {
					map.put(nums2[j], 1);
				}
				j++;
			}
		}
		int []intersect=new int[list.size()];
		for(int k=0; k<list.size(); k++) {
			intersect[k]=list.get(k);
		}
		return intersect;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= {0, 1, 2, 3, 4};
		int []b= {1, 3, 5, 7, 9};
		IntersectionOfTwoArray in=new IntersectionOfTwoArray();
		int []res=in.intersectionOfTwoArray_1(a, b);
		for(int K:res) {
			System.out.print(K+"\t");
		}
		System.out.println();
		
	}

}
