package com.xjtu.algorithm;

public class ReplaceSpace {

	/**
	 * ʹ�ø�����pattern���滻�ַ����пո�
	 * @param str
	 * @param pattern
	 */
	public static void replace(String str, String pattern) {
		
		String res="";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==' ') {
				res=res+pattern;
			}else {
				res=res+str.charAt(i);
			}
		}
//		str.replaceAll("\\s+", pattern);
		System.out.println("ԭʼ��"+str);
		System.out.println("�޸ģ�"+res);
	}
	
	public static void replace_1(String str, String pattern) {
		
		String []strs=str.split("\\^+"); 
		String res="";
		for(int i=0; i<strs.length; i++) {
			res=res+strs[i]+pattern;
		}
		System.out.println("ԭʼ��"+str);
		System.out.println("�޸ģ�"+res);
//		str.replace(" ", "^^");
//		str.replaceAll(" ", "^^");
//		System.out.println(str);		
	}
	
	/**
	 * ͳ��һ�еĵ�����Ŀ
	 * @param str
	 * @return
	 */
	public static int countWords(String str) {
		
		int count=0;
		for(int i=1; i<str.length(); i++) {
			char pre=str.charAt(i-1);
			char cur=str.charAt(i);
			if(pre>='a' && pre<='z' || pre>='A' && pre<='Z') {
				if(cur==' ') {
					count++;
				}
			}
		}
		return count+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="we  are   happy";
		String pattern=" ";
//		replace_1(str, pattern);
		int res=countWords(str);
		System.out.println(res);
	}
}
