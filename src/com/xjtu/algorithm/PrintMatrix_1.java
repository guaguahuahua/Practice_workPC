package com.xjtu.algorithm;

public class PrintMatrix_1 {

	public static void printMatrix_1(int row, int col) {
		//计算所有需要的数量
		int all=row*col;
		int [][]m=new int[row][col];
		//第一个开始打印的数字
		int start=1;
		//开始打印的位置
		int r=0, c=0;
		//是否进行换行
		boolean flag=false;
		boolean change=true;
		while(start<=all) {
			m[r][c]=start;
			//斜向打印
			while(start<=all && (r+c)>=1 && r>-1 && c>-1 && r<m.length && c<m[0].length) {
				m[r][c]=start;
				//如果不换行行标++，列表--
				if(!change) {
					r++;
					c--;
				}else {
					r--;
					c++;
				}
				start++;
			}

			//如果不换行，下次换行
			if(!flag) {
				if(c==m[0].length) {
					r=r+2;
					c--;
					start--;
				}else if(r>=0 && c>=0) {
					c++;
				}				
				flag=true;
				change=false;
			}else {
				if(r==m.length) {
					start--;
					c=c+2;
					r--;
				}else if(r>=0 && c>=0) {
					r++;
				}				
				flag=false;
				change=true;
			}
			//如果行标，列标 越界了，那么向后退
			if(r==-1 || c==-1) {
				if(c==-1) {
					c++;
				}
				if(r==-1) {
					r++;
				}
				start--;
			}
			start++;
		}
		show(m);
	}
	
	public static void show(int [][]nums) {
		for(int row=0; row<nums.length; row++) {
			for(int col=0; col<nums[0].length; col++) {
				System.out.print(nums[row][col]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row=6;
		int col=16;
		printMatrix_1(row, col);
		
	}

}
