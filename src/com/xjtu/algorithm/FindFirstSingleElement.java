package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ѱ���ַ����г��ֵĵ�һ�����ظ���Ԫ�ص��㷨���ַ����ĳ����й�
 * @author Administrator
 *
 */
public class FindFirstSingleElement {

	/**
	 * �ҵ��ַ����е�һ��ֻ����һ�ε��ַ�
	 * ʹ��˫��forѭ��,ʱ�临�Ӷ�O(n^2)
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
			//����ж����е��ַ���û����ͬ�ģ�ֱ�ӷ���
			if(!flag) {
				return s.charAt(i);
			}
		}
		//���������Ҳû�У���ô���ؿ��ַ�
		return ' ';
	}
	
	/**
	 * ʹ��O(n)ʱ�临�Ӷ�ʵ��
	 * �������ʹ�õ�һ�κ����һ�γ��ֵ�λ�ã������һ�������һ�γ��ֵ�λ����ͬ����ô���ǵ���Ԫ��
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
	 * ��黹��һ��O(2n)�ķ�����ʹ��hashmap�ķ�ʽ
	 * ����hashmap�еļ���ȡ������ʱ��������ģ����Զ������Ŀ�����ǲ����õ�
	 * ����������ʵ�ʵĹ����в���ȡ��hashmap�е����м���Ҳ�Ͳ��ᵼ�����յ�����
	 * ����ֱ������ԭ���Ĳ���Ļ�����Ѱ�Ҽ���
	 * @param s
	 * @return
	 */
	public static char findFirstSingleElement_2(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		//���ÿ���ַ��������ִ�����ӳ��
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		//Ѱ�ҵ�һ���ַ��Ĵ���Ϊ1���ַ�
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			if(map.get(c)==1) {
				return c;
			}
		}
		return ' ';
	}
	
	/**
	 * �����Ҫȡ��map�е�Ԫ�����жϵ�һ�����ظ���Ԫ��
	 * @param s
	 * @return
	 */
	public static char findFirstSingleElement_3(String s) {
		
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		//��һ�α����ַ�����ȷ��ÿ���ַ��ĳ��ִ���
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
//		//��δ�map��Ѱ�ҵ�һ���ǿյ�Ԫ��
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
