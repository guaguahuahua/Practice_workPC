package com.xjtu.algorithm;

import java.lang.reflect.Array;

public class AdjustMinHeap {

	/**
	 * �ѵĴ���
	 * @param a
	 * @param pos	�����ĵ�һ�����ڵ�����
	 * @param len	�����е����һ��Ԫ�ص���������������ĳ��ȣ����Ԫ�ؾ����ڱȽϵ�ʱ������<=������<
	 */
	public static void adjustMinHeap(int []a, int pos, int len) {
		
		
		for( ;2*pos<len; ) {
			//���㺢�ӽڵ������
			int child=2*pos+1;
			//������Һ��Ӳ��ұ�����С,��ôȥ�����е���Сֵ
			if(child+1<=len && a[child]>a[child+1]) {
				child++;
			}
			//������ӽڵ�С�ڸ��ڵ㣬��ô�������������Ҳ���Է�������λ��ȷ��֮��
			if(a[child]<a[pos]) {
				int temp=a[pos];
				a[pos]=a[child];
				a[child]=temp;
			}else {
				break;
			}
			pos=child;
		}
	}
	
	public static void show(int []nums) {
		for(int K:nums) {
			System.out.print(K+"\t");
		}
		System.out.println();
	} 
	
	/**
	 * ����������
	 * @param nums
	 */
	public static void heapSort(int []nums) {	
		//�ѵĳ�ʼ����
		for(int i=(nums.length)/2-1; i>=0; i--) {
			adjustMinHeap(nums, i, nums.length-1);
		}
		System.out.println("��С�ѽ���Ч����");
		show(nums);
		//����λ��
		for(int j=nums.length-1; j>=0; j--) {
			
			int temp=nums[0];
			nums[0]=nums[j];
			nums[j]=temp;			
			adjustMinHeap(nums, 0, j-1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {5,4,9,8,7,6,0,1,3,2};
		show(nums);
//		int i;
//		int len=nums.length;
//		for(i=len/2-1; i>=0; i--) {
//			adjustMinHeap(nums, i, len-1);
//		}
		heapSort(nums);
		System.out.println("������֮��Ľ����");
		show(nums);
	}

}
