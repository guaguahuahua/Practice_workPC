package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	/**
	 * 使用字符串的lastIndexOf方法来实现 
	 * @param S
	 * @return	List<Integer>	返回每个字符串的长度序列
	 */
    public static List<Integer> partitionLabels(String S) {
    	int max=0;
    	int preIndex=0;
    	List<Integer> list=new ArrayList<Integer>();
    	
    	for(int i=0; i<S.length(); ) {
    		char c0=S.charAt(i);
    		max=S.lastIndexOf(c0);
    		
    		while(i<=max) {
    			char c=S.charAt(i);
    			//如果字符第一次出现位置和最后一次出现位置不一样
    			if(i!=S.lastIndexOf(c)) {
    				if(S.lastIndexOf(c)>max) {
    					max=S.lastIndexOf(c);
    				}
    				i++;    				
    			//如果当前位置和最后一次出现的位置相等	
    			}else {
    				//首先判断相比于最大的索引值
    				if(i<max) {
    					i++;
    				//就是最大的元素所在的最后位置	
    				}else if(i==max){
    					int len=i-preIndex+1;
    					list.add(len);
    					i++;
    					preIndex=i;
    				}
    			}
    		}
    	}
        return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="ababcbacadefegdehijhklij";
//		String s="basebajijikjillllpplplplp";
		String s="a";
		List res=partitionLabels(s);
		System.out.println(res);
		
	}

}
