package com.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CollectionGeneric {

	public static void test01(List list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	public static void test02(List<String> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	/**
	 * 类型通配符List<?>
	 * @param list
	 */
	public static void test03(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	public static void test04(List<Object> list) {
		for (Object o : list) {
			/*if (new ArrayList() instanceof list ){
				list是unknown的
			}*/
			System.out.println(o);
		}
	}


	/**
	 * 最简单的泛型例子, 菱形语法 List<Object> list, Map<Object, Object> map
	 * 你说List有多少种实现, 简直是无数种. 自定义的都是无数种
	 * 但是不存在泛型类, 即不存在List<String> 这个类, 也不存在List<Integer> 这个类
	 * 它们都是同一个类, 只不过是不同实现而已
	 */
	public static void test011() {
		/**
		 * 不存在泛型类, 无论你装什么类型, 都是ArrayList类
		 */
		List<String> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		System.out.println("List<String>和List<Integer>是同一个类吗??" +
				(list2.getClass() == list1.getClass() ? true : false) +
				"它们的类型是:" + list1.getClass().getName() + ", " + list2.getClass().getName());

		/*	if (list1 instanceof List<String>){
			System.out.println("list1 是泛型类List<String>的对象");
		}else{
			System.out.println("Illegal generic type for instanceof");
		}*/



		List<Object> list;
		list = new ArrayList<>();
		list.add("a");
		list.add('b');
		list.add(1);

		//lambda表达式
		list.forEach(str -> System.out.println("str=" + str));
		//foreach
		for (Object str : list) {
			System.out.println("str=" + str);
		}

		Map<Object, Object> map = new HashMap<>();
		map.put(1, 'a');
		map.put('b', 2);
		map.put("c", 3);
		map.forEach((key, Value) -> System.out.println("key: " + key + "   value" + Value));
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		CollectionGeneric.test01(list);
		CollectionGeneric.test02(list);
		CollectionGeneric.test03(list);
		//  类型转不进去 List<String> 不能转成List<Object>
		/// CollectionGeneric.test04(list);
	}

}
/*
 *用户：sky-吴
 *日期：2019/9/2
 */