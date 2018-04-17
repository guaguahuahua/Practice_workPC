package com.xjtu.designpattern.adapter;
/**
 * 类适配器，但是因为继承的问题，导致修改比较困难
 * @author Administrator
 *
 */
public class Adapter extends Original implements Targetable{
	
	public void current() {
		System.out.println("this is current");
	}
}
