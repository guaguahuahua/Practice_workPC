package com.xjtu.interview;

import java.util.ArrayList;
import java.util.List;

public class DeleteTheCopyOfCharacter {

	/**
	 * ɾ���ַ������ظ����ֵ��ַ�
	 * ˼·��ʹ��list��ֻ��Ӳ��ڼ����ڵ��ַ�
	 * @param s
	 * @return String
	 */
	private static String deleteTheCopyOfCharacter(String s) {
		if(s.length()==0) {
			return "";
		}
		List<Character> list=new ArrayList<Character>();
		for(int i=0; i<s.length(); i++) {
			char temp=s.charAt(i);
			//������������ַ�����ô��ӵ�������ȥ
			if(! list.contains(temp)) {
				list.add(s.charAt(i));
			}
		}
		//��������ɸѡ�����ַ�ת��Ϊ�ַ���
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * ʹ���ַ�����ķ�ʽ�����ظ�����
	 * @param s
	 * @return String 
	 */
	private static String deleteTheCopyOfCharacter_1(String s) {
		//���ַ���ת��Ϊ�ַ�����
		char []c=s.toCharArray();
		//ӳ�䵽hash���У�����Ӧ���Ѿ�����˳�ʼ���Ĺ��̣���Ϊ�ǻ������ͣ�
		int []table=new int[256];
		//���������ַ����飬�����ַ����е��ַ�ӳ�䵽hash����ȥ�������ǰӳ���λ���Ѿ���Ԫ�ش���
		//��ô��Ϊ��ǰ�ַ����ظ�Ԫ�أ�������Ϊ���ַ���
		for(int i=0; i<c.length; i++) {
			int index=c[i];
			if(table[index]!=0) {
				c[i]='\0';
			}else {
				table[index]=1;
			}
		}
		//�����ַ����飬���ǿ��ַ���Ԫ�ؽ���ƽ�Ʋ���
		int count=0;
		for(int i=0; i<c.length; i++) {
			if(c[i]!='\0') {
				c[count++]=c[i];
			}
		}
		String str=new String(c, 0,count);
		System.out.println(str);
		return str;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="good";
//		String s="abcaabcd";
		deleteTheCopyOfCharacter_1(s);
	}

}
