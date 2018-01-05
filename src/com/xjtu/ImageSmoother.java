package com.xjtu;

public class ImageSmoother {

	/**
	 * ͼ��ƽ������ʹ��ÿһ��Ԫ����Χ�İ˸����������ֵ��ƽ��ֵ��Ϊ�ĵ�����ֵ
	 * @param M �����ľ���Ԫ��ֵ��0--255������Ĵ�С��1--150
	 * @return
	 */
    public static int[][] imageSmoother(int[][] M) {
    	
    	int length=M.length,width=M[0].length;
    	int[][]result=new int[length][width];
    	//�ٶ�����Ƚϴ�������������3,Ҫ������ֱ�ӽ�ÿ��Ԫ����Χ��8����ֵ���
    	if(length==1 && width==1) {
    		return M;
    	}
    	if(length==1) { //����ֻ��һ��,���У�2�У�1��
    		for(int i=1;i<width-1;i++) {
    			result[0][i]=(M[0][i-1]+M[0][i]+M[0][i+1])/3;
    		}
    		result[0][0]=(M[0][0]+M[0][1])/2;
    		result[0][width-1]=(M[0][width-1]+M[0][width-2])/2;
    		return result;
    	}
    	if(width==1) { //����ֻ��һ��
    		//���У�2�У�1��
    		for(int j=1;j<length-1;j++) {
    			result[j][0]=(M[j-1][0]+M[j][0]+M[j+1][0])/3;
    		}
    		result[0][0]=(M[0][0]+M[1][0])/2;
    		result[length-1][0]=(M[length-1][0]+M[length-2][0])/2;
    		return result;
    	}
    	//����һ���м�����
    	for(int row=1;row<M.length-1;row++) {
    		for(int col=1;col<M[row].length-1;col++) {
    			result[row][col]=(M[row-1][col-1]+M[row-1][col]+M[row-1][col+1]
    							+M[row][col-1]+M[row][col]+M[row][col+1]
    							+M[row+1][col-1]+M[row+1][col]+M[row+1][col+1])/9;
    		}
    	}
    	//����һ�½��䣬ÿ������4������
    	result[0][0]=(M[0][0]+M[0][1]+M[1][0]+M[1][1])/4; //��һ��
    	result[0][width-1]=(M[0][width-1]+M[0][width-2]+M[1][width-1]+M[1][width-2])/4;
    	result[length-1][0]=(M[length-1][0]+M[length-1][1]+M[length-2][0]+M[length-2][1])/4;   //���һ��
    	result[length-1][width-1]=(M[length-1][width-1]+M[length-1][width-2]+M[length-2][width-1]+M[length-2][width-2])/4;
    	//����һ�±�Ե��ÿ������6������
    	int i=0; //��һ��
		for(int j=1;j<width-1;j++) {
			result[i][j]=(M[i][j-1]+M[i][j]+M[i][j+1]
						 +M[i+1][j-1]+M[i+1][j]+M[i+1][j+1])/6;
		}
		i=length-1; //���һ��
		for(int j=1;j<width-1;j++) {
			result[i][j]=(M[i-1][j-1]+M[i-1][j]+M[i-1][j+1]
						 +M[i][j-1]+M[i][j]+M[i][j+1])/6;
		}
		int k=0;  //��һ��
		for(int l=1;l<length-1;l++) {
			result[l][k]=(M[l-1][k]+M[l-1][k+1]
						 +M[l][k]+M[l][k+1]
						 +M[l+1][k]+M[l+1][k+1])/6;
		}
		k=width-1; //���һ��
		for(int l=1;l<length-1;l++) {
			result[l][k]=(M[l-1][k-1]+M[l-1][k]
						 +M[l][k-1]+M[l][k]
						 +M[l+1][k-1]+M[l+1][k])/6;
		}    	
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]M= {{1,1,1},{1,0,1},{1,1,1}};
//		int [][]M= {{1,1},{1,1}};
//		int [][]M= {{1}};
//		int [][]M= {{2,3}};
//		int [][]M= {{2},{3}};
		int [][]res=imageSmoother(M);
		for(int row=0;row<res.length;row++) {
			for(int col=0;col<res[row].length;col++) {
				System.out.print(res[row][col]+"\t");
			}
			System.out.println();
		}
	}

}
