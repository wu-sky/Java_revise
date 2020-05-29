package com.thread.createThread;



/*
 *用户：sky-吴
 *日期：2019/9/27
 */
public class MyThreadIsExtendsThread extends Thread {



	public MyThreadIsExtendsThread(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		for(int i=20;i<=100;i++) {
			System.out.println(getName()+"..."+i);
		}
	}

	public static void runThread(){
		for (int i=1;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);

			if(i==20) {
				MyThreadIsExtendsThread myThread = new MyThreadIsExtendsThread("新线程");
				myThread.start();
//				一个对象, 一个线程, 否则报错 IllegalThreadStateException
//				myThread.start();
//				myThread.start();
			}
		}
	}


	/**
	 * 多线程的实现之一：继承 Thread 类
	 * @author Administrator
	 *让主函数 main 在打印1~100之间的所有整数的时候，要求在主函数打印到 20 的时候，
	 * 再运行另一个线程，让它打印10~100之间的所有整数。
	 */
	public static void main(String[] args) {
		runThread();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}



