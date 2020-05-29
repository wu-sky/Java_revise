package com.thread.list;


import java.util.ArrayList;
import java.util.List;

public class ArrayListVectorInThread implements Runnable {

	// 非线程安全
	List<String> list1 = null;

	public ArrayListVectorInThread() {
		list1 = new ArrayList<>();

	}

	@Override
	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 2));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException
	{
		ThreadGroup group = new ThreadGroup("mygroup");
		ArrayListVectorInThread t = new ArrayListVectorInThread();
		for (int index = 0; index < 10000; index++) {
			Thread thread = new Thread(group, t, String.valueOf(index));
			thread.start();
		}

		while (group.activeCount() > 0) {
			Thread.sleep(10);
		}
		System.out.println();
		// 线程安全，就是1万。否则，可能不是10000。
		System.out.println(t.list1.size());
	}
}