package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TEmp{

    public static void main(String[] args){	
    	Scanner scanner=new Scanner(System.in);
    	String number=scanner.nextLine();
    	int cn=scanner.nextInt();
    	
    	char[] ch=number.toCharArray();
    	List<Character> list=new ArrayList<Character>();
    	List<Character> list1=new ArrayList<Character>();
		
    	for(int i=0;i<ch.length;i++){
    		list.add(ch[i]);
    		list1.add(ch[i]);
    	}
  
    	Collections.sort(list,new Comparator<Character>(){

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				Character s1=Character.valueOf(o1);
				Character s2=Character.valueOf(o2);
				return (s1).compareTo(s2);
			}
    	});
    	
    	for(int i=0;i<cn;i++) {
    		for(int j=list1.size()-1;j>=0;j--) {
    			if(list1.get(j)==list.get(i)){
    				list1.remove(list.get(i));
    				break;
    			}
    		}   			
    	}

    	
    	for(int i=0;i<list1.size();i++){
    		System.out.print(list1.get(i));
    	}
    	
 }

}
