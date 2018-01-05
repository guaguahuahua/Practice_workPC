package com.xjtu.interview;

import java.util.ArrayList;

public class TestAll {
	
	
	public static ArrayList<Stuff> collectStuff(Stuff []s ){
		
		ArrayList<Stuff> al=new ArrayList<Stuff>();
		
		for(int i=0; i<s.length; i++) {
			if(!(s[i] instanceof Rubbish)) {
				al.add(s[i]);
			} 
		}
		return al;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stuff[] s= {new Gold(), new Copper(), new Gun(), new Grenade(), new Stone()};
		ArrayList <Stuff>res=collectStuff(s);
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i)+" ");
		}
	}

}
