package com.xjtu.algorithm;

public class TestCompare {
	
	/**
	 * 插入排序的实现，并根据第二个参数实现升序或者降序的效果
	 * @param a 待排序数组
	 * @param cmp 回调函数
	 */
	public static void insertSort(int []a, IntCompare cmp) {
		for(int i=1; i<a.length; i++) {
			for(int start=0; start<i; start++) {
				//如果两个数明显的一大一小，那么交换位置
				if(1==cmp.compare(a[i], a[start])) {
					int tmp=a[i];
					//向后移动将该数插入当前位置
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
	 * 插入排序，时间复杂度为O(n*n)
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
	 * 主要是为了测试回调函数的
	 * @param args
	 */
	public static void main(String []args) {
		int []a= {2, 7, 6, 3, 4, 5, 2};
		
		insertSort_1(a, new Cmp2());
	}
}
