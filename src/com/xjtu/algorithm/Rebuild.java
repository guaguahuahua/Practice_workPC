package com.xjtu.algorithm;

public class Rebuild {

	public static void borderFollowing(int [][]data) {
		//��������ͼ��֮���㷨����
		for(int row=0; row<data.length; row++) {
			for(int col=0; col<data[0].length; col++) {
				//��Ϊ0�����ص���������ļ�������
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
