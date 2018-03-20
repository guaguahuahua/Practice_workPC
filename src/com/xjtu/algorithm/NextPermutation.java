package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {

    public static void nextPermutation_1(int[] nums) {
    	boolean flag=false;   	
    	
    	//这段代码只对数组长度大于2的有效
        for(int i=nums.length-1; i>0; i--) {
        	//将原数组变大
        	if(nums[i-1]<nums[i]) {
        		//这块可以对交换之后数组元素进行一个排序，获得他们的全排列，并取得次小值作为最终的结果 
        		int temp=nums[i-1];
        		nums[i-1]=nums[i];
        		nums[i]=temp;
        		flag=true;
        		break;
        	}
        }
        
        //也就是整个数组都是降序排列的，那进行逆序
        if(!flag) {
        	int left=0;
        	int right=nums.length-1;
        	while(left<right) {
        		int temp=nums[left];
        		nums[left]=nums[right];
        		nums[right]=temp;
        		left++;
        		right--;
        	}
        }
    }
    
    private static ArrayList<Integer> list=new ArrayList<Integer>();
    public static void nextPermutation_2(int []nums) {
    	//首先获得数组元素的字符串一个排列
    	StringBuilder sb=new StringBuilder();
    	for(int i=0; i<nums.length; i++) {
    		sb.append(nums[i]);
    	}
    	//获得字符串
    	String s=sb.toString();
    	//对该字符串进行全排列
    	permutation(s.toCharArray(), 0, s.length()-1);
    	//对排列进行排序
    	Collections.sort(list);
    	int orig=Integer.parseInt(s);
    	int index=0;
    	//重新遍历这个动态数组定位到原来的位置
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i)==orig) {
    			index=i;
    			break;
    		}
    	}
    	String res="";
    	if(index<list.size()-1) {
    		res=list.get(index+1)+"";
    	}else {
    		res=list.get(0)+"";
    	}
    	//如果最后结果因为0的原因导致长度不够，那么补0
    	while(res.length()<nums.length) {
    		res="0"+res;
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		nums[i]=res.charAt(i)-'0';
    	}
    }
	
    public static void permutation(char []c, int start, int end) {
    	//将排好序的字符串存放在动态数组中
    	if(start==end) {
    		StringBuilder sb=new StringBuilder();
    		for(int i=0; i<c.length; i++) {
    			sb.append(c[i]);
    		}
    		int temp=Integer.parseInt(sb.toString());
    		if(!list.contains(temp)) {
    			list.add(temp);
    		}
    		
    	}else {
    		for(int i=start; i<=end; i++) {
    			swap(c, i, start);
    			permutation(c, start+1, end);
    			swap(c, start, i);
    		}
    	}
    }
    
    public static void swap(char []c, int s, int e) {
    	char temp=c[s];
    	c[s]=c[e];
    	c[e]=temp;
    }
    
    
    public static void nextPermutation(int []nums) {
    	
    	//记录需要交换的起始位置
    	int left=-1;
    	//从右至左的遍历，找到比a[i]>a[i-1]
    	for(int i=nums.length-1; i>=1; i--) {
    		if(nums[i]>nums[i-1]) {
    			left=i-1;
    			break;
    		}
    	}
    	//也就是说所有的元素排列已经是最大的了，直接进行逆序，获得最小的排列
    	if(left==-1) {
    		int l=0;
    		int r=nums.length-1;
    		while(l<r) {
    			swap(nums, l, r);
    			l++;
    			r--;
    		}
    		return ;
    	}
    	
		//记录右边交换的索引
    	int right=-1;
    	//记录差值
    	int delta=Integer.MAX_VALUE;
    	//在右端寻找大于当前值的索引
    	for(int i=left+1; i<nums.length; i++) {
    		//求差
    		int temp=nums[i]-nums[left];
    		//找最小的值
    		if(temp>0) {
    			delta=temp<delta ? temp : delta;
    			right=i;
    		}
    	}
    	swap(nums, right, left);
    	//对交换位置的右侧进行升序排列
    	int l=left+1;
    	int r=nums.length-1;
    	while(l<r) {        		
    		swap(nums, l, r);
    		l++;
    		r--;
    	}

    }
    
    public static void swap(int []nums, int i, int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {1, 2, 3};
//		int []nums= {3,2,1};
//		int []nums= {1,3,2};
//		int []nums= {1};
		int []nums= {0,0,4,2,1,0};
		nextPermutation(nums);
		for(int K:nums) {
			System.out.print(K);
		}
//		char []c= {'1','2','3'};
		System.out.println();
	}

}
