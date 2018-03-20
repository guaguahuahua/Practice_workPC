package com.xjtu.algorithm;

import java.util.LinkedList;

public class NextBigger {
	
	/**
	 * 使用栈来实现
	 * @param nums
	 */
	public static void nextBigger(int []nums) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		//遍历整个数组
		int i=0; 
		while(i<nums.length) {

			//栈为空
			if(stack.isEmpty()) {
				stack.push(nums[i]);
				i++;
			//栈不为空
			}else {
				//如果数组元素小于等于栈顶元素，那么入栈
				if(stack.peek()>nums[i]) {
					stack.push(nums[i]);
					i++;
				//如果数组元素大于栈顶元素，出栈顶元素，并输出该元素	
				}else {
					stack.pop();
					System.out.print(nums[i]+"\t");
				}
			}
		}
		//排空栈
		while(!stack.isEmpty()) {
			stack.pop();
			System.out.print(-1+"\t");
		}
	}
	
	/**
	 * 使用最原始的方式实现
	 * @param nums
	 */
	public static int [] nextBigger_1(int []nums) {
		//存放最后的结果
		int []res=new int[nums.length];
		int left=0; 
		int right=0;
		
		while(left<nums.length) {
			while(right<nums.length && nums[left]>=nums[right]) {
				right++;
			}
			if(right>=nums.length) {
				res[left]=-1;
			}else {
				res[left]=nums[right];
			}
			left++;
			right=left;	
		}
		return res;
	}
	
	/**
	 * 使用队列实现
	 * 运行结果是错误的，使用队列实现还是有问题的,主要是将类似这样的序列"7,1,2,8"结果为错
	 * @param nums
	 * @return
	 */
	public static int [] nextBigger_2(int []nums){
		LinkedList<Integer> queue=new LinkedList<Integer>();
		int []res=new int[nums.length];
		int index=0;
		for(int i=0; i<nums.length; i++) {
			if(queue.isEmpty()) {
				queue.add(nums[i]);
			}else {
				if(queue.peekFirst()>=nums[i]) {
					queue.add(nums[i]);
				}else {
					while(!queue.isEmpty() && queue.peekFirst()<nums[i]) {
						queue.poll();
						res[index]=nums[i];
						index++;
					}
					if(queue.isEmpty()) {
						queue.add(nums[i]);
					}
				}
			}
		}
		while(!queue.isEmpty()) {
			queue.poll();
			res[index]=-1;
			index++;
		}
		return res;
	}
	
	/**
	 * 使用栈来实现
	 * 这块为什么使用索引入栈而不是元素入栈的原因是：如果是索引入栈，那么只要栈顶元素值<入栈元素值，那么直接在对应的数组
	 * 的位置可以写入结果，而如果采用的是值入栈，那么写入的位置没法确定，是顺序写入的，所以会出现各种错误
	 * @param nums
	 * @return
	 */
	public static int[] nextBigger_3(int []nums) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		int []res=new int[nums.length];
		//控制存放结果数组的索引
		int index=0;
		//遍历数组中的每一个元素
		for(int i=0; i<nums.length; i++) {
			//栈为空，直接将元素的索引入栈
			if(stack.isEmpty()) {
				stack.push(i);
			}else {
				if(nums[stack.peek()]>=nums[i]) {
					stack.push(i);
				}else {
					res[stack.pop()]=nums[i];
					if(stack.isEmpty()) {
						stack.push(i);
					}else {
						i--;	
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			res[stack.pop()]=-1;
			index++;
		}
		return res;
	}
	
	
	public static void main(String []args) {
//		int []nums= {5,1,9,7};
		int []nums= {2,5,3,7,1,2,8};
		int []res=nextBigger_3(nums);
		for(int K:res) {
			System.out.print(K+"\t");
		}
	}

}
