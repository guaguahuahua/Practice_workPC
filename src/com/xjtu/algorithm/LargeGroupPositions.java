package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * �����ַ�������ͬ�ַ���������������3���ַ���λ�ã����û�У���ô���ؿ�
 * @author Administrator
 *
 */
public class LargeGroupPositions {
	
	/**
	 * o(n)ֱ�ӱ��������������α�
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
