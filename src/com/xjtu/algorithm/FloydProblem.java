package com.xjtu.algorithm;

public class FloydProblem {
	public static final int  inf=999999;

	/**
	 * floyd�㷨ʵ��
	 * ͨ������м�ڵ����������������ڵ�֮��ľ���
	 * @param e
	 */
	public static void floydProblem(int [][]e) {
		//����ʵ�����һ���м�ڵ�a�����پ���ֵ,�м�ڵ�һ����ӳɹ������������·������ֵ��
		//Ҳ���ǲ��ϱ����Ĺ����У���������м�ڵ�Ĺ��̣�
		for(int k=0; k<e.length; k++) {
			for(int i=0; i<e.length; i++) {
				for(int j=0; j<e.length; j++) {
					
					if(e[i][j]>e[i][k]+e[k][j]) {
						e[i][j]=e[i][k]+e[k][j];
					}	
			
				}
			}	
		}
		show(e);
	}
	
	
	public static void show(int [][]nums) {
		
		for(int row=0; row<nums.length; row++) {
			for(int col=0; col<nums.length; col++) {
				System.out.print(nums[row][col]+"\t");
			}
			System.out.println();			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] e = { 
				{ 0, 2, 6, 4 }, 
				{ inf, 0, 4, inf }, 
				{ 7, inf, 0, 1 }, 
				{ 5, inf, 12, 0 } 
				};
		
		floydProblem(e);
	}

}
