package com.xjtu.algorithm;
/**
 * ���ַ��� ת��Ϊ����
 * @author Administrator
 *
 */
public class StringToInteger_1 {

	/**
	 * ���к��Ĵ�����Ҫ���ַ�ת��Ϊ���ֵĹ��̣����Ǳ���ð�������Ŀ��ǣ�
	 * 1.�������ķ�������
	 * 2.������ո������
	 * 3.�����ķ�������
	 * 4.����������������
	 * @param s
	 * @return
	 */
	public static int stringToInteger(String s) {
		//������Ľ��
		int res=0;
		//�ж��Ƿ�Ϊ����
		boolean negative=false;
		//�ַ��������Ŀ�ʼ�ĵ�һ������λ��
		int i=0;
		char first=s.charAt(0);
		if(first=='+') {
			i=1;
		}
		if(first=='-') {
			i=1;
			negative=true;
		}
		int fac=1;
		//����
		for (int start=s.length()-1; start>=i; start--) {
			char c=s.charAt(start);
			//���Ϊ����
			if((c>='0' && c<='9')) {
				res=res+(c-'0')*fac;
				fac=fac*10;
				//�ж��Ƿ��������
				if((res<0 && res<=Integer.MIN_VALUE) || (res>0 && res>Integer.MAX_VALUE)) {
					return Integer.MIN_VALUE;
				}
				
			//���Ϊ�ո��Ǽ����´�ѭ��	
			}else if(c==' ') {
				continue;
			//����Ȳ��ǿո�Ҳ��������	
			}else {
				return Integer.MIN_VALUE;
			}
		}
		//����ǰ��������ŵ��жϷ��ؽ��
		if(negative) {
			return -res;
		}else {
			return res;
		}
	}
	
	public static void main(String []args) {
		String s="-1 2% 222222222222222222222";
		int res=stringToInteger(s);
		System.out.println(res);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
