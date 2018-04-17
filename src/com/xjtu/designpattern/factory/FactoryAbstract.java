package com.xjtu.designpattern.factory;
/**
 * ²âÊÔ ³éÏó¹¤³§
 * @author Administrator
 *
 */
public class FactoryAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sender sender=new EmailSender();
		sender.send();
	}

}
