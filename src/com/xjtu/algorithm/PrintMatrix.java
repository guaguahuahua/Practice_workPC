package com.xjtu.algorithm;
/**
 * �������󣬰���һȦһȦ˳ʱ��ķ�ʽ����ӡ���е�Ԫ��
 * @author Administrator
 *
 */
public class PrintMatrix {

	/**
	 * ˳ʱ���ӡ����
	 * ����4����ǣ����εİ���˳ʱ��ķ�����д�ӡ��	 * 
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
			//��
			for(int col=left; col<right; col++) {
				System.out.print(matrix[up][col]+"\t");
			}
//			up++;
			//��
			for(int row=up; row<down; row++) {
				System.out.print(matrix[row][right]+"\t");
			}
//			right--;
			//��
			for(int col=right; col>left; col--) {
				System.out.print(matrix[down][col]+"\t");
			}
//			down--;
			//��
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
