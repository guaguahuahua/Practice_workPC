package com.xjtu.algorithm;

/**
 * ������������ĺ�
 * @author Administrator
 *
 */
public class MaxSubArray_1 {

	/**
	 * ����ö��
	 * @param nums
	 * @return
	 */
	public static int maxSubArray_1(int []nums) {
		
		int max=Integer.MIN_VALUE;
		//�����𽥴�1�ӳ�
		for(int len=1; len<=nums.length; len++) {
			for(int i=0; i<=nums.length-len; i++) {
				int temp=0;
				//ȡ��len���ȸ�Ԫ��
				for(int j=i; j<i+len; j++) {
					temp+=nums[j];
				}
				//�ж������ֵ֮��Ĳ��
				if(temp>max) {
					max=temp;
				}
			}
		}
		return max;
	}
	
	/**
	 * ����̰���㷨
	 * @param nums
	 * @return
	 */
	public static int maxSubArray_2(int []nums){
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			if(sum>max) {
				max=sum;
			}
			if(sum<0) {
				sum=0;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={6,-3,-2,7,-15,1,2,2};
		int []nums= {-1,-3,-6,-87};
		int res=maxSubArray_2(nums);
		System.out.println(res+"\t");
	}

}
