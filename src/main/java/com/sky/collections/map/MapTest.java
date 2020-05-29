package com.sky.collections.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 *用户：sky-吴
 *日期：2020/4/8
 */
public class MapTest {

	public void test(){

		Map<String, String> hashMap = new HashMap<>();
		Map<String, String> treeMap = new ConcurrentHashMap<>();



	}

	public static void printMap(){

		HashMap<String, String> map = new HashMap<>();
		map.put("a", "b");
		map.put("c", "d");
		map.put("e", "f");

		 Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()		){
			String key = iterator.next();
			System.out.println("key===>" + key );
			System.out.println("value===>" + map.get(key));
			//System.out.println("value===>" + map.get(iterator.next()));
		}

	}

	/**
	 * 如果想在增强for循环里删除或者添加集合元素，那么一定会报异常：
	 * java.util.ConcurrentModificationException
	 * 因为增强for循环（foreach循环）本质上是隐式的iterator，
	 * 由于在删除和添加的时候会导致modCount发生变化，但是没有重新设置expectedModCount，
	 * 当你使用list.remove()后遍历执行iterator.next()时，
	 * 方法检验modCount的值和的expectedModCount值，如果不相等，
	 * 就会报ConcurrentModificationException
	 */
	public static void getEx() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(4);
		list.add(5);
		for (Integer i : list) {
			if (i == 2) {
				list.remove(i);
			}
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
			printMap();
			getEx();

	}


}
