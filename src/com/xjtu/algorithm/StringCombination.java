package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringCombination {

	/**
	 * 使用递归的方式进行字符串的组合方式的生成
	 * @param s
	 * @return
	 */
	public static List<List<String>> stringCombination(String s){
		List<List<String>> list=new ArrayList<List<String>>();
		boolean []flag=new boolean[s.length()];
		backtrack(list, new ArrayList(), s, 0, flag);
		
		return list;
	}
	
	public static void backtrack(List<List<String>>list, ArrayList<Character>tempList, String s, int start, boolean []flag) {
		if(tempList.size()>s.length()) {
			return;
		}else if(tempList.size()==s.length()) {
			list.add(new ArrayList(tempList));
		}else {
			for(int i=start; i<s.length(); i++) {
				//如果当前节点没有被访问过
				if(!flag[i]) {
					tempList.add(s.charAt(i));
					//将访问过的节点标记为true
					flag[i]=true;
					backtrack(list, tempList, s, start, flag);
					//回退的时候将剔除的节点标记为未访问
					tempList.remove(tempList.size()-1);
					flag[i]=false;
				}
			}
		}
	}
	
	/**
	 * 使用字符的形式进行排列
	 * @param s
	 * @return
	 */
	public static List<List<String>> stringCombination_1(String s){
		char []chars=s.toCharArray();
		permutation(chars, 0, s.length()-1);
		return null;
	}
	
	public static void permutation(char []chars, int start, int end) {
		//递归的出口
		if(start==end) {
			System.out.println(chars);
		}
		
		for(int i=start; i<=end; i++) {
			swap(chars, i, start);
			permutation(chars, start+1, end);
			swap(chars, start, i);
		}
	}
	
	public static void swap(char []chars, int i, int j) {
		char temp=chars[i];
		chars[i]=chars[j];
		chars[j]=temp;
	}
	
	/**
	 * 求给定字符串的排列，包括了等长和不等长的所有排列
	 * 这是最原始的，使用二进制位的方式求串的所有组合
	 * @param s
	 * @return
	 */
	public static List<String> allPermutations(String s){
		//首先生成零串；
		StringBuilder zeros=new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			zeros.append('0');
		}
		String zeroStr=zeros.toString();
		
		//首先计算整个字符串会有多少的排列
		int kinds=(int) Math.pow(2, s.length());
		ArrayList<String> tempList=new ArrayList<String>();
		//这块是根据二进制数的特点获得所有的排列
		for(int i=0; i<kinds; i++) {			
			String bits=Integer.toBinaryString(i);
			//生成的二进制串比较短
			int delta=s.length()-bits.length();
			//生成的二进制串如果长度不够进行补齐
			if(delta!=0) {
				bits=zeroStr.substring(0, delta)+bits;
			}
			StringBuilder sb=new StringBuilder();
			//不用补齐，直接按照二进制串的从右往左的顺序遍历即可
			for(int j=bits.length()-1; j>=0; j--) {
				if(bits.charAt(j)!='0') {
					sb.append(s.charAt(j));
				}
			}
			tempList.add(sb.toString());
		}
		
		return tempList;
	}
	
	/**
	 * 使用位运算求所有的排列
	 * @param s
	 * @return
	 */
	public static List<String> allPermutations_1(String s){
		List<String> list=new ArrayList<String>();
		//计算所有排列的种类数
		int kinds=(1<<s.length());
		//遍历所有的种类
		for(int i=0; i<=kinds; i++) {
			StringBuilder sb=new StringBuilder();
			//遍历字符串
			for(int j=0; j<s.length(); j++) {
				int t=(1<<j);
				int temp=t&i;
				if(temp!=0) {
					sb.append(s.charAt(j));
				}
			}
			list.add(sb.toString());
		}
		
		return list;
	}
	
	public static List<String> allPermutations_2(String s){
		List<String> list=new ArrayList<String>();
		//首先计算所有排列的数量
		int kinds=(1<<s.length());
		for(int kind=0; kind<kinds; kind++) {
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<s.length(); i++) {
				if(((1<<i) & kind)!=0) {
					sb.append(s.charAt(i));
				}
			}
			list.add(sb.toString());
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abc";
//		List res=stringCombination_1(s);
//		System.out.println(res);
		List res=allPermutations_2(s);
		System.out.println(res);
	}

}
