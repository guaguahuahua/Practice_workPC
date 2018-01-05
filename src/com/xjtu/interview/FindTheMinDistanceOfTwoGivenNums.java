package com.xjtu.interview;

public class FindTheMinDistanceOfTwoGivenNums {

	/**
	 * 找到两个给定数的最小距离
	 * 首先定义距离，然后定义两个变量c1和c2，分别存放最近访问的两个给定的数的索引
	 * 每次遍历到为给定元素时，更新一次距离的值（用较小值替换较大值），最终遍历结束的时候
	 * 就能得到两个数距离最小值
	 * @param nums
	 * @param n1
	 * @param n2
	 * @return int
	 */
	private int findTheMinDistanceOfTwoGivenNums(int []nums, int n1, int n2) {
		//表示两个元素的初始位置
		int c1=Integer.MAX_VALUE,c2=Integer.MAX_VALUE;
		//记录两个数之间的距离
		int diff=Integer.MAX_VALUE;
		//记录临时的距离值
		int dis=0;
		for(int i=0; i<nums.length; i++) {
			//如果遍历的元素为第一个数
			if(nums[i]==n1) {
				c1=i;
				dis=Math.abs(c1-c2);
				if(dis<diff) {
					diff=dis;
				}
			}
			//如果遍历的元素为第二个数
			if(nums[i]==n2) {
				c2=i;
				dis=Math.abs(c2-c1);
				if(dis<diff) {
					diff=dis;
				}
			}
		}
		return diff;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
//		
//		FindTheMinDistanceOfTwoGivenNums find=new FindTheMinDistanceOfTwoGivenNums();
//		int diff=find.findTheMinDistanceOfTwoGivenNums(nums, 4, 8);
//		System.out.println(diff);
		float b=0.71244F;
		System.out.println(255*b);
	}

}
