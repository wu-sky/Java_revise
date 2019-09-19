package com.thread;

/**
 * 让cpu炸裂
 */
public class CpuOverflow {

	public static void main(String[] args){
		while (true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("不断创建线程, 让cpu飞起!!!");
				}
			}).start();
		}

	}
}

/*
		*用户：sky-吴
		*日期：2019/8/28
		*/