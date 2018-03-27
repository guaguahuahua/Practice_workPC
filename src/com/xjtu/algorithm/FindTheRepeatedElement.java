/**
 * 
 */
package com.xjtu.algorithm;

/**
 * @author Administrator
 *
 */
public class FindTheRepeatedElement {
	
	/**
	 * 如果可以使用额外的空间
	 * 那么使用hash映射
	 * @param nums
	 */
	public static void findTheRepeatedElement(int []nums) {
		int []table=new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			if(table[nums[i]]==0) {
				table[nums[i]]++;				
			}else {
				System.out.println(nums[i]);
				break;
			}
		}
	}
	
	/**
	 * 不使用额外空间， 直接用数字法
	 * @param nums
	 */
	public static void findTheRepeatedElement_1(int []nums) {
		int pra=(1+nums.length-1)*(nums.length-1)/2;
		int sum=0;
		for(int K:nums) {
			sum+=K;
		}
		System.out.println(sum-pra);
	}
	
	/**
	 * 使用亦或的方式实现
	 * @param nums
	 */
	public static void findTheRepeatedElement_2(int []nums) {
		int res=0;
		for(int i=0; i<nums.length; i++) {
			res^=(i^nums[i]);
		}
		System.out.println(res);
	}
	
	public static void main(String []args) {
		int []nums= {2,3,4,5,6,7,1,9,9,8};
		findTheRepeatedElement_2(nums);
	}
}
