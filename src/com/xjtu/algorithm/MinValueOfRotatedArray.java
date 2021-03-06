package com.xjtu.algorithm;

public class MinValueOfRotatedArray {
	
	/**
	 * 旋转数组中的最小元素
	 * @param array
	 * @return
	 */
	public static int minValueOfRotatedArray(int []array) {
		
		for(int i=1; i<array.length; i++) {
			if(array[i]<array[i-1]) {
				return array[i];
			}
		}
		return -1;
	}
	
	/**
	 * 使用二分查找法实现旋转数组的最小值
	 * 因为数组中存在两个有序的子数组，然后可以分别对两个子数组进行查找
	 * 如果中间元素等于左边元素，那说明在第一个有序组里面，左指针需要向右移动
	 * 如果中间元素小于等于右边元素，那么说明在第二个有序组里面，右指针需要向左移动
	 * @param array
	 * @return
	 */
	public static int minValueOfRotatedArray_1(int []array) {
		
		int left=0, right=array.length-1;
		while(right-left!=1) {
			int mid=left+(right-left)/2;
			//这里不使用left=mid+1或者right=mid-1主要是查找对象是不确定的
			//不能比较之后就把该元素丢弃，而一般的二分查找的过程中查找元素是明确的，不是模糊的
			//而在这里我们查找的元素可能就是当前的mid元素
			if(array[mid]>=array[left]) {
				left=mid;
			}else if(array[mid]<=array[right]){
				right=mid;
			}
		}
		return array[right];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []array= {3,4,5,1,2};
//		int []array= {1,1,1,0,1};
//		int []array= {1,1,0,1,1};
		int []array= {1,1,1,1,0,1,1};
		int res=minValueOfRotatedArray_1(array);
		System.out.println("minValue:"+res);
	}

}
