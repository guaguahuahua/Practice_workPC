package com.xjtu.interview;

public class TestAssert {
	//���ǶԵ���ģʽ��һ��ʾ��
	private static final TestAssert oneAssert=null;
	//���췽����˽�У���֤����ֻ��һ������
	private TestAssert() {}
	//��ȡ������󣬹��з������ⲿ�ӿڿ���ʹ�ø÷������һ���������
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
