package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class OnesInBinNum {

	/**
	 * 统计二进制数中1的个数
	 * 这样的做法对于负数来讲是行不通的， java中数值使用的是补码表示，
	 * 所以负数在右移的过程中左边添加的都是1，这样使用while循环想将负数变为0是不可能的
	 * 会陷入无限循环的情形，因为java中int类型的变量占用4B那么我们使用32位来依次的比对，从而避免这种情况
	 * @param list
	 * @return
	 */
	public static int onesInBinNum(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			int count=0;
			int temp=list.get(i);
			while(temp!=0) {
				int t=temp&1;
				if(t==1) {
					count++;
				}
				temp=temp>>1;
			}
			System.out.print(count+"\t");
		}
		return 0;
	}
	
	/**
	 * 因为负数是补码表示，所以右移是无法将它变为0，所以使用32位来控制比较的次数
	 * @param list
	 */
	public static void onesInBinNum_1(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			int count=0;
			int temp=list.get(i);
			//对32位依次的比对
			for(int j=0; j<32; j++) {
				int t=(temp & (1<<j));
				if(t!=0) {
					count++;
				}
			}
			System.out.print(count+"\t");
		}
	}
	
	/**
	 * 下面的方法是对上面方法的优化，上面每个整数都会比较32次，但是下面的整数比较次数只是它
	 * 二进制数中1的个数，一个二进制数n和n-1进行与运算，每次都会将n中最右边的1消去，也就是有多少个1
	 * 就会进行多少次这样的循环
	 * @param list
	 */
	public static void onesInBinNum_2(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			int temp=list.get(i);
			int count=0;
			while(temp!=0) {
				temp=temp&(temp-1);
				count++;
			}
			System.out.print(count+"\t");
		}
	}

	/**
	 * 使用java中自带的统计二进制数中1的个数，统计1的个数
	 * @param list
	 */
	public static void onesInBinNum_3(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			
			int temp=list.get(i);
			int count=Integer.bitCount(temp);
			System.out.print(count+"\t");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(-1);
		onesInBinNum_3(list);
	}

}
