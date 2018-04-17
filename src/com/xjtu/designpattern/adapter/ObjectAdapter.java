package com.xjtu.designpattern.adapter;

public class ObjectAdapter implements Targetable{
	
	private Original ori=new Original();

	//这里需要从外部传递对象进来，因为每次对象可能会发生变化
	public ObjectAdapter(Original ori) {
		this.ori=ori;
	}
	
	@Override
	public void original() {
		// TODO Auto-generated method stub
		ori.original();
	}

	@Override
	public void current() {
		// TODO Auto-generated method stub
		System.out.println("this is current");
	}
	
}
