package com.thread.ticket;

/**
 * @author 吴世凯 邮箱：
 * 日期：5/20/2020
 */
public class Ticket12306Demo1 implements Runnable {

    private int ticket = 100;
    private static final Object lock = new Object();

    @Override
    public void run() {


        //savedSell();
        notSavedSell2();
    }


    /**
     * 难点就在于是否保证锁放的地方是对的
     */
    public void savedSell() {


        while (true) {
            //锁住共享资源
            synchronized (lock) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖的票是: " + ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }
    public void savedSell1() {


        while (true) {
            //锁住共享资源
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖的票是: " + ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }

    public void notSavedSell1() {

        while (true) {

            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖的票是: " + ticket);
                ticket--;
            } else {
                break;
            }

        }


    }

    public void notSavedSell2() {
        //把整个资源全锁了, 根本不是多线程
        synchronized (lock) {
            while (true) {

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖的票是: " + ticket);
                    ticket--;
                } else {
                    break;
                }

            }

        }


    }

    public static void main(String[] args) {
        //共用一个对象创建出3个线程, 那么意味着这个对象的资源被三个线程所瓜分
        Ticket12306Demo1 ticket12306 = new Ticket12306Demo1();
        Thread thread1 = new Thread(ticket12306);
        Thread thread2 = new Thread(ticket12306);
        Thread thread3 = new Thread(ticket12306);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
