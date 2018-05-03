package com.xjtu.algorithm;

import java.util.Arrays;

/**
 * �ж�����������Ƿ�Ϊ˳�ӣ����������������У�
 * @author Administrator
 *
 */
public class JudgeShunzi {

	/**
	 * �����������������֮��ͳ��0�ĸ���������жϷ���Ԫ��֮��Ĳ�ֵ
	 * �����Ԫ�صĸ������������Щ��ֵ����ô��Ϊ��˳�ӣ�������Ϊ����
	 * �������Ԫ���г������ظ�Ԫ�أ�����Ҳ��Ϊ����˳��
	 * @param nums
	 * @return
	 */
	public static boolean judgeShunzi(int []nums) {
		
		Arrays.sort(nums);
		int zeros=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==0) {
				zeros++;
			}else if(i>=1) {
				//�������������֮����Ҫ���0�������� �����ֵΪ1�����ǲ�����������
				int delta=nums[i]-nums[i-1]-1;
				//�����������ͬ����ô�ͻ����
				if(delta==-1) {
					return false;
				}
				zeros=zeros-delta;
			}			
		}
		return zeros>=0;
	}
	
	/**
	 * ���ݼ������жϣ���Ϊ����ĿҪ���У��������5���ƣ�
	 * Ȼ���÷���Ԫ�صļ���������Ԫ�صļ������4����ô����˳�ӣ�������˳�� 
	 * @param nums
	 * @return
	 */
	public static boolean judgeShunzi_1(int []nums) {
	
		Arrays.sort(nums);
		int min=Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++) {
			//�ҵ�������Сֵ
			if(nums[i]!=0 && nums[i]<min) {
				min=nums[i];
			//�ж�Ԫ���Ƿ���ͬ
			}else if(i>=1) {
				if(nums[i]!=0 && nums[i]==nums[i-1]) {
					return false;
				}
			}			
		}
		if(nums[nums.length-1]-min>4) {
			return false;
		}		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,0,3,4,5};
//		int []nums= {4,5,6,7};
//		int []nums= {0,0,0,1};
//		int []nums= {2,2,3,2};
		boolean res=judgeShunzi_1(nums);
		System.out.println(res);
	}

}
