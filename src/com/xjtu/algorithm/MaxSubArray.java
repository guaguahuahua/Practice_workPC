package com.xjtu.algorithm;

public class MaxSubArray {
	
	/**
	 * ����ö�ٷ����ӳ���Ϊ1���Ӵ�һֱ������Ϊ������Ӵ�
	 * @param nums	int[]
	 * @return	int
	 */
	public static int maxSubArray(int []nums) {
		int max=Integer.MIN_VALUE;
		for(int len=1; len<=nums.length; len++) {
			//ÿ�ο�ʼ������λ��
			for(int start=0; start<=nums.length-len; start++) {
				//ȡlen���ȸ�Ԫ��
				int length=len;
				int temp=0;
				int tIndex=start;
				while(length>0) {
					temp+=nums[tIndex];
					tIndex++;
					length--;
				}
				//�����ֵ���бȽ�
				if(temp>max) {
					max=temp;
				}
			}
		}
		System.out.println(max);
		return max;
	}
	
	/**
	 * ���������ĵ�̰���㷨���
	 * @param nums	int []
	 * @return	int
	 */
	public static int maxSubArray_1(int []nums) {
		int max=Integer.MIN_VALUE;
		int temp=0;
		for(int index=0; index<nums.length; index++) {
			temp+=nums[index];
			if(temp>max) {
				max=temp;
			}
			if(temp<0) {
				temp=0;
			}
			
		}
		System.out.println(max);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,-2,3,10,-4,7,2,-5};
		maxSubArray_1(nums);
	}

}
