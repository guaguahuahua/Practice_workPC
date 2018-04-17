package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 调整数组中奇数和偶数位置，使得奇数在数组的前半部分，偶数在后半部分
 * 并且奇数和偶数的相对位置不会发生变化
 * @author Administrator
 *
 */
public class AdjustArray {

	/**
	 * 直接使用两个集合分别存放奇数和偶数，之后再依次的将集合中元素放回到数组中
	 * @param nums
	 */
	public static void adjustArray(int []nums) {
		List<Integer> odd=new ArrayList<Integer>();
		List<Integer> even=new ArrayList<Integer>();
		//分拣过程
		for(int i=0; i<nums.length; i++) {
			//如果是偶数
			if((nums[i]>>1<<1)==nums[i]) {
				even.add(nums[i]);
			}else {
				odd.add(nums[i]);
			}
		}
		//将集合中的元素回填
		int index=0;
		for(int i=0; i<odd.size(); i++) {
			nums[index]=odd.get(i);
			index++;
		}
		for(int i=0; i<even.size(); i++) {
			nums[index]=even.get(i);
			index++;
		}
	}
	
	/**
	 * 使用两个数组的方式来解决
	 * @param nums
	 */
	public static void adjustArray_1(int []nums) {
		int len=nums.length;
		//分别存放奇数和偶数元素 的数组
		int []odd=new int[len];
		int []even=new int[len];
		int oLen=0;
		int eLen=0;

		//遍历数组进行分拣
		for(int i=0; i<nums.length; i++) {
			//偶数
			if(( (nums[i]>>1) <<1)==nums[i]) {
				even[eLen]=nums[i];
				eLen++;
			}else {
				odd[oLen]=nums[i];
				oLen++;
			}
		}
		//数据回填
		int index=0;
		for(int i=0; i<oLen; i++) {
			nums[index]=odd[i];
			index++;
		}
		
		for(int i=0; i<eLen; i++) {
			nums[index]=even[i];
			index++;
		}
		
	}
	
	/**
	 * 使用一个偶数数组来实现，用奇数覆盖前面的偶数
	 * @param nums
	 */
	public static void adjustArray_2(int []nums) {
		int []even=new int[nums.length];
		int eLen=0;
		int left, right;
		for(left=0, right=0 ; right<nums.length; ) {
			//如果当前元素是个偶数
			if((nums[left]>>1)<<1==nums[left]) {
				
				right=left;
				while(right<nums.length) {
					//如果右边的是个奇数，那么覆盖前面的偶数
					if(nums[right]>>1<<1!=nums[right]) {
						//覆盖之前先将偶数复制到临时数组中
						even[eLen]=nums[left];
						eLen++;
						nums[left]=nums[right];
						left++;

					}
					right++;
				}
				break;
			//当前元素是奇数	
			}else {
				left++;
			}
		}
		//最终将偶数回填到数组中去
		for(int i=left+1, j=0; i<nums.length; i++,j++) {
			nums[i]=even[j];
		}
	}
	
	/**
	 * 通过交换法调整数组中的元素，通过不断的遍历，但是每次只调整数组中偶数在奇数前面的元素
	 * @param nums
	 */
	public static void adjustArray_3(int []nums) {
		
		
		//一次交换数组中的元素
		while(true){
			boolean swap=false;
			for(int i=0; i<nums.length-1; i++) {
				//如果偶数在前，奇数在后，那么交换
				if(nums[i]>>1<<1==nums[i] && nums[i+1]>>1<<1!=nums[i+1]) {
					int temp=nums[i];
					nums[i]=nums[i+1];
					nums[i+1]=temp;
					swap=true;
				}
			}	
			//也就是说哪一次的初始遍历没有改变boolean的变量值，那么就是所有交换的元素已经 交换完毕
			if(swap==false) {
				break;
			}
		}
				
	}
	
	
	
	/**
	 * 输出数组中元素
	 * @param nums
	 */
	public static void show(int []nums) {
		for(int K: nums) {
			System.out.print(K+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3,4,5};
		show(nums);
		adjustArray_3(nums);
		show(nums);
	}

}
