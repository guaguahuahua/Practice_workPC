package com.xjtu.algorithm;

import java.util.LinkedList;

public class NextBigger {
	
	/**
	 * ʹ��ջ��ʵ��
	 * @param nums
	 */
	public static void nextBigger(int []nums) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		//������������
		int i=0; 
		while(i<nums.length) {

			//ջΪ��
			if(stack.isEmpty()) {
				stack.push(nums[i]);
				i++;
			//ջ��Ϊ��
			}else {
				//�������Ԫ��С�ڵ���ջ��Ԫ�أ���ô��ջ
				if(stack.peek()>nums[i]) {
					stack.push(nums[i]);
					i++;
				//�������Ԫ�ش���ջ��Ԫ�أ���ջ��Ԫ�أ��������Ԫ��	
				}else {
					stack.pop();
					System.out.print(nums[i]+"\t");
				}
			}
		}
		//�ſ�ջ
		while(!stack.isEmpty()) {
			stack.pop();
			System.out.print(-1+"\t");
		}
	}
	
	/**
	 * ʹ����ԭʼ�ķ�ʽʵ��
	 * @param nums
	 */
	public static int [] nextBigger_1(int []nums) {
		//������Ľ��
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
	 * ʹ�ö���ʵ��
	 * ���н���Ǵ���ģ�ʹ�ö���ʵ�ֻ����������,��Ҫ�ǽ���������������"7,1,2,8"���Ϊ��
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
	 * ʹ��ջ��ʵ��
	 * ���Ϊʲôʹ��������ջ������Ԫ����ջ��ԭ���ǣ������������ջ����ôֻҪջ��Ԫ��ֵ<��ջԪ��ֵ����ôֱ���ڶ�Ӧ������
	 * ��λ�ÿ���д��������������õ���ֵ��ջ����ôд���λ��û��ȷ������˳��д��ģ����Ի���ָ��ִ���
	 * @param nums
	 * @return
	 */
	public static int[] nextBigger_3(int []nums) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		int []res=new int[nums.length];
		//���ƴ�Ž�����������
		int index=0;
		//���������е�ÿһ��Ԫ��
		for(int i=0; i<nums.length; i++) {
			//ջΪ�գ�ֱ�ӽ�Ԫ�ص�������ջ
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
