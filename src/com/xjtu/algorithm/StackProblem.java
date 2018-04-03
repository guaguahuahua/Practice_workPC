package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackProblem {

	/**
	 * ��֪��ջ���У�����Ҫ�жϸ�����ĳ�������Ƿ�Ϊ���ĳ�ջ����
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
				
				//���ջ��Ԫ�غ͵�ǰ�����ĳ�ջ����ָ���Ԫ����ͬ����ô��ջ
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
	 * �������û�гɹ�����Ҫ�ǲ�֪����εõ���ջ����������
	 * @param stack
	 * @param nums
	 * @param start
	 * @param tempList
	 * @param all
	 */
	public static void backtrack(LinkedList<Integer>stack, int []nums, int start, List<Integer> tempList, List<List<Integer>>all) {
		//�ݹ�ĳ���
		if(start>nums.length-1) {
			return;
		//���Ԫ�ض��Ѿ�����������	
		}else if(tempList.size()==nums.length) {
			all.add(new ArrayList(tempList));
		}else {
			//���ջΪ��
			if(stack.isEmpty()) {
				stack.push(nums[start]);
				backtrack(stack, nums, start+1, tempList, all);
			//���ջ��Ϊ��
			}else {
				stack.push(nums[start]);				
			}
		}
		
	}
	
	
	public static boolean stackProblem_1(int []push, int []pop) {
		
		//������ջ�ͳ�ջ��������
		int i=0;
		int j=0;
		LinkedList<Integer> stack=new LinkedList<Integer>();
		
		while(i<push.length && j<pop.length) {
			//���ջ�ǿյ�
			if(stack.isEmpty() || stack.peek()!=pop[j]) {
				stack.push(push[i]);
				i++;
			}
			while(!stack.isEmpty() && stack.peek()==pop[j]) {
				stack.pop();
				j++;
			}			
		}
		
		//���ƥ�䣬��ô����������ֵ����ȵģ������������յ������ǲ�ͬ��
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
