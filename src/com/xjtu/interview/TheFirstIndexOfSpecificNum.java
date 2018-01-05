package com.xjtu.interview;

public class TheFirstIndexOfSpecificNum {

	/**
	 * 找到给定数在数组中第一次出现的位置
	 * 数组中相邻元素的差的绝对值为1
	 * @param nums
	 * @param a
	 * @return int
	 */
	private int theFirstIndexOfSpecificNum(int []nums, int a) {
		int index=-1;
		for(int i=0; i<nums.length;) {
			if(nums[i]==a) {
				return i;
			}
			i+=(Math.abs(a-nums[i]));			
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {3,4,5,6,5,6,7,8,9,8};
		TheFirstIndexOfSpecificNum first=new TheFirstIndexOfSpecificNum();
		int a=11;
		int res=first.theFirstIndexOfSpecificNum(nums, a);
		System.out.println(res);
		
	}

}
