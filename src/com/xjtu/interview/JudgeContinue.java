package com.xjtu.interview;

import java.util.Arrays;

public class JudgeContinue {

	/**
	 * �ж��������������Ƿ������ڵ�
	 * @param array ��������int���ͣ���Ϊ��
	 * @return boolean ���ڷ���true�����򷵻�false
	 */
	private boolean judgeContinue(int []array) {
		//���ȶ����������������
		Arrays.sort(array);
		//�жϵ�һ��Ԫ�أ���Ϊ0
		if(array[0]!=0) {
			for(int i=1; i<array.length; i++) {
				if(array[i]!=array[i-1]+1) {
					return false;
				}
			}
			//ǰ��û����ֹ�ģ���ô����������
			return true;
		//��һ��Ԫ��Ϊ0	
		}else {
			//���ڼ�¼��һ������Ԫ�ص�����
			int index=-1;
			//�ҵ�һ������Ԫ��
			for(int i=1; i<array.length; i++) {
				if(array[i]!=0) {
					index=i;
				}
			}
			//���ֻ��һ������Ԫ��
			if(index==array.length-1) {
				return true;
			//�������Ԫ�ص�ֵ��Ϊ0	
			}else if(index==-1){
				return true;
			//�����ֹһ��Ԫ�ط��㣬��ô�жϵ�һ������Ԫ�غ����һ������Ԫ��֮��Ĳ���С��5����ô��¼Ԫ�صĲ��ʹ��0Ԫ����䣬�ж�
			}else {
				int diff=0;
				for(int i=index+1; i<array.length; i++) {
					diff+=(array[i]-array[i-1]-1);
				}
				//�ж�0Ԫ���ܷ�������еļ�϶
				if(diff==index) {
					return true;
				}else {
					return false;
				}
			}
		}
	}
	
	/**
	 * �жϸ���5�����Ƿ�����
	 * ˼·�������û��0Ԫ�صģ���ô���Ԫ�غ���СԪ�ص�֮�����4��
	 * ����Ǵ���0Ԫ�صģ����ֵ����Сֵ������Ԫ���Ĳ�Ҳ��4��
	 * ����ֻҪ�ҵ���ǰ���е�������С����Ԫ���ж����ǵĲ�ֵ�����С��4��ô��Ϊ��������
	 * @param array
	 * @return
	 */
	private boolean judgeContinue_1(int []array) {
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int diff=-1;
		for(int i=0; i<array.length; i++) {
			if(array[i]!=0) {
				if(array[i]>max) {
					max=array[i];
				}
				if(array[i]<min) {
					min=array[i];
				}
			}
		}
		if(max-min<5) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 * �ж�������
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []array= {8, 7, 5, 0, 6};
//		int []array= {0, 1, 0, 0, 0};
		int []array= {0,0,0,5,9};
		JudgeContinue judge=new JudgeContinue();
		boolean res=judge.judgeContinue_1(array);
		System.out.println(res);
	}

}
