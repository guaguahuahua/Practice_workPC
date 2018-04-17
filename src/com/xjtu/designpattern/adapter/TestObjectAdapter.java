package com.xjtu.designpattern.adapter;

public class TestObjectAdapter {

	public static void main(String []args) {		
		Original ori=new Original();
		ObjectAdapter oa=new ObjectAdapter(ori);
		oa.original();
		oa.current();
	}
	
}
