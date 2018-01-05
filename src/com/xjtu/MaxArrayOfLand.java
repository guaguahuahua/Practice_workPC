package com.xjtu;

import java.util.LinkedList;

public class MaxArrayOfLand {
	
	/**
	 * 求给定二维数组中岛的最大面积
	 * @param grid
	 * @return
	 */
    public static int maxAreaOfIsland(int[][] grid) {
    	//岛的面积，只有大于max才会更新
    	int max=0;
    	//存放临时的面积
    	int s=0;
    	//用来存放当前非零区域的位置信息
    	LinkedList<String> queue=new LinkedList<String>();
    	for(int row=0; row<grid.length; row++) {
    		for(int col=0; col<grid[0].length; col++) {
    			//如果当前的位置是个“岛”将位置如队列
    			if(grid[row][col]==1) {
    				s=0;
    				queue.add(row+" "+col);
					//添加过的地方置为2,防止重复遍历
					grid[row][col]=2;
    				//4个方向进行判断，将岛位置入队列
    				while(!queue.isEmpty()) {
    					String tmp=queue.remove();
    					//岛面积自加
    					s++;
    					//获得行标列表
    					String []t=tmp.split("\\s");
    					int r=Integer.parseInt(t[0]);
    					int c=Integer.parseInt(t[1]);
    					//up位置判断
    					if(r-1>=0 && grid[r-1][c]==1) {
    						queue.add((r-1)+" "+c);
    						//添加过的地方置为2,防止重复遍历
    						grid[r-1][c]=2;
    					}
    					//right位置判断
    					if(c+1<grid[0].length && grid[r][c+1]==1) {
    						queue.add(r+" "+(c+1));
    						//添加过的地方置为2,防止重复遍历
    						grid[r][c+1]=2;
    					}
    					//down
    					if(r+1<grid.length && grid[r+1][c]==1) {
    						queue.add((r+1)+" "+c);
    						//添加过的地方置为2,防止重复遍历
    						grid[r+1][c]=2;
    					}
    					//left
    					if(c-1>=0 && grid[r][c-1]==1) {
    						queue.add(r+" "+(c-1));
    						//添加过的地方置为2,防止重复遍历
    						grid[r][c-1]=2;
    					}
    				}
    			}
    			//清空队列
    			queue.clear();
    			//更新最大面积
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
