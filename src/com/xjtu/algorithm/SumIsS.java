package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ��������s�����Ϊ�������������������
 * @author Administrator
 *
 */
public class SumIsS {

	/**
	 * ������
	 * @param s
	 * @return
	 */
	public static List<List<Integer>> sumIsS(int s){

		List<List<Integer>> list=new ArrayList<List<Integer>>();
		//��С�ĳ���Ҫ����2�����ĳ��������趨Ϊ������s��һ��
		for(int len=2; len<=s/2+1; len++) {
			
			for(int i=0; i<s; i++) {
				int temp=0;
				List<Integer> tempList=new ArrayList<Integer>();
				//�ӵ�i��Ԫ�ؿ�ʼȡ��len��Ԫ�����
				for(int j=i; j<i+len; j++) {
					tempList.add(j);
					temp=temp+j;
				}
				if(temp==s) {
					list.add(tempList);
				}
			}
		}
		return list;
	}
	
	/**
	 * ʹ�����ƻ������ڵķ�ʽ����
	 * @param s
	 * @return
	 */
	public static List<List<Integer>> sumIsS_1(int s){
		//���Ȼ��һ�����飬����Ϊs
		int []nums=new int[s];
		for(int i=0; i<nums.length; i++) {
			nums[i]=i+1;
		}
		//������յĽ������
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		//�ֱ�ָ�������һ����Χ��
		int l=0, r=1;
		int sum=nums[l];
		List<Integer> tempList=new ArrayList<Integer>();
		tempList.add(nums[l]);
		while(r<nums.length) {
			if(sum<s) {
				sum=sum+nums[r];
				tempList.add(nums[r]);
				r++;
			}else if(sum==s) {
				list.add(new ArrayList(tempList));
				sum=sum+nums[r];
				tempList.add(nums[r]);
			}else if(sum>s) {
				//ÿ�ζ��Ƴ�������һ��Ԫ��
				sum=sum-tempList.remove(0);
			}
		}
		return list;
	}
	
	/**
	 * ��ʵ�ʵĲ��������п��Բ�������
	 * @param s
	 * @return
	 */
	public static List<List<Integer>> sumIsS_2(int s){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> tempList=new ArrayList<Integer>();
		//ֱ��ʹ���ұߵ�ָ�����
		int r=2;
		tempList.add(1);
		//��ʱ��
		int sum=1;
		
		while(r<=s) {
			if(sum<s) {
				sum=sum+r;
				tempList.add(r);
				r++;
			}else if(sum==s) {
				//ֻ�����ȳ���2�����д��ȥ
				if(tempList.size()>=2) {
					list.add(new ArrayList(tempList));
				}				
				sum=sum+r;
				tempList.add(r);
			}else if(sum>s){
				sum=sum-tempList.remove(0);
			}
		}
		return list;
	}
	
	
	
	/**
	 * �������飬����������ʹ�����ǵĺ�Ϊs
	 * @param nums
	 * @param s
	 * @return
	 */
	public static List<Integer> sumIsTwoNums(int []nums, int s){

		List<Integer> list=new ArrayList<Integer>();
		//
		int l=0; 
		int r=nums.length-1;
		while(l<r) {
			int sum=nums[l]+nums[r];
			if(sum==s) {
				list.add(nums[l]);
				list.add(nums[r]);
				//һ��ʼû����������������䣬���Բ��������
				break;
			}else if(sum>s){
				r--;
			}else if(sum<s) {
				l++;
			}
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=9;
//		int []nums= {1,2 ,4,7 ,11,15};
//		List res=sumIsTwoNums(nums, s);
//		System.out.println(res);
		List res=sumIsS_2(s);
		System.out.println(res);
		
//		String s="i like xianjiaotong";
//		char []chars=s.toCharArray();
//		System.out.println(chars);
//		String str = "";
//		System.out.println("2:");
//		StringBuilder sb=new StringBuilder();
//		for (int i = 0; i<chars.length; i++ ) {
//			sb.append(chars[i]);
//			str += chars[i];
//			System.out.println(str);
//		}
//		System.out.println(sb.toString());
//		for(char c:chars) {
//			System.out.print(c);
//		}
		
	}
	

}
