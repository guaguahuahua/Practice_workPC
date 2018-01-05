package com.xjtu.interview;

import java.util.StringTokenizer;

public class People {
	private String name;
	private String sex;
	private int age;
	
	public People(String name, String sex, int age) {
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return this.name+", "+this.sex+", "+this.age;
	}
	@Override
	public boolean equals(Object obj) {
		//如果该对象不为空
		if(obj!=null) {
			//如果比较对象是同一个类的实例
			if(obj instanceof People) {
				//如果比较的两个对象的所有属性的值完全一致
				if(((People) obj).name.equals(this.name) && ((People) obj).sex.equals(this.sex) && ((People) obj).age==this.age) {
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		People person=new People("dante", "male", 25);
//		People person1=new People("wangjun", "male", 24);
//		System.out.println(person);
//		System.out.println(person1);
//		System.out.println(person.equals(new People("dante", "male", 25)));
//		String s="";
//		StringBuffer sbf=new StringBuffer(s);
//		sbf.append("I am dante");
//		System.out.println(sbf.toString());
//		
//		String s1="";
//		StringBuilder sbd=new StringBuilder(s1);
//		sbd.append("Sometimes I am feeling uncomfortable, beacause I have lots of problems");
//		System.out.println(sbd.toString());
//		
//		//这个字符串切分类好像是对空格有效
//		String s2="欢、 迎、 来、 指、     导";
//		StringTokenizer st=new StringTokenizer(s2, "、");
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
//		float []a =new float[3];
//		double []b=new double[3];
//		char []c=new char[3];
//		People []p=new People[3];
//		int []a1;
//		a1=new int[] {};
//		System.out.println(a[0]);
//		System.out.println(b[0]);
//		System.out.println(c[0]);
//		System.out.println(p[0]);
		
//		int [][]aa =new int[2][];
//		aa[0]= new int[]{1, 2};
//		aa[1]=new int[] {2, 3, 4};
		
		int []a = null;
		a[0]=0;
		a[1]=1;
		a[2]=2;
		System.out.println(a[2]);
	}

}
