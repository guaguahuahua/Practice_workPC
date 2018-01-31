package com.xjtu.interview;

import java.util.ArrayList;
import java.util.List;

public class DeleteTheCopyOfCharacter {

	/**
	 * 删除字符串中重复出现的字符
	 * 思路：使用list，只添加不在集合内的字符
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
			//如果不包含该字符，那么添加到集合中去
			if(! list.contains(temp)) {
				list.add(s.charAt(i));
			}
		}
		//将集合中筛选过的字符转化为字符串
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 使用字符数组的方式处理重复问题
	 * @param s
	 * @return String 
	 */
	private static String deleteTheCopyOfCharacter_1(String s) {
		//将字符串转化为字符数组
		char []c=s.toCharArray();
		//映射到hash表中（数组应该已经完成了初始化的过程，因为是基本类型）
		int []table=new int[256];
		//遍历整个字符数组，并将字符数中的字符映射到hash表中去，如果当前映射的位置已经有元素存在
		//那么认为当前字符是重复元素，将它置为空字符；
		for(int i=0; i<c.length; i++) {
			int index=c[i];
			if(table[index]!=0) {
				c[i]='\0';
			}else {
				table[index]=1;
			}
		}
		//遍历字符数组，将非空字符的元素进行平移操作
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
