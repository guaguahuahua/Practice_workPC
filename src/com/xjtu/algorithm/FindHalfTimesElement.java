package com.xjtu.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * �ҵ������г��ִ�������һ���Ԫ��
 * @author Administrator
 *
 */
public class FindHalfTimesElement {

	/**
	 * ������������֮���ͷ��β���б�����ͳ��ÿ��Ԫ�س��ִ���������������������һ��
	 * ��ô������ѭ�����������
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement(int []nums) {
		
		if(nums.length==0) {
			return -1;
		}
		Arrays.sort(nums);
		//����һ��ĳ���
		int max=nums.length/2;
		//ͳ��Ԫ�س��ֵĴ���
		int times=1;
		//��ų���һ���Ԫ��
		int ele=0;
		int l=0, r=1; 
		while(r<nums.length) {
			if(nums[l]==nums[r]) {
				times++;
				r++;
			}else {
				if(times>max) {
					ele=nums[l];
					break;
				}
				//���û�ҵ�
				times=1;
				l=r;
				r=r+1;
			}
		}
		return ele;
	}
	
	/**
	 * ʹ��map��¼ÿ�������ֵĴ�����ʱ�临�Ӷ�С��ǰһ��
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement_1(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		//����ÿ��Ԫ�غ�����Ӧ�Ĵ���
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		//����mapѰ�ҳ��ִ�������һ���Ԫ��
		int max=nums.length/2;
		for(Entry<Integer, Integer> es:map.entrySet()) {
			if(map.get(es.getKey())>max) {
				return es.getKey();
			}
		}
		return -1;
	}
	
	/**
	 * Ԫ�س��ֵĴ���������һ�룬��ô��Ԫ�صĳ��ִ���������Ԫ�س��ִ����ĺͻ�Ҫ��
	 * ��ôʹ�ö��󷨣��������ͬ�ģ���ô+1������-1����ô���ʣ�µľ��ǳ���һ�������Ԫ��
	 * @return
	 */
	public static int findHalfTimesElement_2(int []nums) {
		
		int count=1;
		int ele=-1;
		int l=0, r=1;
		while(r<nums.length) {
			//eleָ����ʹcount++��Ԫ�أ�
			if(nums[l]==nums[r]){
				count++;
				ele=nums[l];
				r++;
				
			//���������ͬԪ�أ�	
			}else {
				l=r;
				r=r+1;
				count=count-1;
			}
		}
		return ele;
	}
	
	/**
	 * ��2���иĽ���
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement_3(int []nums) {
		if(nums.length==0) {
			return -1;
		}
		int count=1;
		int ele=nums[0];
		for(int i=1; i<nums.length; i++) {
			//��ͬԪ��+1
			if(nums[i]==ele) {
				count++;
			//����-1	
			}else {
				count--;
			}
			if(count==0) {
				ele=nums[i];
			}			
		}
		return ele;
	}
	
	/**
	 * ���һ�������ֵĴ�����������Ԫ�ص�һ�룬��ô��������֮�������м���Ǹ�Ԫ�ؾ��ǳ���һ����Ǹ�Ԫ��
	 * @param nums
	 * @return
	 */
	public static int findHalfTimesElement_4(int []nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3,4,5,2,2,2,2,2};
		int res=findHalfTimesElement_4(nums);
		System.out.println(res);
	}

}
