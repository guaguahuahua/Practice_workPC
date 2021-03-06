package com.xjtu;

public class UniquePath {

	/**
	 * 在给定矩阵中寻找从开始位置到结束位置的路径的数目
	 * 使用递归法完成
	 * @param m 行数
	 * @param n 列数
	 * @return  所有路径的数目
	 * 传进来的行数和列数与数组的编号是错位的，保险期间，转化为数组的行列索引
	 */
    public static int uniquePaths_1(int m, int n) {
        
    	int [][]label=new int[m][n];
    	int rows=m-1,cols=n-1;
    	return paths(rows,cols);
    }
    /**
     * 使用该函数进行递归，
     * @param rows 行索引
     * @param cols 列索引
     * @return
     */
    public static int paths(int rows,int cols) {
    	if(rows==0 || cols==0) { //当走到了行边界或者是列边界，直接返回1，因为机器人的行走只有下和右两个方向，所以在边界上只有一个路径过去
    		return 1;
    	}
    	return paths(rows-1,cols)+paths(rows,cols-1);
    }
    
    /**
     * 上面1算法可以实现功能，但是当给定的矩阵非常大的时候，那么就无法在规定时间内搞定
     * 现在我们使用一个新的算法，矩阵算法，按照行列的关系，得到最终的结果，时间复杂度是o(n^2)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths_2(int m, int n) {
    	int [][]label=new int[m][n];
    	for(int rIndex=0;rIndex<m;rIndex++) {
    		label[rIndex][0]=1;
    	}
    	for(int cIndex=0;cIndex<n;cIndex++) {
    		label[0][cIndex]=1;
    	}
    	for(int row=1;row<m;row++) { //开始位置的问题，看一下图示的矩阵
    		for(int col=1;col<n;col++) {
    			label[row][col]=label[row-1][col]+label[row][col-1];
    		}
    	}
    	return label[m-1][n-1];
    }
    /**
     * 2 算法虽然是通过了，但是时间效率很低，改进2算法，提高时间或空间效率
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
    	int [][]label=new int[2][n]; //改进算法，因为在计算的过程中，空间只使用了相邻行的数据，所以可以缩减空间
    	for(int cIndex=0;cIndex<n;cIndex++) { //对这两行进行初始化
    		label[0][cIndex]=1;
    		label[1][cIndex]=1;
    	}
    	for(int row=1;row<m;row++) {
    		for(int col=1;col<n;col++) {
    			label[1][col]=label[0][col]+label[1][col-1];
    			label[0][col]=label[1][col];//将下面位置的元素平移至上面
    		}
    	}
    	return label[1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=2;
		int n=1;
		int res=uniquePaths(m,n);
		System.out.print("nums of paths: "+res);
	}

}
