package com.thread.ticket;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/20/2020
 */
public class Ticket12306Demo2 extends Thread {


    // private int ticket=100; 这种方式是创建对象来实现多线程, 3个对象必须保证 数据共享, 必须设置为static
    private static int ticket = 100;
    //同步监视器, 就是一个对象
    private static Object lock = new Object();

    @Override
    public void run() {

        savedSell1();
    }

    //线程安全就像上厕所, 得锁门; Java中叫同步监视器, 俗称 锁
    public  void savedSell() {


            while (true) {
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
    public  void savedSell1() {


            while (true) {
                //synchronized (this) {
                synchronized (super.getClass()) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖的票是: " + ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }

    public static void notSavedSell() {

        while (true) {

            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖的票是: " + ticket);
                ticket--;
            } else {
                break;
            }

        }


    }

    public static void main(String[] args) {

        Ticket12306Demo2 t1 = new Ticket12306Demo2();
        t1.setPriority(Thread.MIN_PRIORITY);
        Ticket12306Demo2 t2 = new Ticket12306Demo2();
        t2.setPriority(Thread.MAX_PRIORITY);
        Ticket12306Demo2 t3 = new Ticket12306Demo2();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t2.start();
        t3.start();
        t1.start();
    }
}
