package com.xjtu.interview;

public class Derived extends Base{
	
	public int i=2;
	public float f() {
		return (float) 1.0;
	}
	
	public static void main(String []args) {
		Base b=new Derived();
		System.out.println(b.i);
	}
}



