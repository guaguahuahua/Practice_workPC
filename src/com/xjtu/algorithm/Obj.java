package com.xjtu.algorithm;

import java.util.Date;

public class Obj implements Cloneable{
	private int aInt=0;
	private Date birth=new Date();
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date date) {
		this.birth=date;
	}
	public void changeDate() {
		this.birth.setMonth(4);;
	}
	public int getAInt() {
		return aInt;
	}
	public void setAInt(int n) {
		this.aInt=n;
	}
	public void changeAInt() {
		this.aInt=1;
	}
	public Obj clone() {
		Obj obj=null;
		
		try {
			obj=(Obj) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.birth=(Date) this.getBirth().clone();
		return obj;
	}
//	public Obj clone() {
//		Obj obj=null;
//		try {
//			obj=(Obj) super.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return obj;
//	}
	
	public static void main(String []args) {
		Obj a=new Obj();
		Obj b=a.clone();
		b.changeDate();
		System.out.println("a: "+a.getBirth());
		System.out.println("b: "+b.getBirth());
//		b.changeAInt();
//		System.out.println("a: "+a.getAInt());
//		System.out.println("b: "+b.getAInt());
//		System.out.println(a==b);
//		System.out.println(a);
//		System.out.println(b);
	}
	
}
