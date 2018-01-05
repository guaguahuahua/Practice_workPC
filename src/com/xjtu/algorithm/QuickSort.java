package com.xjtu.algorithm;

import com.xjtu.sort.Show;

public class QuickSort {

	public static void quickSort(int []num, int left, int right) {
		System.out.println("����֮ǰ��");
		Show.show(num);
		//�ݹ���ֹ����
		if(right<=left) {
			return ;
		}
		
		//һ������
		int i=left,j=right;
		int temp;
		for(; i<j; ) {
			
			//�����ƶ���ָ�룬ֱ���Ҳ��Ԫ�ش�������Ԫ��
			while(i<j && num[i]<num[j]) {
				j--;
			}
			temp=num[i];
			num[i]=num[j];
			num[j]=temp;
			
			//��������ָ�룬ֱ������Ԫ�ش����Ҳ�Ԫ��
			while(i<j && num[j]>num[i]) {
				i++;
			}
			temp=num[j];
			num[j]=num[i];
			num[i]=temp;
		}
//		System.out.println("i:"+i+", "+"j:"+j);
		//�ҵ��м�λ��֮���������п���
		quickSort(num, left, i-1);
		quickSort(num, i+1, right);
		
		
		System.out.println("����֮��");
		Show.show(num);
	}
	
	public static void main(String []args) {
//		int []num= {38, 65, 97, 76, 13, 27, 49};
		int []num= {45, 35};
		quickSort(num, 0, num.length-1);
	}
	
}
