package com.thread.createThread;

/*
 *用户：sky-吴
 *日期：2019/9/27
 */
public class MyThreadIsImplRunnable implements Runnable {


	MyThreadIsImplRunnable(String name){

		Thread.currentThread().setName(name);

	}

	@Override
	public void run() {
		for (int i = 20; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}

	/**
	 * 多线程创建的方式2
	 * 继承Runnable接口
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=1; i<=100;  i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);

			if(i==30) {
				MyThreadIsImplRunnable myThread = new MyThreadIsImplRunnable("新线程");

				Thread thread = new Thread(myThread);

				thread.start();
			}
		}
	}
}

