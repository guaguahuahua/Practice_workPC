package com.xjtu.algorithm;

public class LongestIncreasingSequence {

	/**
	 * ����ĵ���������
	 * @param nums
	 * @return
	 */
	public static int increasingSequence(int []nums) {
		int length=0,max=0;
		int []count=new int[nums.length];
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i;j>=0;j--) {
				if(nums[j]<nums[i]) {
					max=count[j]>max ? count[j] : max; //��֮ǰӵ��������е�ǰ����Ϊ��ǰ��ǰ��
				}
			}
			count[i]=max+1;
			max=0;
			length=count[i]>length ? count[i] : length; //count�����д�ŵ������еĳ��ȣ�����ȡ�����Ϊ����ֵ
		}		
		return length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {5,2,8,6,3,6,9,7};
//		int []nums= {1,3,4,2};
//		int []nums= {8,6,5,9,2,3,10};
//		int []nums= {1,2,3,4,5,6};
		int res=increasingSequence(nums);
		System.out.println(res);
	}

}
