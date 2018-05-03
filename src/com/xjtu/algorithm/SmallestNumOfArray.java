package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �����������飬�������е�Ԫ�����Ϊһ��������������Ϊ��������е���Сֵ
 * @author Administrator
 *
 */
public class SmallestNumOfArray {

	/**
	 * ����1��ֱ��ͨ���ݹ�ķ�ʽ�ҵ��������е����п��ܣ�ͨ���������е���Сֵ�ķ�ʽ�õ����������е���Сֵ
	 * @param nums
	 * @return
	 */
	public static String smallestNumOfArray(int []nums) {
		//���������Ԫ����ϵ�ȫ����
		List<String> list=new ArrayList<String>();
		boolean []flag=new boolean[nums.length];
		backtrack(nums, new ArrayList(), list, flag);
		System.out.println(list);
		//��鲻��ʹ�������㷨����Ϊ�õ����е��ַ��������ǳ��ȳ��������ı�ʾ��Χ
		String s1=list.get(0), s2;
		
		for(int i=1; i<list.size(); i++) {
			s2=list.get(i);
			//�Ƚ������ַ����Ĵ�С
			int res=compareString(s1, s2);
			
			if(res==1 || res==0) {
				continue;
			}else if(res==-1){
				s1=s2;
			}
		}
		return s1;
	}
	
	/**
	 * �ݹ�ķ�ʽʵ��������Ԫ�ص���Ϲ���
	 * @param nums
	 * @param tempList
	 * @param list
	 * @param flag
	 */
	public static void backtrack(int []nums, List<Integer>tempList, List<String> list, boolean []flag) {
		if(tempList.size()==nums.length) {
			//������ת��Ϊһ���ַ�����
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<tempList.size(); i++) {
				sb.append(tempList.get(i));
			}
			list.add(sb.toString());
		}else {
			for(int i=0; i<nums.length; i++) {
				if(flag[i]==false) {
					tempList.add(nums[i]);
					flag[i]=true;
					backtrack(nums, tempList, list, flag);
					flag[i]=false;
					tempList.remove(tempList.size()-1);
				}
			}
		}
	}
	
	
	/**
	 * �Ƚ������ַ����������ַ��ȶԣ������ߵ��ֵ���С���ұߣ�����+1����ͬ����0�������ұ߷���-1
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int compareString(String s1, String s2) {
		int len=s1.length();
		char c1;
		char c2;
		for(int i=0; i<len; i++) {
			c1=s1.charAt(i);
			c2=s2.charAt(i);
			if(c1<c2) {
				return 1;
			}else if(c1>c2) {
				return -1;
			}else {
				continue;
			}
		}
		//�����ַ������
		return 0;
	}
	
	/**
	 * ��ָoffer�����ṩ�ķ���
	 * ƴ���������ڵ�����ͨ���ַ����ȽϷ�������������ƴ��֮����С���Ǹ�������ƴ��ֱ�����������е�Ԫ��ƴ�����
	 * @param nums
	 * @return
	 */
	public static String smallestNumOfArray_1(int []nums) {
		
		String res=nums[0]+"";
		String s1, s2;
		
		for(int i=1; i<nums.length; i++) {
			//�õ�����ƴ�ӵ���ʽ
			s1=res+nums[i];
			s2=nums[i]+res;
			//�ж�ƴ��֮���ĸ���С
			res=compare(s1, s2);
		}
		return res;
	}
	
	/**
	 * ǰ���������ַ����ĳ�����ͬ
	 * �Ƚ������ַ����е���Сֵ������asccii��ֵ�Ĵ�С��ʵ��
	 * @param s1
	 * @param s2
	 * @return	����ascci��ǰ׺��С���Ǹ��ַ���
	 */
	public static String compare(String s1, String s2) {

		char c1, c2;
		for(int i=0; i<s1.length(); i++) {
			c1=s1.charAt(i);
			c2=s2.charAt(i);
			if(c1<c2) {
				return s1;
			}else if(c1>c2) {
				return s2;
			}else {
				continue;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {3, 32, 321};
		String res=smallestNumOfArray_1(nums);
		System.out.println(res);
	}

}
