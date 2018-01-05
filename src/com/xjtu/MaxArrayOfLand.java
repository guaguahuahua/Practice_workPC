package com.xjtu;

import java.util.LinkedList;

public class MaxArrayOfLand {
	
	/**
	 * �������ά�����е���������
	 * @param grid
	 * @return
	 */
    public static int maxAreaOfIsland(int[][] grid) {
    	//���������ֻ�д���max�Ż����
    	int max=0;
    	//�����ʱ�����
    	int s=0;
    	//������ŵ�ǰ���������λ����Ϣ
    	LinkedList<String> queue=new LinkedList<String>();
    	for(int row=0; row<grid.length; row++) {
    		for(int col=0; col<grid[0].length; col++) {
    			//�����ǰ��λ���Ǹ���������λ�������
    			if(grid[row][col]==1) {
    				s=0;
    				queue.add(row+" "+col);
					//��ӹ��ĵط���Ϊ2,��ֹ�ظ�����
					grid[row][col]=2;
    				//4����������жϣ�����λ�������
    				while(!queue.isEmpty()) {
    					String tmp=queue.remove();
    					//������Լ�
    					s++;
    					//����б��б�
    					String []t=tmp.split("\\s");
    					int r=Integer.parseInt(t[0]);
    					int c=Integer.parseInt(t[1]);
    					//upλ���ж�
    					if(r-1>=0 && grid[r-1][c]==1) {
    						queue.add((r-1)+" "+c);
    						//��ӹ��ĵط���Ϊ2,��ֹ�ظ�����
    						grid[r-1][c]=2;
    					}
    					//rightλ���ж�
    					if(c+1<grid[0].length && grid[r][c+1]==1) {
    						queue.add(r+" "+(c+1));
    						//��ӹ��ĵط���Ϊ2,��ֹ�ظ�����
    						grid[r][c+1]=2;
    					}
    					//down
    					if(r+1<grid.length && grid[r+1][c]==1) {
    						queue.add((r+1)+" "+c);
    						//��ӹ��ĵط���Ϊ2,��ֹ�ظ�����
    						grid[r+1][c]=2;
    					}
    					//left
    					if(c-1>=0 && grid[r][c-1]==1) {
    						queue.add(r+" "+(c-1));
    						//��ӹ��ĵط���Ϊ2,��ֹ�ظ�����
    						grid[r][c-1]=2;
    					}
    				}
    			}
    			//��ն���
    			queue.clear();
    			//����������
    			if(s>max) {
    				max=s;
    			}
    		}
    	}
    	//test para
    	for(int i=0; i<grid.length; i++) {
    		for(int j=0; j<grid[0].length; j++) {
    			System.out.print(grid[i][j]+" ");
    		}
    		System.out.println();
    	}

        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]grid= {
				      {0,0,1,0,0,0,0,1,0,0,0,0,0},
		              {0,0,0,0,0,0,0,1,1,1,0,0,0},
		              {0,1,1,0,1,0,0,0,0,0,0,0,0},
		              {0,1,0,0,1,1,0,0,1,0,1,0,0},
		              {0,1,0,0,1,1,0,0,1,1,1,0,0},
		              {0,0,0,0,0,0,0,0,0,0,1,0,0},
		              {0,0,0,0,0,0,0,1,1,1,0,0,0},
		              {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		int[][]grid= {{0,0,0,0,0,0,0,0,0,0,0,0,0}};
//		int[][]grid= {
//				{1,1,0,0,0},
//				{1,1,0,0,0},
//				{0,0,0,1,1},
//				{0,0,0,1,1},
//				};
		int res=maxAreaOfIsland(grid);
		System.out.print(res);

	}

}
