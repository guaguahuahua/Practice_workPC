package com.xjtu.algorithm;

public class QueueReconstructByHeight {

    public static int[][] reconstructQueue(int[][] people) {

    	//有序的索引开始节点
    	int or=0;
    	
    	//首先寻找k最小的那个元素
    	for(int v=0; v<=1100 && or<=people.length; v++) {
    		for(int row=0; row<people.length; row++) {
    			
        		if(people[row][1]==v) {    			
    	    		int j=0;
    	    		//存放要排序的元素
    	    		int []temp=people[row];
    	    		//该元素前面有多少个高于它的元素
    	    		int times=temp[1];
    	    		//寻找插入位置
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
    	    			//如果某个人比当前人高
    	    			if(people[j][0]>=temp[0]) {
    	    				times--;
    	    			}
    	    			j++;
    	    		}
    	    		//移动前面有序的元素
    	    		for(int k=row; k>j; k--) {
    	    			people[k]=people[k-1];
    	    		}
    	    		//元素插入
    	    		people[j]=temp;
    	    		//有序元素的个数
        			or++;
        			
        			
        			
        		}
    		}

    	}
    	
    	
//    	for(int i=0; i<people.length; i++) {
//    		//寻找插入位置
//    		int j=0;
//    		//存放要排序的元素
//    		int []temp=people[i];
//    		//该元素前面有多少个高于它的元素
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
//    		//移动前面有序的元素
//    		for(int k=i; k>j; k--) {
//    			people[k]=people[k-1];
//    		}
//    		//元素插入
//    		people[j]=temp;
//    	}
    	return people;        
    }
    
    /**
     * 插入元素
     * @param people	int[][]	需要插入的数组
     * @param k			int[][]	需要插入的元素
     */
    public static void insert(int [][]people, int h, int k) {
    	//比较
    	int times=k;
    	int rows=people.length;
    	//寻找插入的位置
    	int i;
    	for(i=0; i<rows; i++) {
    		if(times==0) {
    			break;
    		}
    		if(people[i][0]>=h) {
    			times--;
    		}
    	}
    	//为了防止越界，将最后一个元素复制出来，放在单独的变量中
    	int []temp=people[rows-1];
    	//元素移动，一行一行的向后移动元素
    	for(int j=rows-1; j>i; j--) {
    		people[j]=people[j-1];
    	}
    	//插入
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
