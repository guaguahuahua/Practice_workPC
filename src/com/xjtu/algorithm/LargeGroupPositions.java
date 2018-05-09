package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * 返回字符串中相同字符的数量超过等于3个字符的位置，如果没有，那么返回空
 * @author Administrator
 *
 */
public class LargeGroupPositions {
	
	/**
	 * o(n)直接遍历，设置两个游标
	 * @param S
	 * @return
	 */
    public static List<List<Integer>> largeGroupPositions(String s) {
    	List<List<Integer>> list=new ArrayList();
    	if(s.length()<=2) {
    		return list;
    	}
    	int left=0;
    	int right=1;
    	int count=1;
    	while(right<s.length()) {
    		List<Integer> l=new ArrayList();
    		if(s.charAt(left)==s.charAt(right)) {
    			 count++;
    		}else {
    			if(count>=3) {
    				l.add(left);
    				l.add(right-1);
    				list.add(l);
    				count=1;
    				left=right;
    			}else {
    				left=right;
    				count=1;
    			}
    		}
			right=right+1;
    	}
    	if(count>2) {
    		List<Integer> l=new ArrayList();
    		l.add(left);
    		l.add(right-1);
    		list.add(l);
    	}
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="abbxxxxzzy";
//		String s="aaaaaaaa";
//		String s="abcdddeeeeaabbbcd";
//		String s="abbb";
		String s="bababbabaa";
		List res=largeGroupPositions(s);
		System.out.println(res);
	}

}
