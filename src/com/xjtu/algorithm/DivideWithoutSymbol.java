package com.xjtu.algorithm;

/**
 * 求数组的乘积，不允许使用除法符号
 * @author Administrator
 *
 */
public class DivideWithoutSymbol {

	/**
	 * 分别获得从前向后和从后向前的两个数组，分别存放的内容是
	 * 累计乘积，A每个位置的元素是前面所有元素的乘积，或者B后面所有元素的乘积
	 * 然后遍历两个数组，返回值数组中每个位置的元素是A[i-1]*B[i+1]数组乘积
	 * @param nums
	 * @return
	 */
	public static int [] divideWithoutSymbol(int []nums) {
		
		int []fromPost=new int[nums.length];
		fromPost[nums.length-1]=nums[nums.length-1];
		//获得从后面到前面的数的依次的乘积
		for(int i=nums.length-2; i>=0; i--) {
			int r=fromPost[i+1]*nums[i];
			fromPost[i]=r;
		}
		//从前面获得前面每个数累积乘积
		for(int i=1; i<nums.length; i++) {
			nums[i]=nums[i]*nums[i-1];
		}
		int []r=new int[nums.length];
		
		for(int i=0; i<r.length; i++) {
			if(i-1>=0 && i+1<=nums.length-1) {
				r[i]=nums[i-1]*fromPost[i+1];
			}else if(i-1<0) {
				r[i]=fromPost[i+1];
			}else if(i+1>nums.length-1) {
				r[i]=nums[i-1];
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1, 2, 3, 4, 5};
		int []res=divideWithoutSymbol(nums);
		
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]+"\t");
		}
	}

}
