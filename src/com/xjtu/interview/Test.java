package com.xjtu.interview;

/**
 * ��Ҫ����˵����β鿴���������
 * һ��أ����ʹ��getClass�ķ���ֻ�ܻ�õ�ǰ��������������޷���ø����������
 * �����Ҫ��ø��������������Ҫʹ��getClass().getSuperClass().getName()
 * @author Administrator
 *
 */
public class Test extends Base{
	//���ַ�ʽ�޷���ø�������
	public void test() {
		System.out.println(super.getClass().getName());
	}
	//���ַ�ʽ���Ի�ø��������
	public void BaseName() {
		System.out.println(this.getClass().getSuperclass().getName());
	}
	
	/**
	 * ��������ķ���
	 * @param args 
	 */
	public static void main(String []args) {
		//��Ϊ�Ƕ������Կ���ֱ�ӵ��ø���ķǾ�̬����
//		new Test().test();
//		new Test().BaseName();
		
		float pi=3.14F;
		System.out.println(pi);
	}
}
