package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个正整数s，求和为这个正整数的所有序列
 * @author Administrator
 *
 */
public class SumIsS {

	/**
	 * 暴力法
	 * @param s
	 * @return
	 */
	public static List<List<Integer>> sumIsS(int s){

		List<List<Integer>> list=new ArrayList<List<Integer>>();
		//最小的长度要求是2，最大的长度我们设定为不超过s的一半
		for(int len=2; len<=s/2+1; len++) {
			
			for(int i=0; i<s; i++) {
				int temp=0;
				List<Integer> tempList=new ArrayList<Integer>();
				//从第i个元素开始取出len个元素求和
				for(int j=i; j<i+len; j++) {
					tempList.add(j);
					temp=temp+j;
				}
				if(temp==s) {
					list.add(tempList);
				}
			}
		}
		return list;
	}
	
	/**
	 * 使用类似滑动窗口的方式进行
	 * @param s
	 * @return
	 */
	public static List<List<Integer>> sumIsS_1(int s){
		//首先获得一个数组，长度为s
		int []nums=new int[s];
		for(int i=0; i<nums.length; i++) {
			nums[i]=i+1;
		}
		//存放最终的结果集合
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		//分别指向数组的一个范围段
		int l=0, r=1;
		int sum=nums[l];
		List<Integer> tempList=new ArrayList<Integer>();
		tempList.add(nums[l]);
		while(r<nums.length) {
			if(sum<s) {
				sum=sum+nums[r];
				tempList.add(nums[r]);
				r++;
			}else if(sum==s) {
				list.add(new ArrayList(tempList));
				sum=sum+nums[r];
				tempList.add(nums[r]);
			}else if(sum>s) {
				//每次都移除最左侧的一个元素
				sum=sum-tempList.remove(0);
			}
		}
		return list;
	}
	
	/**
	 * 在实际的操作过程中可以不用数组
	 * @param s
	 * @return
	 */
	public static List<List<Integer>> sumIsS_2(int s){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> tempList=new ArrayList<Integer>();
		//直接使用右边的指针控制
		int r=2;
		tempList.add(1);
		//临时和
		int sum=1;
		
		while(r<=s) {
			if(sum<s) {
				sum=sum+r;
				tempList.add(r);
				r++;
			}else if(sum==s) {
				//只将长度超过2的序列存进去
				if(tempList.size()>=2) {
					list.add(new ArrayList(tempList));
				}				
				sum=sum+r;
				tempList.add(r);
			}else if(sum>s){
				sum=sum-tempList.remove(0);
			}
		}
		return list;
	}
	
	
	
	/**
	 * 递增数组，求两个数，使得他们的和为s
	 * @param nums
	 * @param s
	 * @return
	 */
	public static List<Integer> sumIsTwoNums(int []nums, int s){

		List<Integer> list=new ArrayList<Integer>();
		//
		int l=0; 
		int r=nums.length-1;
		while(l<r) {
			int sum=nums[l]+nums[r];
			if(sum==s) {
				list.add(nums[l]);
				list.add(nums[r]);
				//一开始没有添加这个跳出的语句，电脑差点死机了
				break;
			}else if(sum>s){
				r--;
			}else if(sum<s) {
				l++;
			}
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=9;
//		int []nums= {1,2 ,4,7 ,11,15};
//		List res=sumIsTwoNums(nums, s);
//		System.out.println(res);
		List res=sumIsS_2(s);
		System.out.println(res);
		
//		String s="i like xianjiaotong";
//		char []chars=s.toCharArray();
//		System.out.println(chars);
//		String str = "";
//		System.out.println("2:");
//		StringBuilder sb=new StringBuilder();
//		for (int i = 0; i<chars.length; i++ ) {
//			sb.append(chars[i]);
//			str += chars[i];
//			System.out.println(str);
//		}
//		System.out.println(sb.toString());
//		for(char c:chars) {
//			System.out.print(c);
//		}
		
	}
	

}
