package com.xjtu.algorithm;

/**
 * ���������������������
 * @author Administrator
 *
 */
public class Power {

	/**
	 * ��һ�ֽⷨ��ʹ��java�ṩ��math�������м���
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power(double base, int exponent) {
		
		return Math.pow(base, exponent);
	}
	
	/**
	 * ʹ��forѭ���ķ�ʽʵ��
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power_1(double base, int exponent) {
		
		double res=1.0;
		boolean isNegative=false;
		//����ݴ�Ϊ������ô��������Ϊ0
		if(exponent<0) {
			isNegative=true;
			exponent=-exponent;
			//�������Ϊ0ͬʱָ��Ϊ������ô����Խ������
			if(base==0) {
				return Double.MAX_VALUE;
			}
		}
		
		for(int i=0; i<exponent; i++) {
			res=res*base;
		}
		//�����������ֱ�ӷ��ؽ��������Ǹ��������ص���
		if(isNegative) {
			return 1/res;
		}
		return res;
	}
	
	/**
	 * ����
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power_2(double base, int exponent) {
		
		boolean isNegative=false;
		if(exponent<0) {
			isNegative=true;
			exponent=-exponent;
		}
		double res=1;
		double fac=base;
		
		//������ָ���ķ�ʽ����
		while(exponent!=0) {
			
			if((exponent&1)==1) {
				res=res*fac;
			}
			
			exponent=exponent>>1;
		
			//��鷭����ԭ������Ϊָ��Ҫͨ����λ�ķ�ʽ��2������Ҫͨ�������ķ�ʽ����
			//���Խ�Ҫ�˵Ļ������з����������ֲ���2������Ч��
			fac=fac*fac;
			
		}
		//���ָ��Ϊ������ôֱ�ӷ��أ����ָ����Ϊ�������ص���
		if(isNegative) {
			return 1/res;
		}
		return res;
	}
	
	
	public static void main(String []args) {
		double base=2;
		int exponent=10;
		double res=power_2(base, exponent);
		System.out.println(res);
	}
}
