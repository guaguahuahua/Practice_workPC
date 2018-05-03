package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定整型数组，将数组中的元素组合为一个整数，该整数为所有组合中的最小值
 * @author Administrator
 *
 */
public class SmallestNumOfArray {

	/**
	 * 方法1：直接通过递归的方式找到数组排列的所有可能，通过搜索排列的最小值的方式得到数组排列中的最小值
	 * @param nums
	 * @return
	 */
	public static String smallestNumOfArray(int []nums) {
		//获得数组中元素组合的全排列
		List<String> list=new ArrayList<String>();
		boolean []flag=new boolean[nums.length];
		backtrack(nums, new ArrayList(), list, flag);
		System.out.println(list);
		//这块不能使用排序算法，因为得到排列的字符串可能是长度超出整数的表示范围
		String s1=list.get(0), s2;
		
		for(int i=1; i<list.size(); i++) {
			s2=list.get(i);
			//比较两个字符串的大小
			int res=compareString(s1, s2);
			
			if(res==1 || res==0) {
				continue;
			}else if(res==-1){
				s1=s2;
			}
		}
		return s1;
	}
	
	/**
	 * 递归的方式实现数组中元素的组合过程
	 * @param nums
	 * @param tempList
	 * @param list
	 * @param flag
	 */
	public static void backtrack(int []nums, List<Integer>tempList, List<String> list, boolean []flag) {
		if(tempList.size()==nums.length) {
			//将排列转化为一个字符串，
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<tempList.size(); i++) {
				sb.append(tempList.get(i));
			}
			list.add(sb.toString());
		}else {
			for(int i=0; i<nums.length; i++) {
				if(flag[i]==false) {
					tempList.add(nums[i]);
					flag[i]=true;
					backtrack(nums, tempList, list, flag);
					flag[i]=false;
					tempList.remove(tempList.size()-1);
				}
			}
		}
	}
	
	
	/**
	 * 比较两个字符串，按照字符比对，如果左边的字典序小于右边，返回+1，相同返回0，大于右边返回-1
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int compareString(String s1, String s2) {
		int len=s1.length();
		char c1;
		char c2;
		for(int i=0; i<len; i++) {
			c1=s1.charAt(i);
			c2=s2.charAt(i);
			if(c1<c2) {
				return 1;
			}else if(c1>c2) {
				return -1;
			}else {
				continue;
			}
		}
		//两个字符串相等
		return 0;
	}
	
	/**
	 * 剑指offer上面提供的方法
	 * 拼接两个相邻的数，通过字符串比较方法，返回他们拼接之后最小的那个，依次拼接直到数组中所有的元素拼接完成
	 * @param nums
	 * @return
	 */
	public static String smallestNumOfArray_1(int []nums) {
		
		String res=nums[0]+"";
		String s1, s2;
		
		for(int i=1; i<nums.length; i++) {
			//得到两种拼接的形式
			s1=res+nums[i];
			s2=nums[i]+res;
			//判断拼接之后哪个最小
			res=compare(s1, s2);
		}
		return res;
	}
	
	/**
	 * 前提是两个字符串的长度相同
	 * 比较两个字符串中的最小值，按照asccii码值的大小来实现
	 * @param s1
	 * @param s2
	 * @return	返回ascci码前缀最小的那个字符串
	 */
	public static String compare(String s1, String s2) {

		char c1, c2;
		for(int i=0; i<s1.length(); i++) {
			c1=s1.charAt(i);
			c2=s2.charAt(i);
			if(c1<c2) {
				return s1;
			}else if(c1>c2) {
				return s2;
			}else {
				continue;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {3, 32, 321};
		String res=smallestNumOfArray_1(nums);
		System.out.println(res);
	}

}
