package com.xjtu.interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortedMap {

	/**
	 * ���Կ�ͬ����mapӳ�䣬ʹ��hashMap
	 */
	private static void testSyncronizedMap() {
		//��ʱ�õ���map�ǿ�ͬ����mapӳ�䣬���̰߳�ȫ��
		Map<String, Integer> map=Collections.synchronizedMap(new HashMap<String, Integer>());
		map.put("d", 1);
		map.put("a", 2);
		map.put("b", 3);
		map.put("c", 4);
		map.put("e", 5);
		map.hashCode();
		Set keySet=map.keySet();
		for(Iterator it=keySet.iterator(); it.hasNext(); ) {
			String key=(String) it.next();
			int value=map.get(key);
			System.out.println(key+", "+value);
		}
	}
		
	/**
	 * ���������map treeMap
	 * Ҳ����˵��treemap�Բ���ļ�ֵ�԰��ռ�keyֵ����������
	 * �����ڻ�ȡ�õ���keyset�м���˳��Ҳ�ǽ��й�����ģ�����treeMap�ʺ�����˳���
	 * ���ϣ���������������̻�Ӱ��Ч�ʣ�����û��˳��������ʱ�򣬻���ʹ������hashmap����map
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSyncronizedMap();
		String s="can";
		s.equals("canteen");
		
/*		Map<String, Integer> map=new TreeMap<String, Integer>();
		map.put("ccc", 1);
		map.put("ddd", 2);
		map.put("eee", 3);
		map.put("aaa", 4);
		map.put("bbb", 5);
		map.put("fff", 6);
		Set keySet=map.keySet();
		Iterator it=keySet.iterator();
		while(it.hasNext()) {
			String key=(String) it.next();
			int value=map.get(key);
			System.out.println(key+", "+value);
		}*/
	}

}
