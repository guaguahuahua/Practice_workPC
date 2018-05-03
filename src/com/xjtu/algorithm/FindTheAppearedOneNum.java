package com.xjtu.algorithm;

/**
 * 找到数组中只出现一次的数字，其他的数字都出现了两次
 * @author Administrator
 *
 */
public class FindTheAppearedOneNum {

	/**
	 * 使用亦或的运算实现，出现两次的元素亦或之后的结果是0
	 * 0元素和其他任何元素异或操作是其他元素
	 * @param nums
	 * @return
	 */
	public static int findTheAppearedOneNum(int []nums) {
		int res=0;
		for(int i=0; i<nums.length; i++) {
			res=res^nums[i];
		}
		return res;
	}
	
	/**
	 * 使用通用的方式实现
	 * java中整型是4B，我们将每个数的二进制形式相加
	 * @param nums
	 * @param n	其他数字出现的次数
	 * @return
	 */
	public static int findTheAppearedOneNum_1(int []nums, int n) {
		
		//我们使用32short数组分别存放统计数字的每个位上面的1初心的次数
		short[] times=new short[32];
		for(int i=0; i<nums.length; i++) {
			//获得一个整数
			int num=nums[i];
			//对他的32位进行判断
			for(int j=0; j<32; j++) {
				int t=(1<<j);
				int one=num & t;
				if(one!=0) {
					times[31-j]++;
				}
			}
		}
		//返回最终的结果
		int res=0;
		//寻找这个数字
		for(int i=0; i<times.length; i++) {
			//现在遍历的顺序和十进制数的方向是相反的
			if(times[times.length-i-1] % n != 0) {
				res=res+(int) Math.pow(2, i);
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3,4,5,4,3,2,1}; //6,5,
		int res=findTheAppearedOneNum_1(nums, 2);
		System.out.println(res);
	}

}
