package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * ȡ�ַ����е�һ�����ظ����ַ�
 * @author Administrator
 *
 */
public class FirstNoRepeatedChar {

	/**
	 * ʹ��mapʵ�֣���¼ÿһ���ַ����ִ����������ǰ�ַ�c���ִ���Ϊ0����ô��Ϊ�ǲ��ظ��ַ�
	 * ͬʱ��c�ĳ��ִ���+1����д�뵽map��ȥ�����ǰ���ֵ��ַ�c�Ĵ�������0����ô��Ϊ���ظ�
	 * ���ַ������ء�#��
	 * @param s
	 * @return
	 */
	public static char firstNoRepeatedChar(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			int times=map.getOrDefault(c, 0);
			if(times==0) {
				System.out.println(c);
				map.put(c, ++times);
			}else {
				System.out.println('#');
			}	
		}
		return '#';
	}
	
	/**
	 * ʹ���������ʽ����Ϊ�ַ��ķ�Χ���ޣ������������б��ÿ���ַ����ִ���Ϊ0��
	 * �����ʸ��ַ�λ�õ�ʱ�ķ���ֵΪ0����ô��Ϊ��һ�γ��֣�������ַ���������λ��+1
	 * 
	 * @param s
	 * @return
	 */
	public static char firstNoRepeatedChar_1(String s) {
		
		byte []table=new byte[65535];
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//���Ϊ0����ô��Ϊ�ǵ�һ�γ���
			if(table[c]==0) {
				System.out.println(c);
				table[c]++;
			}else {
				System.out.println('#');
			}
		}
		return '#'; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="google";
		firstNoRepeatedChar_1(s);
	}

}
