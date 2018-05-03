package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 找到字符串中第一个只出现一次的字符
 * @author Administrator
 *
 */
public class FindTheFirstCharAppearedOnce {

	/**
	 * 使用indexOf lastIndexOf方法来判定一个字符是否是第一次出现
	 * @param s
	 * @return 第一个出现一次字符的位置
	 */
	public static int findTheFirstCharAppearedOnce(String s) {
		
		if(s.length()==0) {
			return -1;
		}
		
		for(int i=0; i<s.length(); i++) {
			//获取当前字符
			char c=s.charAt(i);
			//如果第一次出现的位置和最好一次出现的位置相同
			if(s.indexOf(c)==s.lastIndexOf(c)) {
				System.out.println(c);
				return i;
			}
		}		
		return -1;
	}
	
	/**
	 * 使用map方法
	 * @param s
	 * @return
	 */
	public static int findTheFirstCharAppearedOnce_1(String s) {
		if(s.length()==0) {
			return -1;
		}
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		char c;
		//按照顺序得到了字符串中每个字符的顺序
		for(int i=0; i<s.length(); i++) {
			c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		//现在找到第一个出现次数为1的字符
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
