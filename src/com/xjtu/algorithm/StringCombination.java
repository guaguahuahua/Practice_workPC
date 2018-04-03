package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringCombination {

	/**
	 * ʹ�õݹ�ķ�ʽ�����ַ�������Ϸ�ʽ������
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
				//�����ǰ�ڵ�û�б����ʹ�
				if(!flag[i]) {
					tempList.add(s.charAt(i));
					//�����ʹ��Ľڵ���Ϊtrue
					flag[i]=true;
					backtrack(list, tempList, s, start, flag);
					//���˵�ʱ���޳��Ľڵ���Ϊδ����
					tempList.remove(tempList.size()-1);
					flag[i]=false;
				}
			}
		}
	}
	
	/**
	 * ʹ���ַ�����ʽ��������
	 * @param s
	 * @return
	 */
	public static List<List<String>> stringCombination_1(String s){
		char []chars=s.toCharArray();
		permutation(chars, 0, s.length()-1);
		return null;
	}
	
	public static void permutation(char []chars, int start, int end) {
		//�ݹ�ĳ���
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
	 * ������ַ��������У������˵ȳ��Ͳ��ȳ�����������
	 * ������ԭʼ�ģ�ʹ�ö�����λ�ķ�ʽ�󴮵��������
	 * @param s
	 * @return
	 */
	public static List<String> allPermutations(String s){
		//���������㴮��
		StringBuilder zeros=new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			zeros.append('0');
		}
		String zeroStr=zeros.toString();
		
		//���ȼ��������ַ������ж��ٵ�����
		int kinds=(int) Math.pow(2, s.length());
		ArrayList<String> tempList=new ArrayList<String>();
		//����Ǹ��ݶ����������ص������е�����
		for(int i=0; i<kinds; i++) {			
			String bits=Integer.toBinaryString(i);
			//���ɵĶ����ƴ��Ƚ϶�
			int delta=s.length()-bits.length();
			//���ɵĶ����ƴ�������Ȳ������в���
			if(delta!=0) {
				bits=zeroStr.substring(0, delta)+bits;
			}
			StringBuilder sb=new StringBuilder();
			//���ò��룬ֱ�Ӱ��ն����ƴ��Ĵ��������˳���������
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
	 * ʹ��λ���������е�����
	 * @param s
	 * @return
	 */
	public static List<String> allPermutations_1(String s){
		List<String> list=new ArrayList<String>();
		//�����������е�������
		int kinds=(1<<s.length());
		//�������е�����
		for(int i=0; i<=kinds; i++) {
			StringBuilder sb=new StringBuilder();
			//�����ַ���
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
		//���ȼ����������е�����
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
