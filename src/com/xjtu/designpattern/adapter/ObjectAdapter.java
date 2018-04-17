package com.xjtu.designpattern.adapter;

public class ObjectAdapter implements Targetable{
	
	private Original ori=new Original();

	//������Ҫ���ⲿ���ݶ����������Ϊÿ�ζ�����ܻᷢ���仯
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
