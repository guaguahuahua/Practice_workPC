package com.xjtu.algorithm;

public class BinSearch {
	
	public static int binSearch(int []nums, int find) {
		//����һ������Ϊ�յ�����
		if(nums.length==0) {
			return -1;
		}
		int left=0;
		int right=nums.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(nums[mid]==find) {
				return mid;
			}else if(nums[mid]<find) {
				left=mid+1;
			}else if(nums[mid]>find) {
				right=mid-1;
			}
		}
		
		return -1;
	}
	
	public static void main(String []args) {
		int []nums= {0,1,4,8,14,19};
		int find=14;
		int res=binSearch(nums, find);
		System.out.println(res);
	}

}
