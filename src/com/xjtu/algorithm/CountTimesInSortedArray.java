package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * ͳ��һ��Ԫ�������������г��ֵĴ���
 * @author Administrator
 *
 */
public class CountTimesInSortedArray {

	/**
	 * ֱ����������
	 * @param nums
	 * @param ele
	 * @return
	 */
	public static int countTimesInSortedArray(int []nums, int ele) {
		
		int count=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==ele) {
				count++;
			}
			if(nums[i]>ele) {
				break;
			}
			
		}
		return count;
	}
	
	/**
	 * ��ǰһ�ַ�����Ч�������˴洢��ͬʱҲ�������������飬ʱ����������
	 * ʹ��map����ʽ���ÿ�������ֵĴ��������ֱ�ӷ��ز���Ԫ�صĴ���
	 * @param nums
	 * @param ele
	 * @return
	 */
	public static int countTimesInSortedArray_1(int []nums, int ele) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		return map.get(ele);
	}
	
	/**
	 * ͨ�����ֲ��ҷ����ҵ�Ԫ�ص�һ�γ��ֵ�λ�ã�Ȼ��ֱ���ǰ������
	 * @param nums
	 * @param ele
	 * @return
	 */
	public static int countTimesInSortedArray_2(int []nums, int ele) {
		int count=0;
		int index=binSearch(nums, 0, nums.length-1, ele);
		//��ǰ����
		for(int i=index; i>=0; i--) {
			if(nums[i]==ele) {
				count++;
			}
			if(nums[i]<ele) {
				break;
			}
		}
		//�������
		for(int i=index; i<nums.length; i++) {
			if(nums[i]==ele) {
				count++;
			}
			if(nums[i]>ele) {
				break;
			}
		}
		return count-1;
	}
	
	public static int binSearch(int []nums, int l, int r, int ele) {
		
		int m=l+(r-l)/2;
		if(nums[m]==ele) {
			return m;
		}else if(nums[m]>ele) {
			return binSearch(nums, l, m-1, ele);
		}else if(nums[m]<ele) {
			return binSearch(nums, m+1, r, ele);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,2,2,2,2,2,3,4,5};
		int res=countTimesInSortedArray_2(nums, 2);
		System.out.println(res);
		
//		int res=binSearch(nums, 0, nums.length-1, 2);
//		System.out.println(res);
	}

}
