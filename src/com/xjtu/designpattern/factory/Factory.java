package com.xjtu.designpattern.factory;
/**
 * 简单工厂模式
 * @author Administrator
 *
 */
public class Factory {
	
	public Sender factory(String str) {
		if(str.equals("sms")) {
			return new SmsSender();
		}else if(str.equals("email")) {
			return new EmailSender();
		}else {
			System.out.println("字符串有误！");
			return null;	
		}		
	}
	
	public static void main(String []args) {
		Factory factory=new Factory();
		Sender sender=factory.factory("email");
		sender.send();
	}
	
}
