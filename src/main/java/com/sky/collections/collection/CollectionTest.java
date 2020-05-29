package com.sky.collections.collection;

import com.sky.bean.User;

import java.util.*;

/*
 *用户：sky-吴
 *日期：2020/4/8
 */
public class CollectionTest {

	public void test(){

		//数据结构里就是这堆玩意
		Collection<String> arrayList=new ArrayList<>();
		arrayList.add("ArrayList");
		arrayList.add("ArrayList");
		for (String str: arrayList){
			System.out.println(str);
		}
		List<User> list=new Vector<>();
		list.add(new User(2L, "老九"));
		list.add(new User(3L, "老十"));
		list.add(new User(1L, "老八"));
	    Collections.sort(list);
		System.out.println(list.toString());
		System.out.println(((Vector<User>) list).firstElement());

		Collection<String> linkedList=new LinkedList<>();
		linkedList.add("linkedList");
		linkedList.add("linkedList");
		for (String str: linkedList){
			System.out.println(str);
		}

		Collection<String> hashSet=new HashSet<>();
		hashSet.add("HashSet");
		hashSet.add("HashSet");
		for (String str: hashSet){
			System.out.println(str);
		}


		Collection<String> treeSet=new TreeSet<>();
		treeSet.add("TreeSet");
		treeSet.add("TreeSet");
		for (String str: treeSet){
			System.out.println(str);
		}




	}

	public static void main(String[] args){
	  new CollectionTest().test();
	}


}
