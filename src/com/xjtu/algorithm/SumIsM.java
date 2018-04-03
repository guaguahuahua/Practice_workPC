package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SumIsM {
	
	
	public static List<List<Integer>> sumIsM(int n, int m) {
		//���ɳ���Ϊn������
//		int []nums=new int[n];
//		for(int i=0; i<nums.length; i++) {
//			nums[i]=i+1;
//		}		
//		show(nums);
		int []nums= {1,2,5};
		m=100;
		//ʹ�õݹ�
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList(), nums, m, 0);		
		return list;
	}
	
	/**
	 * ���ʹ�õĵݹ����Ǵӵ�һ��Ԫ�ؿ�ʼ����
	 * @param list
	 * @param tempList
	 * @param nums
	 * @param remain
	 * @param start
	 */
	public static void backtrack(List<List<Integer>> list, List<Integer>tempList, int []nums, int remain, int start) {
		if(remain<0) {
			return;
		}else if(remain==0) {
			if(repeated(list, new ArrayList(tempList), nums.length)) {
				list.add(new ArrayList(tempList));
			}
			
//			if(!list.contains(tempList)) {
//				list.add(new ArrayList(tempList));	
//			}
//			list.add(new ArrayList(tempList));
			
		}else {
			
			for(int i=start; i<nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain-nums[i], start);
				tempList.remove(tempList.size()-1);
			}			
		}
	}
	
	/**
	 * ���������ͬ����ô�ͱȽ�����Ԫ�ص�����Ԫ���Ƿ���ͬ��Ԫ��Ҳ����ͬ������£���ôcount++
	 * ������Ȳ�ͬ����ôֱ��count++
	 * @param list
	 * @param tempList
	 * @param len
	 * @return
	 */
	public static boolean repeated(List<List<Integer>>list, ArrayList<Integer> tempList, int len) {
		//ͳ�Ʋ�һ����Ԫ�صĸ���
		int count=0;
		for(int i=0; i<list.size(); i++) {
			List<Integer> t=list.get(i);
			//�ж���������Ƿ���ͬ
			boolean isSame=true;
			//���������ͬ
			if(t.size()==tempList.size()) {
				int []table=new int[len];
				for(int j=0; j<t.size(); j++) {
					table[t.get(j)-1]++;
				}
				for(int j=0; j<tempList.size(); j++) {
					table[tempList.get(j)-1]--;
				}
				
				for(int j=0; j<table.length; j++) {
					if(table[j]!=0) {
						count++;
						break;
					}
				}
			}else {
				isSame=false;
				count++;
			}
		}
		if(count==list.size()) {
			return true;
		}else {
			return false;
		}		
	}
	
	
	public static void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		int m=13;
		List<List<Integer>>res=sumIsM(n ,m);
		System.out.println(res);
		System.out.println(res.size());
	}
}
