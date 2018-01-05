package com.xjtu;

public class UniquePath {

	/**
	 * �ڸ���������Ѱ�Ҵӿ�ʼλ�õ�����λ�õ�·������Ŀ
	 * ʹ�õݹ鷨���
	 * @param m ����
	 * @param n ����
	 * @return  ����·������Ŀ
	 * ������������������������ı���Ǵ�λ�ģ������ڼ䣬ת��Ϊ�������������
	 */
    public static int uniquePaths_1(int m, int n) {
        
    	int [][]label=new int[m][n];
    	int rows=m-1,cols=n-1;
    	return paths(rows,cols);
    }
    /**
     * ʹ�øú������еݹ飬
     * @param rows ������
     * @param cols ������
     * @return
     */
    public static int paths(int rows,int cols) {
    	if(rows==0 || cols==0) { //���ߵ����б߽�������б߽磬ֱ�ӷ���1����Ϊ�����˵�����ֻ���º����������������ڱ߽���ֻ��һ��·����ȥ
    		return 1;
    	}
    	return paths(rows-1,cols)+paths(rows,cols-1);
    }
    
    /**
     * ����1�㷨����ʵ�ֹ��ܣ����ǵ������ľ���ǳ����ʱ����ô���޷��ڹ涨ʱ���ڸ㶨
     * ��������ʹ��һ���µ��㷨�������㷨���������еĹ�ϵ���õ����յĽ����ʱ�临�Ӷ���o(n^2)
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
    	for(int row=1;row<m;row++) { //��ʼλ�õ����⣬��һ��ͼʾ�ľ���
    		for(int col=1;col<n;col++) {
    			label[row][col]=label[row-1][col]+label[row][col-1];
    		}
    	}
    	return label[m-1][n-1];
    }
    /**
     * 2 �㷨��Ȼ��ͨ���ˣ�����ʱ��Ч�ʺܵͣ��Ľ�2�㷨�����ʱ���ռ�Ч��
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
    	int [][]label=new int[2][n]; //�Ľ��㷨����Ϊ�ڼ���Ĺ����У��ռ�ֻʹ���������е����ݣ����Կ��������ռ�
    	for(int cIndex=0;cIndex<n;cIndex++) { //�������н��г�ʼ��
    		label[0][cIndex]=1;
    		label[1][cIndex]=1;
    	}
    	for(int row=1;row<m;row++) {
    		for(int col=1;col<n;col++) {
    			label[1][col]=label[0][col]+label[1][col-1];
    			label[0][col]=label[1][col];//������λ�õ�Ԫ��ƽ��������
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
