package com.xjtu.algorithm;

/**
 * ������ĳ˻���������ʹ�ó�������
 * @author Administrator
 *
 */
public class DivideWithoutSymbol {

	/**
	 * �ֱ��ô�ǰ���ʹӺ���ǰ���������飬�ֱ��ŵ�������
	 * �ۼƳ˻���Aÿ��λ�õ�Ԫ����ǰ������Ԫ�صĳ˻�������B��������Ԫ�صĳ˻�
	 * Ȼ������������飬����ֵ������ÿ��λ�õ�Ԫ����A[i-1]*B[i+1]����˻�
	 * @param nums
	 * @return
	 */
	public static int [] divideWithoutSymbol(int []nums) {
		
		int []fromPost=new int[nums.length];
		fromPost[nums.length-1]=nums[nums.length-1];
		//��ôӺ��浽ǰ����������εĳ˻�
		for(int i=nums.length-2; i>=0; i--) {
			int r=fromPost[i+1]*nums[i];
			fromPost[i]=r;
		}
		//��ǰ����ǰ��ÿ�����ۻ��˻�
		for(int i=1; i<nums.length; i++) {
			nums[i]=nums[i]*nums[i-1];
		}
		int []r=new int[nums.length];
		
		for(int i=0; i<r.length; i++) {
			if(i-1>=0 && i+1<=nums.length-1) {
				r[i]=nums[i-1]*fromPost[i+1];
			}else if(i-1<0) {
				r[i]=fromPost[i+1];
			}else if(i+1>nums.length-1) {
				r[i]=nums[i-1];
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1, 2, 3, 4, 5};
		int []res=divideWithoutSymbol(nums);
		
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]+"\t");
		}
	}

}
