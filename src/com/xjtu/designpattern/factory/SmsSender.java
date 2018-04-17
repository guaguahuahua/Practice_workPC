package com.xjtu.designpattern.factory;

public class SmsSender implements Sender{

	public void send() {
		System.out.println("this is sms sender");
	}
}
