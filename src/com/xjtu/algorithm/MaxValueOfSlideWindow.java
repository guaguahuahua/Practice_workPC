package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * �������ڵ����ֵ
 * @author Administrator
 *
 */
public class MaxValueOfSlideWindow {

	/**
	 * ʹ������ջ������ջģ����У�һ��ջ����������ֵ
	 * @param nums
	 * @return
	 */
	public static int [] maxValueOfSlideWindow(int []nums, int k) {
		
		int []res=new int[nums.length-k+1];
		LinkedList<Integer> A=new LinkedList<Integer>();
		LinkedList<Integer> B=new LinkedList<Integer>();
		LinkedList<Integer> max=new LinkedList<Integer>();
		int i;
		//����в���
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
		//������ֵ��ʼ������
		int index=0;
		for( ;i<nums.length; i++, index++) {
			res[index]=max.peek();
			//���ڳ�����
			if(B.isEmpty()) {
				while(!A.isEmpty()) {
					B.push(A.pop());
				}
			}
			int t=B.pop();
			if(t==max.peek()) {
				max.pop();
			}
			//��Ԫ�������
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
