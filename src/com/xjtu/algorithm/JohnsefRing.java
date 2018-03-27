package com.xjtu.algorithm;

import java.util.LinkedList;

public class JohnsefRing {

	/**
	 * Լɪ�򻷣���ʼ��ÿ���˵�Ȩֵ���Լ���һ����ɾ�����˵��±�
	 * @param nums
	 * @param k
	 */
	public static void johnsefRing(int []nums, int k) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		//��Ԫ�ط��õ�˫��������
		for(int K : nums) {
			list.add(K);
		}
		//�´���Ҫ�����Ĵ���
		int count=k;
		//�´α����Ŀ�ʼ�ڵ�λ��
		int start=0;
		boolean isFirst=true;
		while(!list.isEmpty()) {
			int index=-1;
			if(isFirst) {
				//���Ҫ���еĽڵ�����
				index=(start+count) % list.size();
				isFirst=false;
			}else {
				index=(start+1+count) % list.size();
			}

			//����ڵ��ֵ
			int data=list.get(index);
			System.out.print(index+"\t");
			list.remove(index);
			//�´���Ҫ�����ĸ���
			count=data;
			//�´ο�ʼ��λ��
			start=index;
		}
	}
	
	/**
	 * �������ڽ�ÿ��Ԫ�غ�����ʼ������д�뵽�ṹ��ȥ
	 * @param nums
	 * @param k
	 */
	public static void johnsefRing_1(int []nums, int k) {
		LinkedList<int []>list=new LinkedList<int []>();
		//ÿһ��Ԫ�ص�����������Ӧ��ֵ
		for(int i=0; i<nums.length; i++) {
			list.add(new int[] {i+1, nums[i]});
		}
		//��һ�ο�ʼ������
		int start=0;
		//��һ�ο�ʼ��������
		int count=k;
		
		while(!list.isEmpty()) {
			//�¸��ڵ��λ��
			int index=(start+count) % list.size();
			index=index-1;
			if(index<0) {
				index=list.size()-1;
			}
			//ȡ���ýڵ�
			int []temp=list.get(index);
			list.remove(index);
			//����ýڵ�ԭʼ����λ��
			System.out.print(temp[0]+"\t");
			//�����¸���ʼ��λ�ã��ӵ�ǰԪ�ص���һ����ʼ
			start=index+1;
			//�´α����Ĵ���
			count=temp[1];
		}
		
	}
	
	/**
	 * ����ֱ�Ӹ��ݸ����������������ʵ��
	 * @param nums
	 * @param k
	 */
	public static void johnsefRing_2(int []nums, int k) {
		
		int start=0;
		int len=nums.length;
		//�����Ĵ�����Ԫ�صĸ���
		for(int i=0; i<nums.length; i++) {
			int index=(start+k) % len;
			if(index==0) {
				index=len-1;
			}
			System.out.print(nums[index-1]);
			start=index;
			len--;
		}
	}
	
	
	public static void johnsefRing_3(int []nums, int k) {
		int pos=backtrack(nums.length, k);
		System.out.println(pos);
	}
	
	public static int backtrack(int people, int m) {
		if(people==1) {
			return 0;
		}
		return (backtrack(people-1, m)+m) % people;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {3,1,7,2,4,8,4};
		int k=20;
		johnsefRing_1(nums, k);
	}

}
