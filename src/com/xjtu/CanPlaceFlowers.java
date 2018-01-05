package com.xjtu;

public class CanPlaceFlowers {
	
	/**
	 * 判断是否能够种花,想法：固定开始和结束位置，然后通过位置的差比上单个花圃的占地面积（3个单位）
	 * @param flowerbed
	 * @param n
	 * @return
	 */
/*    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int start=0,end=flowerbed.length-1; //标记开始和结束位置
    	int left=-1,right=-1; //用来记录花圃中两个位置的坐标
    	int index=0;
    	int remains=0;
    	if(flowerbed.length==1 && (n==0 || n==1)) { //这是仅仅只种一棵树
    		return true;
    	}
    	
    	while(index<flowerbed.length && flowerbed[index]!=1) { //首先计算第一个花圃之前能种几棵树 
    		index++;
    	}
    	remains=n-(index-start)/3; //计算开始的地方能中多少棵花，并计算出剩余花数
    	//计算中间这部分可以中多少的花
    	for(int i=index;i<flowerbed.length;i++) {
    		if(flowerbed[i]!=0 && left==-1) {//找到第一个已经种花的位置，并且没有标记过
    			left=i;
    			continue;
    		}
    		if(flowerbed[i]!=0 && right==-1) {
    			right=i;
    		}
    		//计算两个位置可以种花的数量,
    		if(left!=0 && right!=0) {
    			remains-=(right-left-1)/3;
    			left=right=-1;
    		}
    	}
    	//计算结束位置能中几棵
    	remains-=(end-left)/3;
    	if(remains<=0) {
    		return true;
    	}else {
    		return false;
    	}
    }*/
	/**
	 * 前一种算法漏洞很大，当苗圃为空，或者是苗圃中只种了一个花，得到的结果是错误的
	 * 下面算法的构造，是逐个遍历的，从苗圃的第一个位置到最后一个位置，不断的检查
	 * @param flowerbed
	 * @param n
	 * @return
	 */
/*	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int remains=n;
		int index=0;
		if(flowerbed.length==1 && flowerbed[0]==0 && (n==1 || n==0)) {
			return true;
		}
		
		//首先找到第一个没有种花的位置
		while(index<flowerbed.length && flowerbed[index]==1) { //这块的代码没有考虑到flowerbed比较短的情形可以改进，可能需要加限制条件
			index+=2;
		}
		
		for(index=index;index<flowerbed.length;index+=2) {
			if((flowerbed[index]!=1 && index+1<flowerbed.length && flowerbed[index+1]==0) || (flowerbed[index]==0 && index==flowerbed.length-1 && flowerbed[index-1]==0)) { //第二个条件考虑了最后一个位置的情形
				if(index==0) {
					remains-=1;
				}
				if(index!=0 && flowerbed[index-1]==0) {
					remains-=1;
				}
			}
			if(remains<=0) {// 不用把所有的花都种进去
				break;
			}
		}
		System.out.println("remains:"+remains);
		if(remains<=0) {
			return true;
		}
		return false;
	}*/
	/**
	 * 第二种方法失败了，原因是太死板，在一些情形下是行不通的，在可以种花的地方计算得到无法种花
	 * 当下方法的思路：首先是一段一段的进行累加，最后查看结果是否
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count=1;
		int result=0;
		for(int i=0;i<flowerbed.length;i++) {
			if(flowerbed[i]==0) {
				count++;
			}else {
				result+=(count-1)/2;
				count=0;
			}
		}
		if(count!=0) {
			result+=count/2;
		}
		return result>=n;
	}
	public static void main(String []args) {
//		int []flowerbed= {0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0};
//		int n=17;
//		int []flowerbed = {1,0,0,0,1};
//		int n=2;
//		int []flowerbed= {0};
//		int n=1;
//		int []flowerbed = {0,0,1,0,0};
//		int n=2;
//		int []flowerbed = {0};
//		int n=0;
		int []flowerbed = {1};
		int n=0;
		boolean res=canPlaceFlowers(flowerbed,n);
		System.out.print(res);
	}

}
