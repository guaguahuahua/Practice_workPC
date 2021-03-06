package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印从1到最大n位数
 * 第一种方式，求出最大的n然后直接暴力遍历；但是会发生溢出，如果n很大不在基本类型的表示范围内，就会导致溢出的情形
 * 第二种方式，使用数组的方式实现，数组的长度为n+1，初始化数组为0；之后不断的给数组的最低位+1，直到0位发生了溢出停止；我认为最好的方式，不会发生溢出，基本上可以实现所有的要求
 * 第三种方式，就是求出一个全排列，而全排列是可以通过二进制数的形式来实现的，但是n对应的最大的数可能会溢出
 * @author Administrator
 *
 */
public class PrintOneToMaxN {

	/**
	 * n是[1,5]区间内的正整数
	 * 根据给定的n生成最大的n位数，然后通过遍历的方式实现
	 * 如果直接实现，那么最大的数可能就会超出基本类型的范围
	 * @param n
	 */
	public static void printOneToMaxN(int n) {
		
		if(n<1 || n>5) {
			
			System.out.println("参数n越界！");
			return;
		}
		int max=0;
		//生成最大的n位数
		while(n>=1) {
			max=max+9*(int)Math.pow(10,n-1);
			n--;
		}
		
		//输出从1到最大的n位数之间的所有数
		for(int i=1; i<=max; i++) {
//			System.out.println(i);
		}
		System.out.println("end");
	}
	
	/**
	 * 通过使用数组的方式来实现遍历
	 * 申请长度为n+1的整型数组，每次给最低位加1，不断遍历
	 * 终止条件为：数组的第0位为1，也就是发生了溢出
	 * @param n
	 */
	public static void printOneToMaxN_1(int n) {
		
		int[] max=new int[n+1];
		int low=max.length-1;
		
		//如果没有发生溢出，也就是没有达到最大值
		while(max[0]!=1){
			//总是给最低位+1
			addOne(max, low);
			
			//这块添加这个判断语句是为了避免溢出值的输出，因为最大值时while循环会继续，但是+1操作之后导致整个溢出，此时再循环内部仍然可以继续输出，
			//从而导致溢出值被输出，但是添加该语句之后，导致效率下降，每次都会判断这个是否溢出
			if(max[0]!=1) {
				//输出当前数组
				print(max);	
			}
		}
	}
	
	/**
	 * 给数组对应的pos位置+1
	 * @param nums
	 * @param pos
	 */
	public static void addOne(int []nums, int pos) {

		//递归的出口
		if(pos<0) {
			return;
		}		
		//如果当前位发生进位，那么就递归的判断高位是否也发生了进位
		if(nums[pos]+1>9) {
			nums[pos]=0;
			addOne(nums, pos-1);
		}else {
			nums[pos]=nums[pos]+1;
			return ;
		}
	}
	
	
	/**
	 * 输出一个数组中的所有非零元素
	 * @param nums
	 */
	public static void print(int []nums) {
		
		boolean flag=false;
		
		for(int i=0; i<nums.length; i++) {
			//寻找第一个不为0的元素
			if(nums[i]!=0 && flag==false) {
				flag=true;
			}
			if(flag) {
				System.out.print(nums[i]);	
			}
			
		}
		System.out.println();
	}
	
	/**
	 * 使用全排列实现遍历的效果
	 * 但是递归导致效率十分低下，一般的递归的次数低于5的时候还可以 >=5的时候耗时就非常的大了
	 * @param n
	 */
	public static void printOneToMaxN_2(int n) {
		
		int []nums=new int[n];
		int low=nums.length-1;
		List<String> list=new ArrayList<String>();
		backtrack(nums, low, list);
		show(list);
	}
	
	/**
	 * 将集合中的元素全部输出
	 * @param list
	 */
	public static void show(List<String> list) {
		for(String K:list) {
			System.out.println(K);
		}
	}
	
	
	/**
	 * 递归得到数字的全排列
	 * @param nums
	 * @param pos
	 */
	public static void backtrack(int []nums, int pos) {
		
		if(pos<0) {
			return ;
		}
		
		for(int i=0; i<=9; i++) {
			nums[pos]=i;
			print_2(nums);
			backtrack(nums, pos-1);			
		}
	}
	
	
	/**
	 * 将得到的数字以字符串的形式存放在集合中，每次添加时候都要检查存在与否
	 * @param nums
	 * @param pos
	 * @param list
	 */
	public static void backtrack(int []nums, int pos, List<String> list) {
		
		if(pos<0) {
			return; 
		}
		for(int i=0; i<=9; i++) {
			nums[pos]=i;
			String temp=myToString(nums);
			//判断集合中是否已经存在该数字，只存非空的串
			if(!list.contains(temp) && !temp.equals("")) {
				list.add(temp);	
			}			
			backtrack(nums, pos-1, list);
		}
	}
	
	/**
	 * 将数组中的元素转化为字符串
	 * @param nums
	 * @return
	 */
	public static String myToString(int []nums) {
		
		String res="";
		boolean start=false;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=0 && !start) {
				start=true;
			}
			if(start) {
				res=res+nums[i];
			}
		}
		return res;
	}
	
	
	public static void clear(int []nums, int pos) {
		while(pos<nums.length) {
			nums[pos++]=0;
		}
	}
	
	
	/**
	 * 输出当前数组对应的数
	 * @param nums
	 */
	public static void print_2(int []nums) {
		
		boolean isZero=true;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=0 && isZero) {
				isZero=false;
			}
			if(!isZero) {
				System.out.print(nums[i]);
			}
		}
		//为了防止输出多于的空行添加判断
		if(!isZero) {
			System.out.println();	
		}
		
	}
	
	
	public static void main(String []args) {
		int []nums= {0,0,0,1,0,2,3};
//		print_2(nums);
		printOneToMaxN_2(5);
	}
}
