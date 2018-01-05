package com.xjtu;


class TestMain{
	public static void main(String []args) {
		System.out.println("Test.main");
	}
}
public class TestMainMethod {
	
	public static void main(String []args) {
		System.out.println(args.length);
		for(int i=0; i<args.length; i++) {
			System.out.print(args[i]+"\t");
		}
		System.out.println();
	}

}
