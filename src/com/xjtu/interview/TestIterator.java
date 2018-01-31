package com.xjtu.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> list=new ArrayList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("forth");
		//这是个人的迭代器的遍历的方式
//		Iterator it=list.iterator();
//		while(it.hasNext()) {
//			String temp=(String) it.next();
//			System.out.println(temp);
//		}
		
		//一种新的遍历的方式
		for(Iterator it=list.iterator(); it.hasNext(); ) {
			String tmp=(String) it.next();
			System.out.println(tmp);
			//在迭代过程中向容器中添加元素会导致，原计数器值和当前元素数量不同，导致抛出异常
			if(tmp.equals("third")) {
				list.add("high five");
			}
		}
		
	}

}
