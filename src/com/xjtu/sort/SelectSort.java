package com.xjtu.sort;

public class SelectSort {

	/**
	 * ʹ��ѡ������ʵ������Ĺ���
	 * @param num
	 */
	public static void selectSort(int[] num) {
		System.out.println("����֮ǰ��");
		show(num);

		int index=0;
		//�������
		for(int j=0; j<num.length; j++) {
			int min=Integer.MAX_VALUE;
			for(int i=j; i<num.length; i++) {
				//�Ƚϣ�Ѱ�ҵ�ǰ���������ֵ
				if(min>num[i]) {
					min=num[i];
					index=i;
				}
			}
			//������Сֵ�������д�ŵ��λ��
			num[index]=num[j];
			num[j]=min;
		}
		
		System.out.println("����֮��");
		show(num);
	}
	/**
	 * չʾ����������������Ľ��
	 * @param num 
	 */
	public static void show(int []num) {
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num= {38, 65, 97, 76, 13, 27, 49};
		selectSort(num);
	}

}
