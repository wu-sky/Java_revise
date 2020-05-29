package com.sky.collections.collection;

import java.util.HashMap;
import java.util.Map;

public class DictUtil {
	public static void main(String[] args){
		Map<String, String> map=new HashMap<>();
		map.put("a","1");
		map.put("b","2");
		map.put("a","3");

		for (String key :map.keySet()		     ) {
			System.out.println(key + " ：" + map.get(key));
		}

		Map<String, Map<String, String>> allMap=new HashMap<>();
		allMap.put("a", map);
		System.out.println(allMap.get("a"));
		System.out.println(allMap.get("b"));
		//map的二重嵌套
		for (Map<String, String> m:allMap.values()) {
			for (String key :map.keySet()		     ) {
				System.out.println(key + " ：" + map.get(key));
			}
		}
	}
}
/*
 *用户：sky-吴
 *日期：2019/8/1
 *根据字典list分离出字典类型, 相当于分类装鱼
 */
