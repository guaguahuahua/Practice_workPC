package com.xjtu.interview;

/**
 * 主要是想说明如何查看父类的类名
 * 一般地，如果使用getClass的方法只能获得当前运行类的类名，无法获得父类的类名，
 * 如果想要获得父类的类名，就需要使用getClass().getSuperClass().getName()
 * @author Administrator
 *
 */
public class Test extends Base{
	//这种方式无法获得父类类名
	public void test() {
		System.out.println(super.getClass().getName());
	}
	//此种方式可以获得父类的类名
	public void BaseName() {
		System.out.println(this.getClass().getSuperclass().getName());
	}
	
	/**
	 * 测试上面的方法
	 * @param args 
	 */
	public static void main(String []args) {
		//因为是对象，所以可以直接调用父类的非静态方法
//		new Test().test();
//		new Test().BaseName();
		
		float pi=3.14F;
		System.out.println(pi);
	}
}
