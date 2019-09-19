package com.thread;

public class Ticket implements Runnable {

    private int num;

    private String lock;
    boolean flag = true;

    public Ticket(int num, String lock) {
        this.num = num;
        this.lock = lock;
    }

    @Override
    public   void run() {

            while (true) { //这一行和下面不能交换，不然都是一个窗口把票卖完了
  /*              try {
                    //让出一些时间让被人去抢, 没有这个时间, 别人抢个毛线, 性能差劲, 多线程表现不明显
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                synchronized (this) {


                    if ( num<=0 ){
                        System.out.println("火车票已经卖完了");
                        return;
                    }
                    try {
                        //模拟出票过程，否则因为执行太快，大部分被一个线程执行完了
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售出火车票：" + num--);
                }
            }
    }


/*
    @Override
    public void run() {
        while (flag) {

           */
/* try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*

            test();
        }

    }
*/


    /**
     * 资源分离, 提高性能
     */
    public synchronized void test() {//锁的是对象的资源

        if (num <= 0) {
            flag = false;
            return;
        }
        try { //让出一些时间让被人去抢, 没有这个一直被A抢着
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "售出火车票：" + num--);

    }


    public void test1() {
        synchronized (this) { //同步块写在这里没有意义
            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "售出火车票：" + num--);

        }

    }

    public void test2() {

        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "售出火车票：" + num--);

        }

    }

    //锁错位置了, 不但有重复, 还有负数
    public void test3() {
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "售出火车票：" + num--);


    }

    //锁的位置不对, 出现了负数
    public void test4() {
            if (num <= 0) {
                flag = false;
                return;
            }
        synchronized (this) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售出火车票：" + num--);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        String str = "lock";
        Ticket ticket = new Ticket(100, str);
        new Thread(ticket, "窗口A").start();
        new Thread(ticket, "窗口B").start();
        new Thread(ticket, "窗口C").start();
        new Thread(ticket, "窗口D").start();
    }


}