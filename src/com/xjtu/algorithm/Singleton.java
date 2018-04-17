package com.xjtu.algorithm;

public class Singleton {
	private Singleton() {		
	}
	private static Singleton instance=new Singleton();
	public Singleton getInstance() {
		return instance;
	}
}
