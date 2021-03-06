package com.xjtu.algorithm;
/**
 * 给定矩阵，按照一圈一圈顺时针的方式，打印所有的元素
 * @author Administrator
 *
 */
public class PrintMatrix {

	/**
	 * 顺时针打印矩阵
	 * 设置4个标记，依次的按照顺时针的方向进行打印，	 * 
	 * @param matrix
	 */
	public static void printMatrix(int [][]matrix) {
		int up=0;
		int right=matrix.length-1;
		int down=matrix.length-1;
		int left=0;
		if(up==down && left==right) {
			System.out.println(matrix[0][0]);
		}
		
		while(up<down) {
			//上
			for(int col=left; col<right; col++) {
				System.out.print(matrix[up][col]+"\t");
			}
//			up++;
			//右
			for(int row=up; row<down; row++) {
				System.out.print(matrix[row][right]+"\t");
			}
//			right--;
			//下
			for(int col=right; col>left; col--) {
				System.out.print(matrix[down][col]+"\t");
			}
//			down--;
			//左
			for(int row=down; row>up; row--) {
				System.out.print(matrix[row][left]+"\t");
			}
//			left++;
			up++;
			right--;
			down--;
			left++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [][]matrix= {
//				{1, 2, 3, 4 },
//				{5, 6, 7, 8 },
//				{9, 10,11,12},
//				{13,14,15,16}
////		};
		int [][]matrix= {{2}};
		printMatrix(matrix);
	}

}
