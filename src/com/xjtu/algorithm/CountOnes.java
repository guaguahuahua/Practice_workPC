package com.xjtu.algorithm;

import java.util.List;

public class CountOnes {
	
	/**
	 * ͳ�ƴ�1����������n�У�ʮ���Ƶ�1���ֵĴ���
	 * ֱ��˼·�������ƽ�,brute-force����ÿ�����֣���ͳ������1������
	 * ����ͳ��1������Ҳ�����ַ�ʽ����һ�����ַ�������ʽ���ڶ�������������
	 * ÿ��λ�ϵĶ��������ֵ���ʽ
	 * @param n
	 * @return
	 */
	public static int countOnes(int n) {
		
		if(n<=0) {
			System.out.println("����n����������");
			return -1;
		}	
		int total=0;
		//ͳ��1--n������������1�ĸ���
		for(int i=1; i<=n; i++) {
			total+=count(i);
		}
		return total;
	}
	
	/**
	 * ������n��ÿ��λ�����Ϊ1�ĸ���
	 * @param n
	 * @return
	 */
	public static int count(int n) {
		
		int count=0;
		while(n!=0) {
			//ȡ��λ��
			int ge=n%10;
			if(ge==1) {
				count++;
			}
			n/=10;
		}
		return count;
	}
	
	/**
	 * ʹ���ַ����ķ�ʽ��1--n��ʮ����1�ĸ���
	 * @param n
	 * @return
	 */
	public static int countOnes_1(int n) {
		
		if(n<=0) {
			System.out.println("����n��������");
			return -1;
		}
		
		int total=0;
		//����1--n
		for(int i=1; i<=n; i++) {
			//��iת��Ϊ�ַ�����ʽ
			String temp=i+"";
			//���ַ�����ʽ�����ֽ��б���
			for(int j=0; j<temp.length(); j++) {
				//����ַ�����ʽ����ĳ��λ����Ϊ1����ô������+1
				if(temp.charAt(j)=='1') {
					total+=1;
				}
			}
		}		
		return total;
	}
	
	/*
	 * ���������̶���O(n)ʱ�临�Ӷȵģ�������Ҫһ��O(1)ʱ�临�Ӷȵķ���
	 */
	
	/**
	 * ʹ��O(k)�㷨kΪ���������ĳ��ȣ������1--n��ʮ����1���ֵĸ���
	 * @param n
	 * @return
	 */
	public static int countOnes_2(int n) {
		int count=0;
		String str=n+"";
		int fac=1;
		//�ӵ͵������εĻ�ö�Ӧ��ʮ������
		for(int i=str.length()-1; i>=0; i--) {
			
			int gaowei=0;
			int diwei=0;
			//��õ�ǰ��Ӧ��ʮ������
			int curr=str.charAt(i)-'0';
			//��ø�λ���ַ���
			String t=str.substring(0, i);
			//�����ߵĸ�λ����
			if(!"".equals(t)) {
				gaowei=Integer.parseInt(t);
			}
			//�����ǰλ��Ӧ��ʮ������Ϊ0, ��ô��Ӧ�ĸ�λΪ1�������и�λ�������Ե�ǰλ�Ľ���
			if(curr==0) {
				//�����ǰ���ֲ�ΪΪ���λ

				count+=gaowei*fac;
			}else if(curr==1) {
				//��λ������ڣ������λ
				if(i+1<str.length()) {					
					diwei=Integer.parseInt(str.substring(i+1));	
				}				
				count+=(gaowei*fac + diwei + 1);
			}else {
								
				count+=((gaowei+1)*fac);
			}
			fac*=10;
		}	
		return count;
	}
	
	/**
	 * ����һ���������Ӹ�λ�����λ���ε�������Ӧ����ߺ��ұ�ʣ�������
	 * ʹ���ַ����ķ�ʽ�ȽϺ���⣬�������׿��ƣ�������һЩǶ��ʽ��С��ϵͳ����ʹ��
	 * ���ִ����ּ���õ���Ч��������Ķ�����Ҫ
	 * @param pos
	 * @return
	 */
	public static List<int[]> getHigherAndLower(int n) {
		
		int fac=1;
		int cur=0;
		int high=0;
		int low=0;
		int temp=n;
		int times=1;
		while(n/fac!=0) {
			
			low=n-(n/fac)*fac;
			cur=(n/fac)%fac;
			high=n/(fac*10);
			System.out.println("high:"+high+" cur:"+cur+" low:"+low);
			fac*=10;
		}		
		return null;
	}
	
	
	
	public static void main(String []args) {
		int n=12113;
		
		getHigherAndLower(n);
		
//		System.out.println(n%1000);
		
//		int res=countOnes_2(n);
//		System.out.println(res);
	}
}
