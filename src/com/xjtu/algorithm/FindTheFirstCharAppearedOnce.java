package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * �ҵ��ַ����е�һ��ֻ����һ�ε��ַ�
 * @author Administrator
 *
 */
public class FindTheFirstCharAppearedOnce {

	/**
	 * ʹ��indexOf lastIndexOf�������ж�һ���ַ��Ƿ��ǵ�һ�γ���
	 * @param s
	 * @return ��һ������һ���ַ���λ��
	 */
	public static int findTheFirstCharAppearedOnce(String s) {
		
		if(s.length()==0) {
			return -1;
		}
		
		for(int i=0; i<s.length(); i++) {
			//��ȡ��ǰ�ַ�
			char c=s.charAt(i);
			//�����һ�γ��ֵ�λ�ú����һ�γ��ֵ�λ����ͬ
			if(s.indexOf(c)==s.lastIndexOf(c)) {
				System.out.println(c);
				return i;
			}
		}		
		return -1;
	}
	
	/**
	 * ʹ��map����
	 * @param s
	 * @return
	 */
	public static int findTheFirstCharAppearedOnce_1(String s) {
		if(s.length()==0) {
			return -1;
		}
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		char c;
		//����˳��õ����ַ�����ÿ���ַ���˳��
		for(int i=0; i<s.length(); i++) {
			c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		//�����ҵ���һ�����ִ���Ϊ1���ַ�
		for(int i=0; i<s.length(); i++) {
			c=s.charAt(i);
			if(map.get(c)==1) {
				System.out.println(c);
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="i love china";
		int res=findTheFirstCharAppearedOnce_1(s);
		System.out.println(res);
	}

}
