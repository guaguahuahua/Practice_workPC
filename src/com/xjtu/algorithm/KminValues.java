package com.xjtu.algorithm;



public class KminValues {

	/**
	 * ��������ǰkС��Ԫ��
	 * ʹ��ѡ������
	 * @param nums
	 */
	public static void kMinValues(int []nums, int k) {
		//�����Ҫ��Ϊ�˷�ֹk�ĳ��ȳ���������ĳ���
		k=k%nums.length;
		//�ܹ�ѡ������Ĵ���
		for(int times=0; times<k; times++) {
			int min=Integer.MAX_VALUE;
			int index=-1;
			//ѡ������
			for(int i=nums.length-1; i>=times; i--) {
				if(nums[i]<min) {
					min=nums[i];
					index=i;
				}
			}
			//������Сֵ��λ��
			int temp=nums[index];
			nums[index]=nums[times];
			nums[times]=temp;
		}
		//���ǰkС��Ԫ��
		for(int i=0; i<k; i++) {
			System.out.print(nums[i]+"\t");
		}
		
	}
	
	public static void show(int []nums) {
		for(int K:nums) {
			System.out.print(K+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ����˳������
	 * @param nums	int[]	
	 */
	public static void selectSort(int []nums) {
		
		//ѡ������Ԫ�أ�ʵ��һ������Ĺ���
		for(int times=0; times<nums.length-1; times++) {
			
			int max=Integer.MIN_VALUE;
			int index=-1;
			for(int i=0; i<nums.length-times; i++) {
				if(max<nums[i]) {
					max=nums[i];
					index=i;
				}
			}
			int temp=nums[index];
			nums[index]=nums[nums.length-times-1];
			nums[nums.length-times-1]=temp;
		}
		show(nums);
	}
	
	/**
	 * ��������
	 * @param nums	int[]	
	 */
	public static void selectSort_1(int []nums) {
		
		for(int times=0; times<nums.length-1; times++) {
			
			int min=Integer.MAX_VALUE;
			int index=-1;
			//һ������
			for(int i=0; i<nums.length-times; i++) {
				if(nums[i]<min) {
					min=nums[i];
					index=i;
				}
			}
			//����λ��
			int temp=nums[nums.length-1-times];
			nums[nums.length-1-times]=nums[index];
			nums[index]=temp;
		}
		show(nums);	
		
	}
	
	/**
	 * ʹ�ò�������
	 * @param nums
	 */
	public static void insertSort(int []nums) {
		
		for(int i=1; i<nums.length; i++) {
			int temp=nums[i];
			int index=i;
			boolean flag=false;
			if(nums[index-1]>temp) {
				while(index>0 && nums[index-1]>temp) {
					nums[index]=nums[index-1];
					index--;
				}
			}		
			nums[index]=temp;
		}
		show(nums);
	}
	
	/**
	 * �������β�����в�������
	 * @param nums	int[]	��������
	 */
	public static void insertSort_1(int []nums) {
		for(int i=nums.length-2; i>=0; i--) {
			int temp=nums[i];
			int index=i;
			if(temp>nums[index+1]) {
				
				while(index<nums.length-1 && temp>nums[index+1]) {
					nums[index]=nums[index+1];
					index++;
				}
			}
			nums[index]=temp;
		}
		show(nums);
	}
	
	/**
	 * ð������
	 * @param nums
	 */
	public static void bubbleSort(int []nums) {
		
		for(int times=0; times<nums.length-1; times++) {
			//�ñ�����Ҫ��Ϊ�˷�ֹ��ʼ����
			boolean flag=false;
			//һ������
			for(int i=0; i<nums.length-1-times; i++) {
				if(nums[i]>nums[i+1]) {
					swap(nums, i, i+1);
					flag=true;
				}
			}
			if(!flag) {
				break;
			}
		}
		show(nums);
	}
	
	/**
	 * ð������ĸ�������
	 * @param nums
	 * @param i
	 * @param j
	 */
	public static void swap(int []nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

	/**
	 * ���·�鲢ת��
	 * @param nums
	 * @param l
	 * @param r
	 */
	public static void merge(int []nums, int l, int r) {
		if(l<r) {
			int mid=l+(r-l)/2;
			merge(nums, l, mid);
			merge(nums, mid+1, r);
			binMerge(nums, l, r, mid);
		}
	}	
	
	/**
	 * ��·�鲢�������
	 * @param nums	int[]
	 */
	public static void mergeSort(int []nums) {
		int l=0;
		int r=nums.length;
		merge(nums, l, r-1);
	}
	
	/**
	 * һ�ζ�·�鲢������
	 * @param nums
	 * @param left
	 * @param right
	 * @param mid
	 */
	public static void binMerge(int []nums, int left, int right, int mid) {
		int len1=mid-left+1;
		int len2=right-mid;
		int []part1=new int[len1];
		int []part2=new int[len2];
		//���󲿷����
		for(int i=left, j=0; j<len1; i++, j++) {
			part1[j]=nums[i];
		}
		//���Ҳ������
		for(int i=mid+1, j=0; j<len2; i++, j++) {
			part2[j]=nums[i];
		}
		
		//������ԭ������д������nums
		int i=0, j=0, k=left;
		while(i<len1 && j<len2) {
			if(part1[i]<=part2[j]) {
				nums[k]=part1[i];
				i++;
			}else {
				nums[k]=part2[j];
				j++;
			}
			k++;
		}
		//��������������ʣ���Ԫ�ط��õ�ԭ������
		while(i<len1) {
			nums[k]=part1[i];
			i++;
			k++;
		}
		
		while(j<len2) {
			nums[k]=part2[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {1,2,3,5,8,9,10};
//		int []nums= {5,1,7,9,2,3};
//		kMinValues(nums, 4);
		int []nums= {38, 65, 97, 13, 27, 49};
		show(nums);
		mergeSort(nums);		
		show(nums);
	}

}
