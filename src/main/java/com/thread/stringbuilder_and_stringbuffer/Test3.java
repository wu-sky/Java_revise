package com.thread.stringbuilder_and_stringbuffer;

/**
 * Created by admin on 2019/5/12.
 */

public class Test3 implements Runnable {

    StringBuilder builder = new StringBuilder();
    StringBuffer buffer = new StringBuffer();

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        builder.append(1);
        buffer.append(1);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("testgroup");
        Test3 t = new Test3();
        Thread th=null;
        for (int i = 0; i < 10000; i++) {
            th= new Thread( group,t, String.valueOf(i));
            th.start();
        }
        //判断线程组里面还有没有活着的线程. 如果有的话, main线程得等等, 否则二者都不能到10000
        while (group.activeCount() > 0) {
            Thread.sleep(10);
        }
        // 如果长度为100000就是安全的
        //注意main线程才不管你buffer和builder搞没搞完, 你搞到多少我就数到多少, 数完main方法就走人
        System.out.println("builder"+t.builder.length());
        System.out.println("buffer"+t.buffer.length());
        System.out.println(th.isAlive());
    }
}