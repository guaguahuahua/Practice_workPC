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
		//���Ǹ��˵ĵ������ı����ķ�ʽ
//		Iterator it=list.iterator();
//		while(it.hasNext()) {
//			String temp=(String) it.next();
//			System.out.println(temp);
//		}
		
		//һ���µı����ķ�ʽ
		for(Iterator it=list.iterator(); it.hasNext(); ) {
			String tmp=(String) it.next();
			System.out.println(tmp);
			//�ڵ��������������������Ԫ�ػᵼ�£�ԭ������ֵ�͵�ǰԪ��������ͬ�������׳��쳣
			if(tmp.equals("third")) {
				list.add("high five");
			}
		}
		
	}

}
