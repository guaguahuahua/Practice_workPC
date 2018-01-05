package com.xjtu;

import java.util.Arrays;

public class ArrayNesting {
	/**
	 * ������ֽ�����Ϸ�����������Ľ�������
	 * ���㷨˼�������ͳ�ģ�����TLE����Ҫ����д�㷨,��δ���û��̫������⣬��Ҫ����������һ����Ҫ����Ϣ��
	 * ��������γɻ�����ô���γɻ�����Щ�����Ǳպϵģ������ٴγ�����չ������жϵĹ����ж���Щ�Ѿ��γɻ������ֽ��б��
	 * ��ô���Խ�ʡ������ʱ��
	 * @param nums
	 * @return
	 */
/*    public static int arrayNesting(int[] nums) {
        int []length=new int[nums.length]; // �������ÿһ�������ĳ���
        if(nums.length==0) {
        	return 0;
        }
        for(int i=0;i<nums.length;i++) {
        	int j=i,times=1;
        	while(nums[j]!=i) {
        		j=nums[j];
        		times++;
        	}
        	length[i]=times;
        }
        Arrays.sort(length);
    	return length[length.length-1];
    }*/
	
	/**
	 * �㷨�Ľ�����Ϊ�����õ��������㷨����������Ҫ�Ķ��������󳤶�
	 * @param nums
	 * @return
	 */
	public static int arrayNesting(int [] nums) {
		int max=0;
		int index=0;
        for(int i=0;i<nums.length;i++) {
        	int j=i,times=0;
        	while(nums[j]>=0) {
        		index=j;
        		j=nums[j];
        		nums[index]=-1;
        		times++;
        	}
        	max=times>max ? times : max;
        }
		return max;
	}
	public static void main(String []args) {
//		int []nums= {5,4,0,3,1,6,2};
		int []nums= {0,1,2};
//		int []nums= {2,2,2,2,2,2}; //�ò���������������Ϊ����Ԫ��������0--n-1
		
		int res=arrayNesting(nums);
		System.out.print(res+"\t");		
	}
}
