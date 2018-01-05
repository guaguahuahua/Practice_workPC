package com.xjtu.interview;

public class Relect{
	public static void main(String []args) {
		try {
			Class c=Class.forName("com.xjtu.interview.Sub");

			Base b=(Base) c.newInstance();
			b.f();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InstantiationException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
