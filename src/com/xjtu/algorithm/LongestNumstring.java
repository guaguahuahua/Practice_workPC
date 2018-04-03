package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LongestNumstring {

	/**
	 * 寻找字符串中最长的数字串，并给出数字串的开始索引和长度
	 * @param s
	 * @return
	 */
	public static List<Integer> longestNumstring(String s){
		
		int len=0;
		boolean flag=false;
		//记录最长字符串长度的变量
		int max=Integer.MIN_VALUE;
		//记录最长串的开始索引
		int index=-1;
		
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//如果找到了数字字符，那么就要记录起始索引和串的长度
			if(c>='0' && c<='9') {
				len++;
				flag=true;
			}else {
				if(flag) {
					//更新最大值，以及对应的下标
					if(max<len) {
						max=len;
						index=i-len;
					}					
					//重置
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
		System.out.println("开始位置："+res.get(0)+", "+"串的长度："+res.get(1));
	}

}
