package com.test;

/**
 * Created by admin on 2019/5/12.
 */
public class ThreadLife extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" count to "+i);
        }
    }


    public static void main(String[] args) {
        ThreadLife t1=new ThreadLife();
        ThreadLife t2=new ThreadLife();
        ThreadLife t3=new ThreadLife();
        t1.start();
        t2.start();
        t3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" count to "+i);
        }

    }
}
