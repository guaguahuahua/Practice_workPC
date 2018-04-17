package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class OnesInBinNum {

	/**
	 * ͳ�ƶ���������1�ĸ���
	 * �������������ڸ����������в�ͨ�ģ� java����ֵʹ�õ��ǲ����ʾ��
	 * ���Ը��������ƵĹ����������ӵĶ���1������ʹ��whileѭ���뽫������Ϊ0�ǲ����ܵ�
	 * ����������ѭ�������Σ���Ϊjava��int���͵ı���ռ��4B��ô����ʹ��32λ�����εıȶԣ��Ӷ������������
	 * @param list
	 * @return
	 */
	public static int onesInBinNum(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			int count=0;
			int temp=list.get(i);
			while(temp!=0) {
				int t=temp&1;
				if(t==1) {
					count++;
				}
				temp=temp>>1;
			}
			System.out.print(count+"\t");
		}
		return 0;
	}
	
	/**
	 * ��Ϊ�����ǲ����ʾ�������������޷�������Ϊ0������ʹ��32λ�����ƱȽϵĴ���
	 * @param list
	 */
	public static void onesInBinNum_1(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			int count=0;
			int temp=list.get(i);
			//��32λ���εıȶ�
			for(int j=0; j<32; j++) {
				int t=(temp & (1<<j));
				if(t!=0) {
					count++;
				}
			}
			System.out.print(count+"\t");
		}
	}
	
	/**
	 * ����ķ����Ƕ����淽�����Ż�������ÿ����������Ƚ�32�Σ���������������Ƚϴ���ֻ����
	 * ����������1�ĸ�����һ����������n��n-1���������㣬ÿ�ζ��Ὣn�����ұߵ�1��ȥ��Ҳ�����ж��ٸ�1
	 * �ͻ���ж��ٴ�������ѭ��
	 * @param list
	 */
	public static void onesInBinNum_2(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			int temp=list.get(i);
			int count=0;
			while(temp!=0) {
				temp=temp&(temp-1);
				count++;
			}
			System.out.print(count+"\t");
		}
	}

	/**
	 * ʹ��java���Դ���ͳ�ƶ���������1�ĸ�����ͳ��1�ĸ���
	 * @param list
	 */
	public static void onesInBinNum_3(List<Integer> list) {
		
		for(int i=0; i<list.size(); i++) {
			
			int temp=list.get(i);
			int count=Integer.bitCount(temp);
			System.out.print(count+"\t");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(-1);
		onesInBinNum_3(list);
	}

}
