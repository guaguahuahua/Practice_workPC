package com.xjtu.algorithm;

/**
 * �ҵ�������ֻ����һ�ε����֣����������ֶ�����������
 * @author Administrator
 *
 */
public class FindTheAppearedOneNum {

	/**
	 * ʹ����������ʵ�֣��������ε�Ԫ�����֮��Ľ����0
	 * 0Ԫ�غ������κ�Ԫ��������������Ԫ��
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
	 * ʹ��ͨ�õķ�ʽʵ��
	 * java��������4B�����ǽ�ÿ�����Ķ�������ʽ���
	 * @param nums
	 * @param n	�������ֳ��ֵĴ���
	 * @return
	 */
	public static int findTheAppearedOneNum_1(int []nums, int n) {
		
		//����ʹ��32short����ֱ���ͳ�����ֵ�ÿ��λ�����1���ĵĴ���
		short[] times=new short[32];
		for(int i=0; i<nums.length; i++) {
			//���һ������
			int num=nums[i];
			//������32λ�����ж�
			for(int j=0; j<32; j++) {
				int t=(1<<j);
				int one=num & t;
				if(one!=0) {
					times[31-j]++;
				}
			}
		}
		//�������յĽ��
		int res=0;
		//Ѱ���������
		for(int i=0; i<times.length; i++) {
			//���ڱ�����˳���ʮ�������ķ������෴��
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
