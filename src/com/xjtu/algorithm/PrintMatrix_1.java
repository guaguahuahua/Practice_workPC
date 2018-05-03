package com.xjtu.algorithm;

public class PrintMatrix_1 {

	public static void printMatrix_1(int row, int col) {
		//����������Ҫ������
		int all=row*col;
		int [][]m=new int[row][col];
		//��һ����ʼ��ӡ������
		int start=1;
		//��ʼ��ӡ��λ��
		int r=0, c=0;
		//�Ƿ���л���
		boolean flag=false;
		boolean change=true;
		while(start<=all) {
			m[r][c]=start;
			//б���ӡ
			while(start<=all && (r+c)>=1 && r>-1 && c>-1 && r<m.length && c<m[0].length) {
				m[r][c]=start;
				//����������б�++���б�--
				if(!change) {
					r++;
					c--;
				}else {
					r--;
					c++;
				}
				start++;
			}

			//��������У��´λ���
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
			//����б꣬�б� Խ���ˣ���ô�����
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
