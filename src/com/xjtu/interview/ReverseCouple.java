package com.xjtu.interview;

public class ReverseCouple {
	
	/**
	 * Ѱ�Ҹ��������е�����Ķ���
	 * �����ƽⷨ
	 * @param array
	 * @return int
	 */
	private static int reverseCouples(int []array) {
		int count=0;
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * ��ϰһ�¿����㷨
	 * һ��ĸõݹ��㷨��������ִ�й��̣����������ģ�����ʹ�þ�������֮�������
	 * ������Ϊ�ݹ��ԭ��Ļ�����ܶ����õĽ��
	 * @param array
	 */
	private static void quickSort(int []array, int l, int r) {
		
		//�ݹ���ֹ����
		if(l>=r) {
			return ;
		}
		int left=l;
		int right=r;
		while(left<right) {
			int t=array[left];
			//�ƶ���ָ��
			while(right>0 && t<array[right]) {
				right--;
			}
			//����Ԫ��
			array[left]=array[right];
			array[right]=t;
			//�ƶ���ָ��
			while(left<array.length && array[left]<t) {
				left++;
			}
			//����Ԫ��
			array[right]=array[left];
			array[left]=t;
		}
		quickSort(array, l, left);
		quickSort(array, left+1, r);
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+"\t");
		}
	}
	
	
	private static int count=0;
	
	/**
	 * һ�ζ�·�鲢�����㷨
	 * @param array
	 * @param l p
	 * @param m q
	 * @param r
	 */
	private static void merge(int []array, int l, int m, int r) {
		int i,j,k,n1,n2;
		n1=m-l+1;
		n2=r-m;
		int []L=new int[n1];
		int []R=new int[n2];
		//��������ϣ��ֱ��������������������
		for(i=0, k=l; i<n1; i++, k++) {
			L[i]=array[k];
		}
		for(i=0, k=m+1; i<n2; i++, k++) {
			R[i]=array[k];
		}
		
		for(k=l, i=0, j=0; i<n1 && j<n2; k++) {
			if(L[i]<R[j]) {
				array[k]=L[i];
				i++;
			}else {
				count+=m-i+1;
				array[k]=R[j];
				j++;
			}
		}
		//��ʣ���Ԫ�����εķ�����ԭ������ȥ
		if(i<n1) {
			for(j=i; j<n1; j++, k++) {
				array[k]=L[j];
			}
		}
		if(j<n2) {
			for(i=j; i<n2; i++, k++) {
				array[k]=R[i];
			}
		}
	}
	
	/**
	 * �鲢�����㷨ʵ����
	 * ���ĵݹ��㷨��ʵ����ʵ���˷ָ��Ч�����ȶ�С��Ԫ�ضν����˹鲢��֮�󲻶ϵĶ�
	 * �ϴ��Ԫ�ضν��й鲢�����ʵ�������������
	 * @param array
	 * @param l
	 * @param r
	 */
	private static void mergeSort(int []array, int l, int r) {
		if(l<r) {
			int m=(l+r)/2;
			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			merge(array, l, m, r);
		}
	}
	
	public static void main(String []args) {
		int []array= {1,5,3,2,6};
//		int res=ReverseCouple.reverseCouples(array);
//		System.out.println(res);
//		quickSort(array, 0, array.length-1);
		mergeSort(array, 0, array.length-1);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+"\t");
		}
		System.out.println();
		System.out.println(count);
		
	}
}
