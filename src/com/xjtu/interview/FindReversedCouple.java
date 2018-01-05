package com.xjtu.interview;

public class FindReversedCouple {
	
	private static void findReversedCouple(int []array, int begin, int end) {
		//递归出口
		if(begin>=end) {
			return ;
		}else {
			//递归体
			int mid=begin+(end-begin)/2;
			findReversedCouple(array, begin, mid);
			findReversedCouple(array, mid+1, end);
			mergeSort(array, begin, mid, end);
		}
	}
	
	/**
	 * 该变量统计逆序数
	 */
	private static int count=0;
	/**
	 * 使用二路归并排序算法，统计逆序数
	 * @param array 统计数组
	 * @param l 左指针
	 * @param m 中间指针
	 * @param r 右指针
	 */
	private static void mergeSort(int []array, int l, int m, int r) {
		int i,j,k; //分别为左数组，右数组，原数组的索引变量
		int l1=m-l+1; //左数组的长度, 左数组中包含了中间元素
		int l2=r-m; //右数组的长度
		int []L=new int[l1]; //创建左数组
		int []R=new int[l2]; //创建右数组
		//填充左右数组
		for(i=0; i<l1; i++) {
			L[i]=array[i];
		}
		for(j=0; j<l2; j++) {
			R[j]=array[i+j];
		}	
		//进行归并排序
		for(i=0, j=0, k=0; i<l1 && j<l2; k++) {
			//从小到大的顺序排列数组
			if(L[i]<R[j]) {
				array[k]=L[i];
				i++;
			}else {
				count+= m-i+1;
				array[k]=R[j];
				j++;
			}
		}
		//将剩余的元素填充回原数组
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
