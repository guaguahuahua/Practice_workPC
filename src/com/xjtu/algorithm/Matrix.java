package com.xjtu.algorithm;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @param row1 ��1�����������
	 * @param col1 ��1����������� 
	 * @param row2  ��2�����������
	 * @param col2 ��2�����������
	 * @param m1 ��һ������
	 * @param m2�ڶ�������
	 */
	public static void matrixAdd(int row1,int col1,int row2,int col2,int[][]m1,int [][]m2) {
		//�ж��������������Ƿ����
		if((row1==row2) && (col1==col2) ) {
			//�����������
			int [][]result=new int[row1][col1];
			//������ȣ��������
			for(int i=0; i<row1; i++) {
				for(int j=0; j<col1; j++) {
					//���������ӦԪ�����
					result[i][j]=m1[i][j]+m2[i][j];
				}
			}
		}else {
			//���в���ȣ�����޷����
			System.out.println("���в��ȣ��޷����");
		}
		
	}

}
