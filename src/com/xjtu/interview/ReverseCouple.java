package com.xjtu.interview;

public class ReverseCouple {
	
	/**
	 * 寻找给定数组中的逆序的对数
	 * 暴力破解法
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
	 * 练习一下快排算法
	 * 一般的该递归算法还是用作执行过程，如果是输出的，还是使用经过排序之后的数组
	 * 否则因为递归的原因的会输出很多无用的结果
	 * @param array
	 */
	private static void quickSort(int []array, int l, int r) {
		
		//递归终止条件
		if(l>=r) {
			return ;
		}
		int left=l;
		int right=r;
		while(left<right) {
			int t=array[left];
			//移动右指针
			while(right>0 && t<array[right]) {
				right--;
			}
			//交换元素
			array[left]=array[right];
			array[right]=t;
			//移动左指针
			while(left<array.length && array[left]<t) {
				left++;
			}
			//交换元素
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
	 * 一次二路归并排序算法
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
		//将数组隔断，分别放置在左右两个数组中
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
		//将剩余的元素依次的放置在原数组中去
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
	 * 归并排序算法实现体
	 * 这块的递归算法，实际上实现了分割的效果，先对小的元素段进行了归并，之后不断的对
	 * 较大的元素段进行归并，最后实现了整体的有序
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
