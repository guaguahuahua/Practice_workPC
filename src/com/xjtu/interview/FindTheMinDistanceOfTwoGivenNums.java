package com.xjtu.interview;

public class FindTheMinDistanceOfTwoGivenNums {

	/**
	 * �ҵ���������������С����
	 * ���ȶ�����룬Ȼ������������c1��c2���ֱ���������ʵ�������������������
	 * ÿ�α�����Ϊ����Ԫ��ʱ������һ�ξ����ֵ���ý�Сֵ�滻�ϴ�ֵ�������ձ���������ʱ��
	 * ���ܵõ�������������Сֵ
	 * @param nums
	 * @param n1
	 * @param n2
	 * @return int
	 */
	private int findTheMinDistanceOfTwoGivenNums(int []nums, int n1, int n2) {
		//��ʾ����Ԫ�صĳ�ʼλ��
		int c1=Integer.MAX_VALUE,c2=Integer.MAX_VALUE;
		//��¼������֮��ľ���
		int diff=Integer.MAX_VALUE;
		//��¼��ʱ�ľ���ֵ
		int dis=0;
		for(int i=0; i<nums.length; i++) {
			//���������Ԫ��Ϊ��һ����
			if(nums[i]==n1) {
				c1=i;
				dis=Math.abs(c1-c2);
				if(dis<diff) {
					diff=dis;
				}
			}
			//���������Ԫ��Ϊ�ڶ�����
			if(nums[i]==n2) {
				c2=i;
				dis=Math.abs(c2-c1);
				if(dis<diff) {
					diff=dis;
				}
			}
		}
		return diff;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
//		
//		FindTheMinDistanceOfTwoGivenNums find=new FindTheMinDistanceOfTwoGivenNums();
//		int diff=find.findTheMinDistanceOfTwoGivenNums(nums, 4, 8);
//		System.out.println(diff);
		float b=0.71244F;
		System.out.println(255*b);
	}

}
