package com.xjtu;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
    	//����������鳤��Ϊ0ֱ���˳�
    	if(nums.length==0) {
    		return -1;
    	}
    	//������εĴ������ҽ�Ԫ�ؼ��������
    	int []leftSum=new int[nums.length];
    	leftSum[0]=nums[0];
    	//������εĴ�������Ԫ�ؼ��������
    	int []rightSum=new int[nums.length];
    	rightSum[rightSum.length-1]=nums[nums.length-1];
    	//��������ͽ��
    	for(int i=1, j=nums.length-2; i<nums.length && j>-1; i++, j--) {
    		leftSum[i]=leftSum[i-1]+nums[i];
    		rightSum[j]=rightSum[j+1]+nums[j];
    	}    	
//    	//
//    	for(int K : leftSum) {
//    		System.out.print(K+"\t");
//    	}
//    	System.out.println();
//    	for(int K : rightSum) {
//    		System.out.print(K+"\t");
//    	}
//    	System.out.println();
    	//Ѱ��λ��
    	int position=-1;
    	for(int i=0; i<nums.length; i++) {
    		//���������Ŀ�ͷ����ĩβ
    		if(i==0 || i==nums.length-1) {
        		if(i==0 && rightSum[i+1]==0) {
        			return i;
        		}
        		if(i==nums.length-1 && leftSum[i-1]==0) {
        			return i;
        		}
        	//���λ��������м�λ��
    		}else {
        		if(i-1>-1 && i+1<nums.length && leftSum[i-1]==rightSum[i+1]) {
        			position=i;
        			break;
        		}
    		}
    		
    	}
        return position;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,7,3,6,5,6};
//		int []nums= {1,2,3};
//		int []nums= {-1, -1, -1, 0, 1, 1};
		int res=pivotIndex(nums);
		System.out.println("���ս����λ���ǣ�"+res);
	}

}
