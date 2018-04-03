package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackProblem {

	/**
	 * 已知入栈队列，现在要判断给定的某个序列是否为它的出栈序列
	 * @param push
	 * @param pop
	 * @return
	 */
	public static boolean stackProblem(int []push, int []pop) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		int i=0;
		int j=0;
		while(j<pop.length) {
			
			if(i<push.length) {
				if(stack.isEmpty() || stack.peek()!=pop[j]) {
					stack.push(push[i]);
					i++;
				}
				
				//如果栈顶元素和当前给定的出栈序列指向的元素相同，那么出栈
				while(!stack.isEmpty() && stack.peek()==pop[j]) {
					stack.pop();				
					j++;
				}	
			}else {
				return false;
			}			
		}
		System.out.println(i+", j:"+j);
		return true;
	}
	
	
	
	/**
	 * 这个方法没有成功，主要是不知道如何得到出栈的所有序列
	 * @param stack
	 * @param nums
	 * @param start
	 * @param tempList
	 * @param all
	 */
	public static void backtrack(LinkedList<Integer>stack, int []nums, int start, List<Integer> tempList, List<List<Integer>>all) {
		//递归的出口
		if(start>nums.length-1) {
			return;
		//如果元素都已经被遍历过了	
		}else if(tempList.size()==nums.length) {
			all.add(new ArrayList(tempList));
		}else {
			//如果栈为空
			if(stack.isEmpty()) {
				stack.push(nums[start]);
				backtrack(stack, nums, start+1, tempList, all);
			//如果栈不为空
			}else {
				stack.push(nums[start]);				
			}
		}
		
	}
	
	
	public static boolean stackProblem_1(int []push, int []pop) {
		
		//遍历入栈和出栈两个序列
		int i=0;
		int j=0;
		LinkedList<Integer> stack=new LinkedList<Integer>();
		
		while(i<push.length && j<pop.length) {
			//如果栈是空的
			if(stack.isEmpty() || stack.peek()!=pop[j]) {
				stack.push(push[i]);
				i++;
			}
			while(!stack.isEmpty() && stack.peek()==pop[j]) {
				stack.pop();
				j++;
			}			
		}
		
		//如果匹配，那么索引的最终值是相等的，否则它们最终的序列是不同的
		if(i==j) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []push= {1,2,3,4,5};
//		int []pop= {5,4,3,2,1};
		int []pop= {2,1,5,3,4};
		boolean res=stackProblem_1(push, pop);
		System.out.println(res);
	}

}
