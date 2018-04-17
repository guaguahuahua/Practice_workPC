package com.xjtu.designpattern.observer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observer1 o1=new Observer1();
		Observer2 o2=new Observer2();
		
		MySubject my=new MySubject();
		my.add(o1);
		my.add(o2);
		my.operation();
	}

}
