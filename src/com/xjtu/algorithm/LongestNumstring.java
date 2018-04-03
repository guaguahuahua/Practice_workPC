package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LongestNumstring {

	/**
	 * Ѱ���ַ�����������ִ������������ִ��Ŀ�ʼ�����ͳ���
	 * @param s
	 * @return
	 */
	public static List<Integer> longestNumstring(String s){
		
		int len=0;
		boolean flag=false;
		//��¼��ַ������ȵı���
		int max=Integer.MIN_VALUE;
		//��¼����Ŀ�ʼ����
		int index=-1;
		
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//����ҵ��������ַ�����ô��Ҫ��¼��ʼ�����ʹ��ĳ���
			if(c>='0' && c<='9') {
				len++;
				flag=true;
			}else {
				if(flag) {
					//�������ֵ���Լ���Ӧ���±�
					if(max<len) {
						max=len;
						index=i-len;
					}					
					//����
					len=0;
				}
			}
		}
		if(flag && max<len) {
			max=len;
			index=s.length()-len+1;
		}
		List<Integer> res=new ArrayList<Integer>();
		res.add(index);
		res.add(max);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcd12345ed123456789";
		List res=longestNumstring(s);
		System.out.println("��ʼλ�ã�"+res.get(0)+", "+"���ĳ��ȣ�"+res.get(1));
	}

}
