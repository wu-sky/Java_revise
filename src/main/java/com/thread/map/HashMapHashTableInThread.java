package com.thread.map;

import com.thread.list.ArrayListVectorInThread2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
 *用户：sky-吴
 *日期：2020/4/9
 */
public class HashMapHashTableInThread {

	static Map<Integer, Integer> table = new HashMap<>();
	//static Map<Integer, Integer> table = new Hashtable<>();

	public static void main(String[] args){

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("线程1执行");
				for (int i = 0; i < 1000; i++) {
					table.put(i,i);
				}
				System.out.println("线程1---------" + table.get(500));
			}
		}).start();
		//利用时间差, 得到不同的执行结果
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("线程2执行");
				for (int i = 1000; i < 2000; i++) {
					table.put(i, i);
				}
				System.out.println("线程2---------" + table.get(1500));
			}
		}).start();


	}

}
