package com.thread.consumer_producer;

import java.lang.management.ManagementFactory;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/23/2020
 */
public class WaitNotifyDemo01 implements Runnable {

    private int number = 100;

    @Override
    public void run() {

        while (true) {

            synchronized (this) {
                this.notify();
                if (number > 0) {

                    System.out.println(Thread.currentThread().getName() + " : " + number);

                    number--;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }

            }


        }


    }


    public static void main(String[] args) {
        WaitNotifyDemo01 waitNotifyDemo01 = new WaitNotifyDemo01();


        Thread t1 = new Thread(waitNotifyDemo01);
        Thread t2 = new Thread(waitNotifyDemo01);
        Thread t3 = new Thread(waitNotifyDemo01);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        //t3.start();


    }


}
