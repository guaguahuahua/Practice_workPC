package com.xjtu.algorithm;

public class Rebuild {

	public static void borderFollowing(int [][]data) {
		//遍历整个图象之后算法结束
		for(int row=0; row<data.length; row++) {
			for(int col=0; col<data[0].length; col++) {
				//不为0的像素点调用其他的几个步骤
				if(data[row][col]!=0) {
					
				}				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]data= {{0,0,0,0,0,0,0,0},
				   {0,0,1,1,1,1,0,0},
				   {0,1,1,1,1,1,0,0},
				   {0,1,1,0,0,1,1,0},
				   {0,1,1,0,0,1,1,0},
				   {0,1,1,1,1,1,1,0},
				   {0,0,1,1,1,1,0,0},
				   {0,0,0,0,0,0,0,0}
				   };
	borderFollowing(data);
	}

}
