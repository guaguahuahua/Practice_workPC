package com.xjtu.designpattern.factory;

public class SmsFactory implements AbstractFactory {

	public Sender factory() {
		return new SmsSender();
	}

}
