package com.xjtu.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class People_1 {
	private String id;
	private String name;
	
	public People_1(String id, String name) {
		this.id=id;
		this.name=name;
	}
	//toString 方法重载
	@Override
	public String toString() {
		return id+", "+name;
	} 
	
	//hashCode方法重载
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	//equals方法重载
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof People_1)) {
			return false;
		}
		if(((People_1)obj).id.equals(this.id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String []args) {
		Map<People_1, Integer> map=new HashMap<People_1, Integer>();
		People_1 person1=new People_1("001", "zhou");
		People_1 person2=new People_1("001", "zhou");
		map.put(person1, 1);
		map.put(person2, 2);
		Set keySet=map.keySet();
		for(Iterator it=keySet.iterator(); it.hasNext(); ) {
			People_1 temp=(People_1) it.next();
			int value=map.get(temp);
			System.out.println(temp+", "+value);
		}
		
	}
}
