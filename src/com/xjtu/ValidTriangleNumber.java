package com.xjtu;

import java.util.Arrays;

public class ValidTriangleNumber {

	/**
	 * �������������ʹ�������ص��㷨�� ö�٣�������һ�������һ��,
	 * ������ٷ�������TLE
	 * @param nums
	 * @return
	 */
    public static int triangleNumber_1(int[] nums) {
        int count=0;
        for(int index=0;index<=nums.length-1-2;index++) {
        	for(int i=index+1;i<=nums.length-1-1;i++) {
        		for(int j=i+1;j<=nums.length-1;j++) {
        			if(nums[index]+nums[i]>nums[j] && 
            				nums[index]+nums[j]>nums[i] && 
            						nums[j]+nums[i]>nums[index]) { //���������ε����߹�����ôcount���������������һ��
            			count++;
//            			System.out.println(nums[index]+"\t"+nums[i]+"\t"+nums[i+1]);
            		}
        		}
        		
        	}
        }
    	return count;
    }
    
    /**
     * ʹ�ö��ַ����Һ��ʵĵ�����
     * @param nums  �Ѿ��ź��������
     * @param start ������Χ�Ŀ�ʼ����
     * @param end ��������
     * @param sum ǰ�������ĺ�
     * @return ���ص�һ����������������
     */ 
    public static int binarySearch(int []nums, int start, int end, int sum) {
    	
    	int mid;
    	while(start<=end && end<nums.length) {
//    		mid=start+(end-start)/2;
    		mid=(end+start)/2;
    		//����ҵ���λ�õ�ֵ<ǰ����֮��
    		if(nums[mid]>=sum) {
    			end=mid-1;
    		}else{
    			start=mid+1;
    		}
    	}
    	return start;
    }
    /**
     * ʹ������+���ֲ��ҵķ�ʽ����ʱ�临�Ӷ�Ϊn^2(Log2n)
     * @param nums
     * @return
     */
    public static int triangleNumber_2(int[] nums) {
    	//���ȶ������������,����֮���ж������������һ�����ƾ��ǣ���� a<=b<=c ��ôֻ��Ҫ�ж�
    	// a+b>c�Ƿ����㼴�ɣ���Ϊһ��������ôc+a>b, c+b>a���ǳ����ģ����ж���������Ϊ1��
    	Arrays.sort(nums);
    	//˫��forѭ�����Һ��ʵıߣ������nums[i]+nums[j]>nums[k], ��ôj+1����k֮���Ԫ�ض��Ǻ�������Ǳ�
    	int count=0; //ͳ�����е��������ĸ���
    	for(int i=0; i<nums.length-2; i++) {
    		for(int j=i+1; j<nums.length-1 && nums[i]!=0; j++) {
    			int k=binarySearch(nums, i+2, nums.length-1, nums[i]+nums[j]);
    			System.out.println(k);
    			count+=k-j-1;
    		}
    	}
    	return count;
    }
    
    /**
     * ʹ������ɨ�跨ʵ��
     * @param nums
     * @return
     */
    public static int triangleNumber(int []nums) {
    	
    	int count=0;
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length-2; i++) {
    		int k=i+2;
    		for(int j=i+1; j<nums.length-1 && nums[i]!=0; j++) {
    			while(k<nums.length && nums[i]+nums[j]>nums[k]) {
    				k++;
    			}
    			count+=k-j-1;
    		}
    	}
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {2,2,3,4,9,562,5,3,78,56,16,456,46};
		int []nums= {2,2,3,4};
//		int []nums= {1,2,3,4,5,6};
//		int []nums= {2,5,6,7,9};
//		int []nums= {0,1,0,1};
		int res=triangleNumber(nums);
		System.out.println("triangle number :"+res);
	}

}
