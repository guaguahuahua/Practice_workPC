package com.xjtu.interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortedMap {

	/**
	 * 测试可同步的map映射，使用hashMap
	 */
	private static void testSyncronizedMap() {
		//此时得到的map是可同步的map映射，是线程安全的
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
	 * 测试有序的map treeMap
	 * 也就是说，treemap对插入的键值对按照键key值进行了排序
	 * 并且在获取得到的keyset中键的顺序也是进行过排序的，所以treeMap适合于有顺序的
	 * 集合，但是这种排序过程会影响效率，所以没有顺序的需求的时候，还是使用类似hashmap这种map
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
