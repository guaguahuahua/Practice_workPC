package com.xjtu.interview;

import java.util.Arrays;

public class JudgeContinue {

	/**
	 * 判断输入的五个数字是否是相邻的
	 * @param array 输入数组int类型，不为空
	 * @return boolean 相邻返回true，否则返回false
	 */
	private boolean judgeContinue(int []array) {
		//首先对输入数组进行排序
		Arrays.sort(array);
		//判断第一个元素，不为0
		if(array[0]!=0) {
			for(int i=1; i<array.length; i++) {
				if(array[i]!=array[i-1]+1) {
					return false;
				}
			}
			//前面没有终止的，那么就是正常的
			return true;
		//第一个元素为0	
		}else {
			//用于记录第一个非零元素的索引
			int index=-1;
			//找到一个非零元素
			for(int i=1; i<array.length; i++) {
				if(array[i]!=0) {
					index=i;
				}
			}
			//如果只有一个非零元素
			if(index==array.length-1) {
				return true;
			//如果所有元素的值都为0	
			}else if(index==-1){
				return true;
			//如果不止一个元素非零，那么判断第一个非零元素和最后一个非零元素之间的差，如果小于5，那么记录元素的差，并使用0元素填充，判断
			}else {
				int diff=0;
				for(int i=index+1; i<array.length; i++) {
					diff+=(array[i]-array[i-1]-1);
				}
				//判断0元素能否填充所有的间隙
				if(diff==index) {
					return true;
				}else {
					return false;
				}
			}
		}
	}
	
	/**
	 * 判断给定5个数是否相邻
	 * 思路：如果是没有0元素的，那么最大元素和最小元素的之间差是4；
	 * 如果是存在0元素的，最大值和最小值（非零元）的差也是4；
	 * 所以只要找到当前数中的最大和最小非零元，判断它们的差值，如果小于4那么认为是连续的
	 * @param array
	 * @return
	 */
	private boolean judgeContinue_1(int []array) {
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int diff=-1;
		for(int i=0; i<array.length; i++) {
			if(array[i]!=0) {
				if(array[i]>max) {
					max=array[i];
				}
				if(array[i]<min) {
					min=array[i];
				}
			}
		}
		if(max-min<5) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 * 判断主函数
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []array= {8, 7, 5, 0, 6};
//		int []array= {0, 1, 0, 0, 0};
		int []array= {0,0,0,5,9};
		JudgeContinue judge=new JudgeContinue();
		boolean res=judge.judgeContinue_1(array);
		System.out.println(res);
	}

}
