package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ѱ���������ظ�������
 * ����ĳ���Ϊn�������е����ķ�Χ��0--(n-1)��,�������ظ���Ԫ�ؿ�����һ�����߶����ֻҪ��������һ������
 * @author Administrator
 *
 */
public class RepeatedNums {
	
	/**
	 * �ȶ�������������֮�����ظ�Ԫ��	
	 * @param nums
	 * @return
	 */
	public static int repeatedNums(int []nums) {
		
		//�������Ϊ�ջ���ֻ��һ��Ԫ�أ���ô�϶��������ظ�Ԫ��
		if(nums.length==0 || nums.length==1) {
			return -1;
		}
		//������������һ��Ԫ��
		Arrays.sort(nums);
		int left=0, right=1;
		while(right<nums.length) {
			if(nums[left]==nums[right]) {
				return nums[left];
			}else {
				left=right;
				right=right+1;
			}
		}
		//���ǰ�涼û���ҵ�
		return -1;
	}

	/**
	 * ʹ�ø�Ч��o(n)����
	 * û�м��߽磬Ҳ�������ֵĺϷ���
	 * @param nums
	 * @return
	 */
	public static int repeatedNums_1(int []nums) {
		boolean []flag=new boolean[nums.length];
		int index=-1;
		for(int i=0; i<nums.length; i++) {
			//ȡ����Ӧ������Ԫ��
			index=nums[i];
			if(!(index>=0 && index<=nums.length-2)) {
				return -1;
			}
			if(flag[index]==true) {
				return index;
			}else {
				//���Ϊ�ѷ���
				flag[index]=true;				
			}
		}
		return -1;
	}
	
	/**
	 * ʹ��list���������ļ�������а�װ
	 * @param nums
	 * @return
	 */
	public static int repeatedNums_2(int []nums) {
		
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++) {
			int t=nums[i];
			//������ݵķ�Χ������Ҫ��
			if(!(t>=0 && t<=nums.length-2)) {
				return -1;
			}
			if(!list.contains(t)) {
				list.add(t);
			}else {
				return t;
			}
		}
		return -1;
	}
	
	/**
	 * ʹ��map���и��õ�Ч��
	 * @param nums
	 * @return
	 */
	public static int repeatedNums_4(int []nums) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			int t=nums[i];
			//������ݵĺϷ���
			if(!(t>=0 && t<=nums.length-2)) {
				return -1;
			}
			int times=map.getOrDefault(t, 0);
			if(times==1) {
				return t;
			}else {
				map.put(t, 1);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,3,2,0,2,5,3};
		int res=repeatedNums_4(nums);
		System.out.println(res);
	}

}
