package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Find2Numbers {

	/**
	 * �ڸ��������������Ѱ��������ʹ�����ǵĺ�Ϊ������target
	 * 
	 * @param nums
	 * @param target
	 * @return	�����ҵ���������	
	 */
	public static List<Integer> find2Numbers(int []nums, int target){
		//��Ҫ����ָ��
		int left=0, right=nums.length-1;
		//��������ҵ����������
		List<Integer> list=new ArrayList<Integer>();
		
		while(left<right) {
			if(nums[left]+nums[right]==target) {
				list.add(nums[left]);
				list.add(nums[right]);
				break;
			}else if(nums[left]+nums[right]>target) {
				right--;
			}else if(nums[left]+nums[right]<target) {
				left++;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,4,7,11,15};
		List<Integer> res=find2Numbers(nums, 15);
		for(int K:res) {
			System.out.print(K+"\t");
		}
		System.out.println();
	}

}
