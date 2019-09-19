package com.thread.stringbuilder_and_stringbuffer;

/**
 * 多个线程不能同时修改StringBuffer中的内容，而能同时修改StringBuilder中的东西
 * Created by admin on 2019/5/12.
 */

public class Test3Copy implements Runnable {

    StringBuilder builder = new StringBuilder();
    StringBuffer buffer=new StringBuffer();
    public void run() {
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        builder.append("N");
        buffer.append("Y");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("testgroup");
        Test3Copy t = new Test3Copy();
        Thread th=null;
        for (int i = 1; i <= 10000; i++) {
           th  = new Thread( t, i+"");
            th.start();
        }

      
        // 如果长度为10000就是安全的, 可是事实无论是builder和buffer都不能到10000, 因为main 先退出了
        System.out.println("builder.length="+t.builder.length());
        System.out.println("builder is "+t.builder);
        System.out.println("buffer.length="+t.buffer.length());
        System.out.println("buffer is "+t.buffer);
        System.out.println(th.getName()+" is alive ? "+th.isAlive());
        System.out.println(Thread.currentThread().getName()+" is alive ? "+Thread.currentThread().isAlive());
    }
}