package com.xjtu.designpattern.factory;

public class EmailFactory implements AbstractFactory{
	
	public Sender factory() {
		return new EmailSender();
	}
}
