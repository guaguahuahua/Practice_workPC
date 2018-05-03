package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.xjtu.LinkedList.Node;

/**
 * 报数游戏，类似于约瑟夫环
 * @author Administrator
 *
 */
public class SayNums {
	
	/**
	 * 使用集合实现
	 * @param nums
	 * @return
	 */
	public static List<Integer> sayNums(int []nums, int k) {
		 
		List<Integer> res=new ArrayList<Integer>();
		List<Integer> list=new ArrayList<Integer>();
		//首先将元素放置在list中去
		for(int i=0; i<nums.length; i++) {
			list.add(nums[i]);
		}
		
		int index=0;
		//报数开始
		while(!list.isEmpty()) {
			index=(k+index)%list.size();
			index=index-1;
			if(index==-1) {
				index=list.size()-1;
			}			
			res.add(list.remove(index));
			if(list.size()!=0) {
				index=(index+1)%list.size();	
			}			
		}
		return res;
	}
	
	/**
	 * 使用单链表实现
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Integer> sayNums_1(int []nums, int k) {
		List<Integer> res=new ArrayList<Integer>();
		//创建循环单链表
		Node head=new Node(nums[0]);
		Node rear=head;
		for(int i=1; i<nums.length; i++) {
			Node node=new Node(nums[i]);
			rear.next=node;
			rear=node;
		}
		rear.next=head;
//		show(head);
		int start=1;
		Node begin=head;
		//报数
		while(begin!=null) {
			Node pre=begin;
			while(start!=k) {
				pre=begin;
				begin=begin.next;
				start++;
			}
			//删除节点
			res.add(begin.data);
			pre.next=begin.next;
			begin.next=null;
			start=1;
			begin=pre.next;
		}
		return res;
	}
	
	public static void show(Node head) {
		Node h=head;
		while(h.next!=head) {
			System.out.print(h.data+"\t");
			h=h.next;
		}
		System.out.println(h.data);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,10, 8, 5, 6};
		int k=6;
		List<Integer> res=sayNums_1(nums, k);
		System.out.println(res);
	}

}
