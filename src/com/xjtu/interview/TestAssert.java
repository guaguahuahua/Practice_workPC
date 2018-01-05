package com.xjtu.interview;

public class TestAssert {
	//这是对单例模式的一个示例
	private static final TestAssert oneAssert=null;
	//构造方法，私有，保证该类只有一个对象
	private TestAssert() {}
	//获取该类对象，公有方法，外部接口可以使用该方法获得一个该类对象；
	public TestAssert getInstance() {
		return new TestAssert();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assert 1+1==2;
		System.out.println("assert1 ok");
		assert 1+1==3 : "assert2 failed ! ";
		System.out.println("assert2 ok");
	}

}
