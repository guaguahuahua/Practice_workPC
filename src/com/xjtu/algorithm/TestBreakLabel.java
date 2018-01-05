package com.xjtu.algorithm;

public class TestBreakLabel {

	/**
	 * 测试使用标签的形式实现break，实际上continue也是可以使用标签的，
	 * 但是这两种情况使用标签都是需要在循环体内实现的。
	 * @param args
	 */
	public static void main(String []args) {
		
out:	for(int i=0; i<5; i++) {
			for(int j=0; j<7; j++) {
				if(i>3) {
					break out;
				}	
			}
		}
	}
}
