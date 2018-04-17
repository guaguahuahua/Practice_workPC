package com.xjtu.algorithm;

public class FindIn2DArray {
	
	/**
	 * �ڸ����Ķ�ά������Ѱ���ض������Ƿ���ڣ����ڷ���true,�����ڷ���false
	 * brute force��
	 * @param nums
	 * @return
	 */
	public static boolean find(int [][]nums, int target) {
		
		//˫��forѭ��������û��������Ŀ�����Ĵ����Ҵ��ϵ��������������
		for(int row=0; row<nums.length; row++) {
			for(int col=0; col<nums.length; col++) {
				if(nums[row][col]==target) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * ʹ�÷��η�����������������ʼ�������������½Ǻ����Ͻ�
	 * ���������ķ�ʽ����Ҫԭ���Ǽ����������ķ����������������������
	 * ��ô�������ظ��ԵĹ���
	 * ����ѡ�����Ͻǿ�ʼ����
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean find_1(int [][]array, int target) {
		
//		for(int col=nums.length-1; col>=0; ) {
//			for(int row=0; row<nums.length; ) {
//				//��ǰԪ��С��target����ô���ҵ�ǰԪ�ص��²�
//				if(nums[row][col]>target) {
//					col--;
//				}else if(nums[row][col]<target) {
//					row++;
//				}else {
//					return true;
//				}
//			}
//		}
		//�������Ϊ��
		if(array.length==1 && array[0].length==0) {
			return false;
		}
		
		int row=0, col=array.length-1;
		while(row<array.length && col>=0) {
			if(array[row][col]==target) {
				return true;
			}else if(array[row][col]>target) {
				col--;
			}else if(array[row][col]<target){
				row++;
			}
		}
		return false;
	}
	
	public static void main(String []args) {
//		int [][]nums= {
//				{1,2,8, 9 },
//				{2,4,9, 12},
//				{4,7,10,13},
//				{6,8,11,15}
//		};
//		int [][]nums= {{}};
		int [][]nums= {{1,23,5,8}}; 
		int target=8;
		boolean res=find_1(nums, target);
		System.out.println(res);
	}
}
