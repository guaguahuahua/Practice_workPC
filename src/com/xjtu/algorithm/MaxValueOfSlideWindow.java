package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * @author Administrator
 *
 */
public class MaxValueOfSlideWindow {

	/**
	 * 使用三个栈，两个栈模拟队列，一个栈用来存放最大值
	 * @param nums
	 * @return
	 */
	public static int [] maxValueOfSlideWindow(int []nums, int k) {
		
		int []res=new int[nums.length-k+1];
		LinkedList<Integer> A=new LinkedList<Integer>();
		LinkedList<Integer> B=new LinkedList<Integer>();
		LinkedList<Integer> max=new LinkedList<Integer>();
		int i;
		//入队列操作
		for(i=0; i<k; i++) {
			if(max.isEmpty()) {
				max.push(nums[i]);
			}else {
				if(nums[i]>max.peek()) {
					max.push(nums[i]);
				}else {
					max.push(max.peek());
				}
			}
			A.push(nums[i]);
		}
		//存放最大值开始的索引
		int index=0;
		for( ;i<nums.length; i++, index++) {
			res[index]=max.peek();
			//现在出队列
			if(B.isEmpty()) {
				while(!A.isEmpty()) {
					B.push(A.pop());
				}
			}
			int t=B.pop();
			if(t==max.peek()) {
				max.pop();
			}
			//新元素入队列
			if(A.isEmpty()) {
				while(!B.isEmpty()) {
					A.push(B.pop());
				}
			}
			if(nums[i]>max.peek()) {
				max.push(nums[i]);
			}else {
				max.push(max.peek());
			}
			A.push(nums[i]);
		}	
		if(B.isEmpty()) {
			while(!A.isEmpty()) {
				B.push(A.pop());
			}
		}
		int t=B.pop();
		if(t==max.peek()) {
			max.pop();
		}
		res[index]=max.peek();
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {2,3,4,2,6,2,5,1};
		int []res=maxValueOfSlideWindow(nums, 3);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]+"\t");
		}
	}

}
