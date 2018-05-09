package com.xjtu.algorithm;

public class ReplaceSpace_1 {

    public static String replaceSpace_1(String str) {
        if(str.length()==0){
            return null;
        }
        String s=str.toString();
    	String []strs=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<strs.length; i++){
            sb.append(strs[i]+"%20");
        }
        String res=sb.toString().substring(0, sb.toString().length()-3);
        return res;
    }
	
    public static String replaceSpace(String str) {
        StringBuilder sb=new StringBuilder();
        String replace="%20";
        String s=str.toString();
        String res=s.replaceAll("\\s", replace);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="we are  happy ";
		String rs=replaceSpace(s);
		System.out.println(rs);
		StringBuffer sb=new StringBuffer(s);
		for(int i=0; i<sb.length(); i++) {
			System.out.println(sb.charAt(i));
		}
	}

}
