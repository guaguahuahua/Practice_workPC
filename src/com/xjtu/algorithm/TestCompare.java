package com.xjtu.algorithm;

public class TestCompare {
	
	/**
	 * ���������ʵ�֣������ݵڶ�������ʵ��������߽����Ч��
	 * @param a ����������
	 * @param cmp �ص�����
	 */
	public static void insertSort(int []a, IntCompare cmp) {
		for(int i=1; i<a.length; i++) {
			for(int start=0; start<i; start++) {
				//������������Ե�һ��һС����ô����λ��
				if(1==cmp.compare(a[i], a[start])) {
					int tmp=a[i];
					//����ƶ����������뵱ǰλ��
					for(int j=i; j>start; j--) {
						a[j]=a[j-1];
					}
					a[start]=tmp;
				}
			}
		}
		
		//show
		for(int K:a) {
			System.out.print(K+"\t");			
		}
		System.out.println();
	} 
	
	/**
	 * ��������ʱ�临�Ӷ�ΪO(n*n)
	 * @param a
	 * @param cmp
	 */
	public static void insertSort_1(int []a, IntCompare cmp) {
		
		for(int i=1; i<a.length; i++) {
			int j=i-1;
			int temp=a[i];
			while(j>-1 && 1==cmp.compare(temp, a[j])) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
		
		//
		for(int K:a) {
			System.out.print(K+"\t");
		}
		System.out.println();
	}

	/**
	 * ��Ҫ��Ϊ�˲��Իص�������
	 * @param args
	 */
	public static void main(String []args) {
		int []a= {2, 7, 6, 3, 4, 5, 2};
		
		insertSort_1(a, new Cmp2());
	}
}
