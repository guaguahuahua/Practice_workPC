package com.xjtu.designpattern.adapter;
/**
 * ����������������Ϊ�̳е����⣬�����޸ıȽ�����
 * @author Administrator
 *
 */
public class Adapter extends Original implements Targetable{
	
	public void current() {
		System.out.println("this is current");
	}
}
