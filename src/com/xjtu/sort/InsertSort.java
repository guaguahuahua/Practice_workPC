package com.xjtu.sort;

public class InsertSort {

	/**
	 * ���������㷨
	 * @param num ��������
	 */
	public static void insertSort(int []num) {
		System.out.println("����֮ǰ��");
		Show.show(num);
		//���в�������Ĺ���
		for(int i=1;i<num.length; i++) {
			//��¼��ǰԪ��
			int tmp=num[i];
			while(i>0 && tmp<num[i-1]) {
				num[i]=num[i-1];
				i--;
			}
			//����������ƶ�λ�õĲ���
			num[i]=tmp;
		}
		
		System.out.println("����֮��");
		Show.show(num);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num= {38, 65, 97, 76, 13, 27, 49};
		insertSort(num);
	}

}
