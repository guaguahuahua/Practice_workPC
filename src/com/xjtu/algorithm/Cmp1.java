package com.xjtu.algorithm;

public class Cmp1 implements IntCompare{

	@Override
	public int compare(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b) {
			return 1;
		}else if(a<b) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
