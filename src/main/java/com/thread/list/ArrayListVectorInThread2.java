package com.thread.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 *用户：sky-吴
 *日期：2020/4/9
 */
public class ArrayListVectorInThread2 implements Runnable{

	List<String> container = new ArrayList<>();//CopyOnWriteArrayList();
	//List<String> container = new Vector<>();//CopyOnWriteArrayList();



	@Override
	public void run() {
		container.add("a");
		container.add("b");
		container.add("c");
		container.add("d");
		System.out.println(container.toString());
	}


	public static void main(String[] args){
		ArrayListVectorInThread2 thread = new ArrayListVectorInThread2();
		for (int i = 0; i <100; i++) {
			new Thread(thread, "线程"+i).start();
		}
	}


}

/**
 Concurrent    同时发生的/并发
 Modification  修改
 Exception     异常
 */