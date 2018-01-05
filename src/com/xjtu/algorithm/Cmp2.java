package com.xjtu.algorithm;

public class Cmp2 implements IntCompare{

	@Override
	public int compare(int a, int b) {
		if(a>b) {
			return -1;
		}else if(a<b){
			return 1;
		}else {
			return 0;
		}
	}
}
