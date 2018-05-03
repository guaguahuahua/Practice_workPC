package com.xjtu.algorithm;
/**
 * ����������е��������
 * @author Administrator
 *
 */
public class InversedPairs {
	
	/**
	 * ���������ӵ�һ�������һ������
	 * @param nums
	 * @return
	 */
	public static int inversedPairs(int []nums) {
		
		int count=0;
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]>nums[j]) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * ʹ�ù鲢�����˼��
	 * @param nums
	 * @return
	 */
	public static int inversedPairs_1(int []nums) {
		
		return -1;
	}
	private static int count=0;
	
	/**
	 * һ�ι鲢����
	 * @param nums
	 * @param l
	 * @param r
	 * @param m
	 */
	public static void merge(int []nums, int l, int r, int m) {
		int len1=m-l+1;
		int len2=r-m;
		int []left=new int[len1];
		int []right=new int[len2];
		int i, j, k;
		//��Ԫ����ȡ�����ֱ������������������
		for(i=0, j=l; i<len1; i++, j++) {
			left[i]=nums[j];
		}
		for(i=0, j=m+1; i<len2; i++, j++) {
			right[i]=nums[j];
		}
		//�ϲ�
		for(i=0, j=0, k=l; i<len1 && j<len2; k++) {
			if(left[i]<right[j]) {
				nums[k]=left[i];
				i++;
			}else {
				nums[k]=right[j];
				j++;				
				//��������������
//				count=j-m+1+count; 
				count=count+m-i-l+1;
			}
		}
		//��ʣ���Ԫ��д��
		while(i<len1) {
			nums[k++]=left[i++];
		}
		while(j<len2) {
			nums[k++]=right[j++];
		}
	}
	
	/**
	 * �鲢���򣬵ݹ���
	 * @param nums
	 */
	public static void mergeSort(int []nums, int l, int r) {
//		int m;
		if(l<r) {
			int m=l+(r-l)/2;
			mergeSort(nums, l, m);
			mergeSort(nums, m+1, r);
			merge(nums, l, r, m);
		}
	}
	
	/**
	 * ������������е�Ԫ��
	 * @param nums
	 */
	public static void show(int []nums) {
		
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	

	/**
	 * ʹ��ð������ķ�ʽʵ������Ե�ͳ��
	 * @return
	 */
	public static int inversedPairs_2(int []nums) {
		
		int count=0;
		for(int i=0; i<nums.length; i++) {
			boolean isSwap=false;
			for(int j=1; j<nums.length-i; j++) {
				//�����������ԣ���ô��������ͳ�ƴ���
				if(nums[j-1]>nums[j]) {
					int t=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=t;
					count++;
					isSwap=true;
				}
			}
			if(isSwap==false) {
				break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {7,5,6,4};
//		int []nums= {1,5,3,2,6};
//		show(nums);
//		mergeSort(nums, 0, nums.length-1);
//		show(nums);
//		System.out.println(count);
		int res=inversedPairs_2(nums);
		System.out.println(res);
	}

}
