package com.xjtu.algorithm;

/**
 * �ж�������ַ�����ʾ���Ƿ�Ϊ������
 * @author Administrator
 *
 */
public class JudgeIsFloat {

	public static boolean judgeIsFloat(String s) {
		int dian=0;
		int e=0;
		int E=0;
		int positive=0;
		int negative=0;
		//��һ�ι��˲�������ַ�����ͳ��һЩ�ؼ����ַ����ִ���
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//��������ֺ͸���Ļ����ķ���
			if(!(c=='+' || c=='-' || c=='E' || c=='e' || c=='.' || c>='0' && c<='9')) {
				return false;
			}else if(c=='.'){
				dian++;
			}else if(c=='e') {
				e++;
			}else if(c=='E') {
				E++;
			}else if(c=='+') {
				positive++;
			}else if(c=='-') {
				negative++;
			}
			if(dian>1 || e>1 || E>1 || positive>2 || negative>2) {
				return false;
			}
		}
		//������㸡�����ķ��������������жϸ�ʽ�Ƿ���ȷ
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//�����������
			if(c=='+' || c=='-') {
				//���+-�г���������
				if(positive==2 || negative==2) {
					if(c=='+') {
						int i1=s.lastIndexOf('+');
						boolean t1=checkValidation(s, i1);
						if(checkValidation(s, i)==false || t1==false) {
							return false;
						}
					}else if(c=='-') {
						int i2=s.lastIndexOf('-');
						boolean t2=checkValidation(s, i2);
						if(checkValidation(s, i)==false || t2==false) {
							return false;
						}
					}
				//ֻ����һ��	
				}else {
					if(checkValidation(s, i)==false) {
						return false;
					}
				}
			//�����С����	
			}else if(c=='.') {
				//С������������� ��ʼ���� ���� ��λ��
				if(i==0 || i==s.length()-1) {
					return false;
				}
			}else if(c=='E' || c=='e') {
				//�������λ���ǵ�һ�������һ��λ��
				if(i==0 || i==s.length()-1) {
					return false;
				//����������������С���㣬���	
				}else {
					int index=s.lastIndexOf('.');
					if(index>i) {
						return false;
					}
				}
			}
			
			
		}
		
		return true;
	}
	
	/**
	 * ���Ϸ���
	 * @return
	 */
	public static boolean checkValidation(String s, int pos) {
		
		//�������λ���ڵ�һ��λ��
		if(pos==0) {
			return true;
		//������ڵ�һ��λ��	
		}else {
			//���������ǰ����Ǹ��ַ�
			char c=s.charAt(pos-1);
			if(c=='e' || c=='E') {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="";
		String s1="+100";
		String s2="5e2";
		String s3="-123";
		String s4="3.1416";
		String s5="-1E-16"; //true
		
		String s6="12e";
		String s7="1a3.14";
		String s8="-+5";
		String s9="12e+4.3";
		boolean res=judgeIsFloat(s9);
		System.out.println(res);
	}

}
