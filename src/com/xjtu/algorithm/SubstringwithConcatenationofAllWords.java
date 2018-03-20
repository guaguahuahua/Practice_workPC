package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	
	
	private static ArrayList<String> permu=new ArrayList<String>();
	/**
	 * 原始思路，直接求所有字符的排列，然后在s中进行搜索，最终TLE
	 * @param s
	 * @param words
	 * @return
	 */
    public static List<Integer> findSubstring_1(String s, String[] words) {
    	//存放位置
    	List<Integer> res=new ArrayList<Integer>();
    	//首先根据words数组中的元素获得他们所有的全排列
    	permutation(words, 0, words.length-1);
    	for(int i=0; i<permu.size(); i++) {
    		//获得一个字符串的排列
    		String temp=permu.get(i);
    		int index=0;
    		//在字符串s中寻找是否有相同项
    		int tIndex=0;
    		for(int j=0; j<=s.length()-temp.length(); j++) {
    			int k, jj=j;
    			for(k=0; k<temp.length(); k++) {
    				if(s.charAt(jj)!=temp.charAt(k)) {
    					break;
    				}
    				jj++;
    			}
    			if(k==temp.length() && !res.contains(j)) {
    				res.add(j);
    			}
    		}    		    		
    	}
        return res;
    }
    
	public static void permutation(String []words, int start, int end) {
		
		if(start==end) {
			StringBuilder sb=new StringBuilder();
			//将整个排列的结果存放起来
			for(int i=0; i<words.length; i++) {
				sb.append(words[i]);
			}
			//将一个排序结果存放在数组中
			permu.add(sb.toString());
		}else {
			for(int i=start; i<=end; i++) {
				swap(words, i, start);
				permutation(words, start+1, end);
				swap(words, start, i);
			}
		}	
	}
	
    public static void swap(String []words, int i, int j) {
    	String temp=words[i];
    	words[i]=words[j];
    	words[j]=temp;
    }
    
    
    /**
     * 思路：这是leetcode社区的代码
     * 使用两个Map来实现
     * 刚刚知道，题目里面有个隐藏的条件，就是所有的字符串长度和第一个长度是一样的
     * @param s	String	
     * @param words	String []
     * @return	List<Integer>
     */
    public static List<Integer> findSubstring(String s, String[] words) {
    	
    	//建立映射
    	Map <String, Integer>map=new HashMap<String, Integer>();
    	for(String str : words) {
    		map.put(str, map.getOrDefault(str,0)+1);
    	}
    	//存放匹配的开始索引
    	List<Integer> res=new ArrayList<Integer>();
    	//第一个单词的长度
    	int len=words[0].length();
    	
    	//在s中进行查询
    	for(int i=0; i<=s.length()-words.length*len; i++) {
    		//初始化一个内部的map
    		Map <String, Integer>inner=new HashMap<String, Integer>(map);
    		//用来记录是否遍历完所有的排列
			int count=words.length;
			int index=i;
    		//依次的从s中取出单词和排列中元素进行比较,每次向后移动1个单词
    		for( ;count>0; ) {
    			//获得一个字符串
    			String temp=s.substring(index, index+len);
    			//如果匹配
    			if(inner.containsKey(temp) && inner.get(temp)>0) {
    				inner.put(temp, inner.get(temp)-1);
    				count--;
    				index+=len;
    			}else {
    				break;
    			}    			
    		}
    		if(count==0) {
    			res.add(i);
    		}    		
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="barfoothefoobarman";
//		String s="barfoofoobarthefoobarman";
//		String []words= {"bar", "foo", "the"};
		String s="wordgoodgoodgoodbestword";
		String []words= {"word", "good", "best", "good"};
				
		List<Integer> res=findSubstring(s, words);
		System.out.println(res);
//		for(int K:res) {
//			System.out.println(K);
//		}

		
	}

}
