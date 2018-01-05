package com.xjtu.algorithm;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @param row1 第1个矩阵的行数
	 * @param col1 第1个矩阵的列数 
	 * @param row2  第2个矩阵的行数
	 * @param col2 第2个矩阵的列数
	 * @param m1 第一个矩阵
	 * @param m2第二个矩阵
	 */
	public static void matrixAdd(int row1,int col1,int row2,int col2,int[][]m1,int [][]m2) {
		//判断两个矩阵行列是否相等
		if((row1==row2) && (col1==col2) ) {
			//定义输出数组
			int [][]result=new int[row1][col1];
			//行列相等，矩阵相加
			for(int i=0; i<row1; i++) {
				for(int j=0; j<col1; j++) {
					//两个矩阵对应元素相加
					result[i][j]=m1[i][j]+m2[i][j];
				}
			}
		}else {
			//行列不相等，输出无法相加
			System.out.println("行列不等，无法相加");
		}
		
	}

}
