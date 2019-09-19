package com.thread.deadlock;

/**
 * 过多的同步导致的相互不是放资源
 * Created by admin on 2019/5/10.
 */


class Lipstick {//这个仅仅是一个空类
}

class Mirror {
}


class Makeup implements Runnable {
    static Lipstick lipstick = new Lipstick();//空对象
    static Mirror mirror = new Mirror();
    int choice;
    String womanName;

    Makeup(int choice, String womanName) {
        this.choice = choice;
        this.womanName = womanName;
    }


    @Override
    public void run() {
        if (choice == 0) {
            //如何死锁呢??
            //一把锁套一把锁
            synchronized (lipstick) {
                System.out.println(this.womanName + " gets lipstick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                synchronized (mirror) {
                    //执行到这里算我输
                    System.out.println(this.womanName + " gets mirror");


                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.womanName + " gets mirror");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }


                synchronized (lipstick) {
                    //执行到这里算我输
                    System.out.println(this.womanName + " gets lipstick");

                }
            }
        }
    }
}




public class Deadlock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Makeup(0, "woman 1"));
        Thread t2 = new Thread(new Makeup(1, "woman 2"));
        t1.start();
        t2.start();
    }

}