package com.thread.map;

import java.util.HashMap;
import java.util.Map;

/*
 *用户：sky-吴
 *日期：2020/4/9
 */
public class HashMapHashTableInThread2 extends Thread{


	Map<String, String> table = new HashMap<>();

	@Override
	public void run() {
		table.put("a", "a");
		table.put("a", "a");
		table.put("a", "a");
		table.put("a", "a");

		System.out.println(table.toString());
	}

	public static void main(String[] args){
		final HashMapHashTableInThread2 thread = new HashMapHashTableInThread2();
		for (int i = 0; i < 1000; i++) {

			new Thread(thread, "线程"+i).start();
		}

	}



}
