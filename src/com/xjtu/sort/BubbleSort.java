package com.xjtu.sort;

public class BubbleSort {

	/**
	 * ʹ��ð�������㷨
	 * @param num
	 */
	public static void bubbleSort(int []num) {
		System.out.println("����֮ǰ");
		Show.show(num);
		//ð������
		for(int j=0; j<num.length; j++) {
			
			for(int i=1; i<num.length-j; i++) {
				//��ǰλ�õ�ֵ�ϴ��ʱ�򽻻�
				if(num[i]<num[i-1]) {
					int tmp=num[i];
					num[i]=num[i-1];
					num[i-1]=tmp;
				}
			}
		}

		System.out.println("����֮��");
		Show.show(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num= {38, 65, 97, 76, 13, 27, 49};
//		int []num= {};
		bubbleSort(num);
		System.out.println(new BubbleSort().getClass().getName());
	}

}
