package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 取字符流中第一个不重复的字符
 * @author Administrator
 *
 */
public class FirstNoRepeatedChar {

	/**
	 * 使用map实现，记录每一个字符出现次数，如果当前字符c出现次数为0，那么认为是不重复字符
	 * 同时将c的出现次数+1，并写入到map中去如果当前出现的字符c的次数超过0，那么认为是重复
	 * 的字符，返回‘#’
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
	 * 使用数组的形式，因为字符的范围有限，我们在数组中标记每个字符出现次数为0，
	 * 当访问该字符位置的时的返回值为0，那么认为第一次出现，并输出字符，将它的位置+1
	 * 
	 * @param s
	 * @return
	 */
	public static char firstNoRepeatedChar_1(String s) {
		
		byte []table=new byte[65535];
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//如果为0，那么认为是第一次出现
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
