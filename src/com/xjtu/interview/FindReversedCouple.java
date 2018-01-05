package com.xjtu.interview;

public class FindReversedCouple {
	
	private static void findReversedCouple(int []array, int begin, int end) {
		//�ݹ����
		if(begin>=end) {
			return ;
		}else {
			//�ݹ���
			int mid=begin+(end-begin)/2;
			findReversedCouple(array, begin, mid);
			findReversedCouple(array, mid+1, end);
			mergeSort(array, begin, mid, end);
		}
	}
	
	/**
	 * �ñ���ͳ��������
	 */
	private static int count=0;
	/**
	 * ʹ�ö�·�鲢�����㷨��ͳ��������
	 * @param array ͳ������
	 * @param l ��ָ��
	 * @param m �м�ָ��
	 * @param r ��ָ��
	 */
	private static void mergeSort(int []array, int l, int m, int r) {
		int i,j,k; //�ֱ�Ϊ�����飬�����飬ԭ�������������
		int l1=m-l+1; //������ĳ���, �������а������м�Ԫ��
		int l2=r-m; //������ĳ���
		int []L=new int[l1]; //����������
		int []R=new int[l2]; //����������
		//�����������
		for(i=0; i<l1; i++) {
			L[i]=array[i];
		}
		for(j=0; j<l2; j++) {
			R[j]=array[i+j];
		}	
		//���й鲢����
		for(i=0, j=0, k=0; i<l1 && j<l2; k++) {
			//��С�����˳����������
			if(L[i]<R[j]) {
				array[k]=L[i];
				i++;
			}else {
				count+= m-i+1;
				array[k]=R[j];
				j++;
			}
		}
		//��ʣ���Ԫ������ԭ����
		while(i<l1) {
			array[k++]=L[i++];
		}
		while(j<l2) {
			array[k++]=R[j++];
		}
	}
	
	public static void main(String []args) {
		int []array= {1,5,3,2,6};
		findReversedCouple(array, 0, array.length-1);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+"\t");
		}
		System.out.println(count);
		
	}
}
