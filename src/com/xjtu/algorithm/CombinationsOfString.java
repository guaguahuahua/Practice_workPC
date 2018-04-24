package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * �����ַ�������ַ������������
 * @author Administrator
 *
 */
public class CombinationsOfString {

	public static List<List<String>> combinationsOfString(String s) {
		List<List<String>> list=new ArrayList<>();
		boolean []flag=new boolean[s.length()];
//		System.out.println(flag[0]);
		backtrack(s, new ArrayList<String>(), 0, list, flag);
		return list;
	}
	
	/**
	 * ��Ҫ�����ظ������
	 * @param s
	 * @param tempList
	 * @param start
	 * @param list
	 * @param flag
	 */
	public static void backtrack(String s, List<String> tempList, int start, List<List<String>> list, boolean []flag) {
		if(tempList.size()==s.length()) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).equals(tempList)) {
					return;
				}
			}
			list.add(new ArrayList<String>(tempList));
		}else {
			for(int i=start; i<s.length(); i++) {
				if(flag[i]==false) {
					tempList.add(s.charAt(i)+"");
					flag[i]=true;
					//ÿ�α����ӵ�һ��Ԫ�ؿ�ʼ
					backtrack(s, tempList, start, list, flag);
					tempList.remove(tempList.size()-1);
					flag[i]=false;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aabc";
		List<List<String>> res=combinationsOfString(s);
		System.out.println(res.size()+","+res);
		
	}
}
