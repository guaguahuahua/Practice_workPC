package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SumIsM {
	
	
	public static List<List<Integer>> sumIsM(int n, int m) {
		//生成长度为n的数组
//		int []nums=new int[n];
//		for(int i=0; i<nums.length; i++) {
//			nums[i]=i+1;
//		}		
//		show(nums);
		int []nums= {1,2,5};
		m=100;
		//使用递归
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList(), nums, m, 0);		
		return list;
	}
	
	/**
	 * 这块使用的递归总是从第一个元素开始遍历
	 * @param list
	 * @param tempList
	 * @param nums
	 * @param remain
	 * @param start
	 */
	public static void backtrack(List<List<Integer>> list, List<Integer>tempList, int []nums, int remain, int start) {
		if(remain<0) {
			return;
		}else if(remain==0) {
			if(repeated(list, new ArrayList(tempList), nums.length)) {
				list.add(new ArrayList(tempList));
			}
			
//			if(!list.contains(tempList)) {
//				list.add(new ArrayList(tempList));	
//			}
//			list.add(new ArrayList(tempList));
			
		}else {
			
			for(int i=start; i<nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain-nums[i], start);
				tempList.remove(tempList.size()-1);
			}			
		}
	}
	
	/**
	 * 如果长度相同，那么就比较两个元素的所有元素是否相同，元素也不相同的情况下，那么count++
	 * 如果长度不同，那么直接count++
	 * @param list
	 * @param tempList
	 * @param len
	 * @return
	 */
	public static boolean repeated(List<List<Integer>>list, ArrayList<Integer> tempList, int len) {
		//统计不一样的元素的个数
		int count=0;
		for(int i=0; i<list.size(); i++) {
			List<Integer> t=list.get(i);
			//判断两个结果是否相同
			boolean isSame=true;
			//如果长度相同
			if(t.size()==tempList.size()) {
				int []table=new int[len];
				for(int j=0; j<t.size(); j++) {
					table[t.get(j)-1]++;
				}
				for(int j=0; j<tempList.size(); j++) {
					table[tempList.get(j)-1]--;
				}
				
				for(int j=0; j<table.length; j++) {
					if(table[j]!=0) {
						count++;
						break;
					}
				}
			}else {
				isSame=false;
				count++;
			}
		}
		if(count==list.size()) {
			return true;
		}else {
			return false;
		}		
	}
	
	
	public static void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		int m=13;
		List<List<Integer>>res=sumIsM(n ,m);
		System.out.println(res);
		System.out.println(res.size());
	}
}
