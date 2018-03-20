package com.xjtu.algorithm;

public class QueueReconstructByHeight {

    public static int[][] reconstructQueue(int[][] people) {

    	//�����������ʼ�ڵ�
    	int or=0;
    	
    	//����Ѱ��k��С���Ǹ�Ԫ��
    	for(int v=0; v<=1100 && or<=people.length; v++) {
    		for(int row=0; row<people.length; row++) {
    			
        		if(people[row][1]==v) {    			
    	    		int j=0;
    	    		//���Ҫ�����Ԫ��
    	    		int []temp=people[row];
    	    		//��Ԫ��ǰ���ж��ٸ���������Ԫ��
    	    		int times=temp[1];
    	    		//Ѱ�Ҳ���λ��
    	    		while(j<or) {
    	    			if(times==0) {
    	    				if(temp[0]>=people[j][0]) {
    	    					break;
    	    				}else {
    	    					while(j<or && temp[0]<people[j][0]) {
        	    					j++;
        	    				}
    	    					break;
    	    				}
    	    			}
    	    			//���ĳ���˱ȵ�ǰ�˸�
    	    			if(people[j][0]>=temp[0]) {
    	    				times--;
    	    			}
    	    			j++;
    	    		}
    	    		//�ƶ�ǰ�������Ԫ��
    	    		for(int k=row; k>j; k--) {
    	    			people[k]=people[k-1];
    	    		}
    	    		//Ԫ�ز���
    	    		people[j]=temp;
    	    		//����Ԫ�صĸ���
        			or++;
        			
        			
        			
        		}
    		}

    	}
    	
    	
//    	for(int i=0; i<people.length; i++) {
//    		//Ѱ�Ҳ���λ��
//    		int j=0;
//    		//���Ҫ�����Ԫ��
//    		int []temp=people[i];
//    		//��Ԫ��ǰ���ж��ٸ���������Ԫ��
//    		int times=temp[1];
//    		
//    		while(j<i) {
//    			if(times==0) {
//    				break;
//    			}
//    			if(people[j][0]>=people[i][0]) {
//    				times--;
//    			}
//    			j++;
//    		}
//    		//�ƶ�ǰ�������Ԫ��
//    		for(int k=i; k>j; k--) {
//    			people[k]=people[k-1];
//    		}
//    		//Ԫ�ز���
//    		people[j]=temp;
//    	}
    	return people;        
    }
    
    /**
     * ����Ԫ��
     * @param people	int[][]	��Ҫ���������
     * @param k			int[][]	��Ҫ�����Ԫ��
     */
    public static void insert(int [][]people, int h, int k) {
    	//�Ƚ�
    	int times=k;
    	int rows=people.length;
    	//Ѱ�Ҳ����λ��
    	int i;
    	for(i=0; i<rows; i++) {
    		if(times==0) {
    			break;
    		}
    		if(people[i][0]>=h) {
    			times--;
    		}
    	}
    	//Ϊ�˷�ֹԽ�磬�����һ��Ԫ�ظ��Ƴ��������ڵ����ı�����
    	int []temp=people[rows-1];
    	//Ԫ���ƶ���һ��һ�е�����ƶ�Ԫ��
    	for(int j=rows-1; j>i; j--) {
    		people[j]=people[j-1];
    	}
    	//����
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]people= {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
//		int [][]people= {{3,3},{4,4},{2,1},{5,0},{6,0},{5,2}};
//		int [][]people= {{1,0},{2,0},{3,0},{4,0}};
//		int [][]people= {{4,0},{3,0},{2,0},{1,0}};
		reconstructQueue(people);
		for(int row=0; row<people.length; row++) {
			System.out.println(people[row][0]+", "+people[row][1]);
		}
		
		
	}

}
