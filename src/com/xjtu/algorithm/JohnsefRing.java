package com.xjtu.algorithm;

import java.util.LinkedList;

public class JohnsefRing {

	/**
	 * 约瑟夫环，初始的每个人的权值，以及第一个被删除的人的下标
	 * @param nums
	 * @param k
	 */
	public static void johnsefRing(int []nums, int k) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		//将元素放置到双向链表中
		for(int K : nums) {
			list.add(K);
		}
		//下次需要遍历的次数
		int count=k;
		//下次遍历的开始节点位置
		int start=0;
		boolean isFirst=true;
		while(!list.isEmpty()) {
			int index=-1;
			if(isFirst) {
				//获得要出列的节点索引
				index=(start+count) % list.size();
				isFirst=false;
			}else {
				index=(start+1+count) % list.size();
			}

			//输出节点的值
			int data=list.get(index);
			System.out.print(index+"\t");
			list.remove(index);
			//下次需要报数的个数
			count=data;
			//下次开始的位置
			start=index;
		}
	}
	
	/**
	 * 我们现在将每个元素和它初始的索引写入到结构中去
	 * @param nums
	 * @param k
	 */
	public static void johnsefRing_1(int []nums, int k) {
		LinkedList<int []>list=new LinkedList<int []>();
		//每一个元素的索引和它对应的值
		for(int i=0; i<nums.length; i++) {
			list.add(new int[] {i+1, nums[i]});
		}
		//第一次开始的索引
		int start=0;
		//第一次开始遍历次数
		int count=k;
		
		while(!list.isEmpty()) {
			//下个节点的位置
			int index=(start+count) % list.size();
			index=index-1;
			if(index<0) {
				index=list.size()-1;
			}
			//取出该节点
			int []temp=list.get(index);
			list.remove(index);
			//输出该节点原始索引位置
			System.out.print(temp[0]+"\t");
			//更新下个开始的位置，从当前元素的下一个开始
			start=index+1;
			//下次遍历的次数
			count=temp[1];
		}
		
	}
	
	/**
	 * 尝试直接根据给定的数组的条件下实现
	 * @param nums
	 * @param k
	 */
	public static void johnsefRing_2(int []nums, int k) {
		
		int start=0;
		int len=nums.length;
		//遍历的次数是元素的个数
		for(int i=0; i<nums.length; i++) {
			int index=(start+k) % len;
			if(index==0) {
				index=len-1;
			}
			System.out.print(nums[index-1]);
			start=index;
			len--;
		}
	}
	
	
	public static void johnsefRing_3(int []nums, int k) {
		int pos=backtrack(nums.length, k);
		System.out.println(pos);
	}
	
	public static int backtrack(int people, int m) {
		if(people==1) {
			return 0;
		}
		return (backtrack(people-1, m)+m) % people;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {3,1,7,2,4,8,4};
		int k=20;
		johnsefRing_1(nums, k);
	}

}
