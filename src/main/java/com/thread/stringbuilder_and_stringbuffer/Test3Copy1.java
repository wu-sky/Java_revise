package com.thread.stringbuilder_and_stringbuffer;

/**
 * Created by admin on 2019/5/12.
 */

public class Test3Copy1 implements Runnable {

    StringBuilder builder = new StringBuilder();
    StringBuffer buffer=new StringBuffer();
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 2));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    builder.append(1);
        buffer.append(1);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("testgroup");
        Test3Copy1 t = new Test3Copy1();
        for (int i = 0; i < 100000; i++) {
            Thread th = new Thread( t, String.valueOf(i));
            th.start();
        }


        // 如果长度为100000就是安全的
      System.out.println(t.builder.length());
        System.out.println(t.buffer.length());
    }
}
