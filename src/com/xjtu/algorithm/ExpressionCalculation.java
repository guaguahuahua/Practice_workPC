package com.xjtu.algorithm;

import java.util.LinkedList;

public class ExpressionCalculation {

	/**
	 * ���ݺ�׺���ʽ����ֵ��ͨ��ջ�ķ�ʽ��ʵ��
	 * ���ʽ������ֻ�漰��������ֻ��ģ�����������Ĺ���
	 * @param str
	 * @return
	 */
	public static int expressionCalculation(String str) {
		//����������������
		String []strs=str.split("\\,");
		//ʹ��ջʵ�ֱ��ʽ��ֵ����
		LinkedList<String> stack=new LinkedList<String>();
		//�����������Ͳ�����
		for(int len=0; len<strs.length; len++) {
			//�жϵ�ǰ�Ĵ��ַ����������
			if(isNumbers(strs[len])) {
				stack.push(strs[len]);
			}else if(isSymbol(strs[len])!=-1){
				//��������
				int num=isSymbol(strs[len]);
				//��ջ�������������
				int first=Integer.parseInt(stack.pop());
				int second=Integer.parseInt(stack.pop());
				
				//�жϵ�ǰ�������ʲô
				if(num==0) {
					int temp=second+first;
					stack.push(temp+"");
				}else if(num==1){
					int temp=second-first;
					stack.push(temp+"");
				}else if(num==2) {
					int temp=second*first;
					stack.push(temp+"");
				}else if(num==3) {
					int temp=second/first;
					stack.push(temp+"");
				}
			}else {
				System.out.println("�����������");
			}
		}
		
		int res=Integer.parseInt(stack.pop());
		
		return res;
	}
	
	/**
	 * �ж�һ���ַ����Ƿ���ȫΪ����
	 * @param str
	 * @return
	 */
	public static boolean isNumbers(String str) {
		for(int i=0; i<str.length(); i++) {
			char temp=str.charAt(i);
			//����ַ������֣���ô����true
			if(temp>='0' && temp<='9') {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �ж��ַ��Ƿ�Ϊ�����
	 * @param str
	 * @return
	 */
	public static int isSymbol(String str) {
		
		if(str.equals("+")) {
			return 0;
		}else if(str.equals("-")) {
			return 1;
		}else if(str.equals("*")) {
			return 2;
		}else if(str.equals("/")){
			return 3;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="2,10,6,3,/,-,7,*,+";
//		int res=expressionCalculation(str);
//		System.out.println(res);
		
//		String s="-56";
//		System.out.println(Integer.parseInt(s));
	}

}
