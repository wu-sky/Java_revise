package com.thread.consumer_producer;

/**
 * 线程通信:管程法
 * Created by admin on 2019/5/10.
 */

/**
 * 跳出双引号：shift+"
 * 跳出单引号：shift+'
 * 跳出括号：shift+)
 * 跳出中括号：shift+]
 */


//馒头----产品
class Steambun {
    int id;

    public Steambun(int id) {
        this.id = id;
    }
}

class SyncContainer {

    Steambun buns[] = new Steambun[10];
    int count = 0;
    //store

    public synchronized void  push(Steambun steambun) {
        //判断何时不能生产
        //容器满则不能生产
        if (count==buns.length){
            System.out.println("快点消费, 我这里库存太多了");
            try {

                /**
                 * 注意这个方法, 线程阻塞, 等待通知去生产
                 */
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buns[count] = steambun;
        count++;
        this.notifyAll();
    }

    //take
    public synchronized Steambun pop() {
        //判断有无馒头
        //无则等待
        if(count==0){
            System.out.println("快点生产, 我都饿的不行了...");
            try {

                /**
                 * 注意这个方法, 线程阻塞, 等待通知去消费
                 */
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //有则吃掉
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        Steambun steambun = buns[count];
        this.notifyAll();
        return steambun;
    }

}

//producer
class Producer extends Thread {

    SyncContainer container;

    public Producer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //start producing
        for (int i = 1; i <= 100; i++) {
            System.out.println("produce--> 第  " + i + "号 steambuns;");
            container.push(new Steambun(i));
        }
    }

}


//consumer
class Consumer extends Thread {
    SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            System.out.println("eat--> the  第" + container.pop().id + "号 steambuns;");

        }
    }
}





public class CP {

    public static void main(String[] args) {
        SyncContainer container=new SyncContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }

}
