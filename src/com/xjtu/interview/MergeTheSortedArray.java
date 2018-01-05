package com.xjtu.interview;

public class MergeTheSortedArray {

	/**
	 * ��������������ĺϲ�,ʹ�ò�������ķ�����ǰ�ν�������˲�������
	 * @param nums
	 * @param mid
	 * @return int[]
	 */
	private int [] mergeTheSortedArray(int []nums, int mid) {
		for(int i=0; i<mid; i++) {
			//ǰ�ν��н���
			if(nums[i]>nums[mid]) {
				int temp=nums[i];
				nums[i]=nums[mid];
				nums[mid]=temp;
			}
			//���ں�ν���֮������ݽ��в�������ʹ֮����
			int j=mid+1;
			while(j<nums.length && nums[j-1]>nums[j]) {
				int temp=nums[j-1];
				nums[j-1]=nums[j];
				nums[j]=temp;
				j++;
			}
		}
		//
		show(nums);
		
		return nums;
	}
	
	/**
	 * ʹ�ò�������ķ�ʽʵ�ֶ�������ϲ�
	 * @param nums
	 */
	private void mergerTheSortedArray_1(int []nums) {
		for(int i=1; i<nums.length; i++) {
			int j=i-1;
			int temp=nums[i];
			while(j>-1 && temp<nums[j]) {
				nums[j+1]=nums[j];
				j--;
			}
			nums[j+1]=temp;
		}
		//show
		show(nums);
	}
	
	/**
	 * ��������������е�Ԫ�����
	 * @param nums
	 */
	private void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,5,6,7,9,2,4,8,10,13,14};
		MergeTheSortedArray merge=new MergeTheSortedArray();
		int mid=5;
		merge.mergeTheSortedArray(nums, mid);
//		merge.mergerTheSortedArray_1(nums);
	}

}
