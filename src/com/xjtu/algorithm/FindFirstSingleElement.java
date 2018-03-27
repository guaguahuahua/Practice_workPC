package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 寻找字符串中出现的第一个不重复的元素的算法与字符串的长度有关
 * @author Administrator
 *
 */
public class FindFirstSingleElement {

	/**
	 * 找到字符串中第一个只出现一次的字符
	 * 使用双层for循环,时间复杂度O(n^2)
	 * @param s
	 * @return
	 */
	public static char findFirstSingleElement(String s) {
		for(int i=0; i<s.length(); i++) {
			boolean flag=false;
			for(int j=s.length()-1; j>i; j--) {
				if(s.charAt(i)==s.charAt(j)) {
					flag=true;
					break;
				}
			}
			//如果判断所有的字符都没有相同的，直接返回
			if(!flag) {
				return s.charAt(i);
			}
		}
		//如果遍历完也没有，那么返回空字符
		return ' ';
	}
	
	/**
	 * 使用O(n)时间复杂度实现
	 * 这里可以使用第一次和最后一次出现的位置，如果第一个和最后一次出现的位置相同，那么就是单个元素
	 * @param s
	 * @return
	 */
	public static char findFirstSingleElement_1(String s) {
		for(int i=0; i<s.length(); i++) {
			char t=s.charAt(i);
			if(s.indexOf(t)==s.lastIndexOf(t)) {
				return t;
			}
		}
		return ' ';
	}
	
	/**
	 * 这块还有一个O(2n)的方法，使用hashmap的方式
	 * 由于hashmap中的键，取出来的时候是乱序的，所以对这道题目来讲是不适用的
	 * 但是我们在实际的过程中不用取出hashmap中的所有键，也就不会导致最终的乱序
	 * 我们直接在它原来的插入的基础上寻找即可
	 * @param s
	 * @return
	 */
	public static char findFirstSingleElement_2(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		//获得每个字符和它出现次数的映射
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		//寻找第一个字符的次数为1的字符
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			if(map.get(c)==1) {
				return c;
			}
		}
		return ' ';
	}
	
	/**
	 * 如果需要取出map中的元素来判断第一个非重复的元素
	 * @param s
	 * @return
	 */
	public static char findFirstSingleElement_3(String s) {
		
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		//第一次遍历字符串，确定每个字符的出现次数
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
//		//这次从map中寻找第一个非空的元素
//		Set<Character> keySet=map.keySet();
//		Iterator it=keySet.iterator();
//		while(it.hasNext()) {
//			char c=(Character) it.next();
//			if(map.get(c)==1) {
//				return c;
//			}
//		}
		for(Entry<Character, Integer>entry : map.entrySet()) {
			if(entry.getValue()==1) {
				return entry.getKey();
			}
		}
		
		return ' ';
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="abaccdeff";
		String s="swiss";
		char c=findFirstSingleElement_3(s);
		System.out.println(c);
	}

}
