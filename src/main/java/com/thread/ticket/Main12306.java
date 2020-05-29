package com.thread.ticket;

import com.innerclass.Main;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/21/2020
 *
 *
 * 这个类的对象只能是单例的, 而且必须是线程安全的, 但是这个懒汉式根本不符合要求, 既然是单例了, 就必须保证他线程安全
 */
public class Main12306 {


    private Main12306(){
        System.out.println("main12306被创建!!");
    }


    private static Main12306 instance=null;

    public static Main12306 getInstance(){

        if (instance==null){
            instance=new Main12306();
        }
        return instance;
    }


}

class Test implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"进入");
        Main12306.getInstance();
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Test()).start();

        }


    }
}