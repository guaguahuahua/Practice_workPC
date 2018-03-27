package com.xjtu.algorithm;

public class MergeSort {

	public static void mergeSort(int []nums) {
		binMergeSort(nums, 0, nums.length-1);
	}
	
	
	public static void binMergeSort(int []nums, int left, int right) {
		if(left<right) {
			int mid=left+(right-left)/2;
			binMergeSort(nums, left, mid);
			binMergeSort(nums, mid+1, right);
			merge(nums, left, right, mid);
		}
	}
	
	
	/**
	 * һ�ζ�·�鲢
	 * @param nums
	 * @param left
	 * @param right
	 * @param mid
	 */
	public static void merge(int []nums, int left, int right, int mid) {
		int len1=mid-left+1;
		int len2=right-mid;
		//�´�������������������������
		int []part1=new int[len1];
		int []part2=new int[len2];
		//��������Ԫ�ط��뵽��������Ԫ����
		for(int i=0, j=left; i<len1; i++, j++) {
			part1[i]=nums[j];
		}
		
		for(int i=0, j=mid+1; i<len2; i++, j++) {
			part2[i]=nums[j];
		}
		
		int i, j, k;
		//���������������е�Ԫ�ذ��մ�С˳����뵽ԭ������
		for(i=0, j=0, k=left; i<len1 && j<len2; ) {
			//������������������Ԫ��
			if(part1[i]<=part2[j]) {
				nums[k]=part1[i];
				i++;
			}else {
				nums[k]=part2[j];
				j++;
			}
			k++;
		}
		
		//��ʣ���Ԫ�����뵽ԭ������ȥ
		while(i<len1) {
			nums[k++]=part1[i++];
		}
		while(j<len2) {
			nums[k++]=part2[j++];
		}
		
	}
	
	public static void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {5,4,9,8,7,6,0,1,3,2};
		show(nums);
		mergeSort(nums);
		show(nums);
	}

}
