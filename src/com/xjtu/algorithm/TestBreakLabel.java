package com.xjtu.algorithm;

public class TestBreakLabel {

	/**
	 * ����ʹ�ñ�ǩ����ʽʵ��break��ʵ����continueҲ�ǿ���ʹ�ñ�ǩ�ģ�
	 * �������������ʹ�ñ�ǩ������Ҫ��ѭ������ʵ�ֵġ�
	 * @param args
	 */
	public static void main(String []args) {
		
out:	for(int i=0; i<5; i++) {
			for(int j=0; j<7; j++) {
				if(i>3) {
					break out;
				}	
			}
		}
	}
}
