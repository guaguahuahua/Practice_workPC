package com.xjtu.algorithm;

import java.util.Arrays;

/**
 * �ҵ�������k����С��Ԫ��
 * @author Administrator
 *
 */
public class FindKMinValues {
	
	/**
	 * ֱ����������֮��ȡǰk��Ԫ��
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] findKMinValues(int []nums, int k) {
		Arrays.sort(nums);
		int []res=new int[k];
		for(int i=0; i<k; i++) {
			res[i]=nums[i];
		}
		return res;
	}
	
	/**
	 * ʹ��ѡ������ķ���������ֻѡ������ǰk��Ԫ��
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] findKMinValues_1(int []nums, int k) {
		
		int []res=new int [k];
		for(int i=0; i<k; i++) {
			int min=nums[i];
			int index=-1;
			for(int j=i; j<nums.length; j++) {
				if(nums[j]<min) {
					min=nums[j];
					index=j;
				}
			}
			int temp=nums[i];
			nums[i]=min;
			nums[index]=temp;
			res[i]=nums[i];
		}
		
		return res;
	}
	
	/**
	 * ʹ�ý�������ķ�����ǰk��Ԫ��
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] findKMinValues_2(int []nums, int k) {
		
		int[]res=new int[k];
		for(int i=0; i<k; i++) {
			
			//���ǽ���С��k��Ԫ�ؽ������������ĩβȥ
			for(int j=1; j<nums.length-i; j++) {
				//���ǰ���Ԫ��С�ں����Ԫ�أ���ô����
				if(nums[j-1]<nums[j]) {
					int temp=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;
				}
			}
			res[i]=nums[nums.length-i-1];
		}
		return res;
	}
	
	/**
	 * ʹ����С�ѵķ�ʽ���ǰk����С��Ԫ��
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] findKMinValues_3(int []nums, int k) {
		//���k����С��ֵ
		int []res=new int[k];
		for(int times=0, len=nums.length; times<k; times++) {
			adjustHeap(nums, len);
			res[times]=nums[0];
			nums[0]=nums[len-1];
			len--;
		}
		
		return res;
	}
	
	/**
	 * ������С��
	 * @param nums
	 * @parem pos	�Ӹ�λ�����µ���
	 */
	public static void createHeap(int []nums, int pos, int len) {
		
		int temp;
		int child;
		//temp��ŵ��Ǹ��ڵ�
		for(temp=nums[pos]; 2*pos+1<len; ) {
			child=2*pos+1;
			//�������������ڣ���������ֵС��������
			if(child+1<nums.length && nums[child]>nums[child+1]) {
				child++;
			}
			//�ж������͸��ڵ�Ĵ�С
			if(nums[child]<temp) {
				nums[pos]=nums[child];
			}else {
				break;
			}
			nums[child]=temp;
			//�������������������������ٴα���
			pos=child;
		}
		
	}
	
	/**
	 * ������
	 * @param nums
	 */
	public static void adjustHeap(int []nums, int len) {
		
		//�����һ�����ڵ㿪ʼ����
		for(int start=len/2; start>=0; start--) {
			createHeap(nums, start, len);
		}
	}
	
	/**
	 * ������е�Ԫ��
	 * @param nums
	 */
	public static void showHeap(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String []args) {
		int []nums= {4,5,1,6,2,7,3,8};
		int k=4;
		int []res=findKMinValues_3(nums, k);
		for(int K:res) {
			System.out.print(K+"\t");
		}
		
//		showHeap(nums);
//		adjustHeap(nums);
//		showHeap(nums);
	}
	
}
