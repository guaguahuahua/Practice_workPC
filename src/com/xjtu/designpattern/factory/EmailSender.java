package com.xjtu.designpattern.factory;

public class EmailSender implements Sender{
	public void send() {
		System.out.println("this is email sender!");
	}
}
