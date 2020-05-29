package com.thread.ticket;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/21/2020
 */
public class MainSaved12306Demo2 {


    private MainSaved12306Demo2() {
        System.out.println("main12306被创建!!");
    }


    private static MainSaved12306Demo2 instance = null;

    //注意是static
    public static MainSaved12306Demo2 getInstance() {

        //优化同步锁的代码
        if (instance == null) {
            synchronized (MainSaved12306Demo2.class) {
                if (instance == null) {
                    instance = new MainSaved12306Demo2();
                }

            }
        }
        return instance;
    }





}

class TestMainSaved12306Demo2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"进入");
        MainSaved12306Demo2.getInstance();
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new TestMainSaved12306Demo2()).start();

        }


    }
}