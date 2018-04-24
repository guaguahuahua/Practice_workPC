package com.xjtu.algorithm;

/**
 * �ж����������Ƿ�Ϊ�����������ĺ����������
 * @author Administrator
 *
 */
public class BinSearchTree {

	/**
	 * ��������Ϊ�����Ǻ�������Ľ�������ǿ��ԶԺ�������Ľ���Ͷ������������ص�������
	 * ��Ϊ����������������������С���������ģ�����һ��ĳ��Ԫ�ش��ڸ��ڵ㣬��ô��Ԫ��������
	 * ������������������
	 * @param nums
	 * @return
	 */
	public static boolean binSearchTree(int []nums) {
		
		boolean res=judge(nums, 0, nums.length-1);
		return res;
	}
	
	/**
	 * �ж��Ƿ����е���������С�ڸ��ڵ��ֵ�����������ڸ��ڵ��ֵ
	 * @param nums
	 * @param startIndex
	 * @param rootIndex
	 */
	public static boolean judge(int []nums, int startIndex, int rootIndex) {
		
		boolean res1=false, res2=false;
		//�ݹ����������
		if(startIndex<rootIndex) {
			int left=startIndex;
			int right=-1;
			boolean flag=false;
			//�ҵ��������Ŀ�ʼ����
			for(int i=startIndex; i<rootIndex; i++) {
				if(nums[i]>nums[rootIndex]) {
					right=i;
					break;
				}
			}
			//�ж��������Ƿ�Ϊȫ�����ڸ��ڵ�
			for(int i=right; i<rootIndex; i++) {
				if(nums[i]<nums[rootIndex]) {
					flag=true;
					break;
				}
			}
			//���������������������������ص�
			if(flag) {
				return false;
			//�������������������ص㣬��ô�ݹ���ж�	
			}else {
				res1=judge(nums, startIndex, right-1);
				res2=judge(nums, right, rootIndex-1);
				return res1 && res2;
			}
		//�ݹ�ĳ���	
		//��Ȼ���������߽��ϣ�˵��ǰ�����������Ѿ��������� �Ѿ�������������
		}else {
			return true;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {9, 40, 12, 394, 540, 410, 381};
		int []nums= {9, 40, 12, 394, 540, 310, 381};
		boolean res=binSearchTree(nums);
		System.out.println(res);
	}

}
