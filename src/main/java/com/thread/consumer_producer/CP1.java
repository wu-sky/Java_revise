package com.thread.consumer_producer;

/**
 * 生产者消费者:信号量法
 * Created by admin on 2019/5/10.
 */



//resource tv
class Tv{
    String voice;
    boolean flag=true;//T演员表演, 观众等待
                        //F观众观看, 演员等待
    public synchronized void play(String voice ){

        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("play:"+voice);
        this.voice=voice;
        this.notifyAll();
        this.flag=!this.flag;
    }

    public synchronized void watch( ){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("hear:"+voice);
        this.notifyAll();
        this.flag=!this.flag;
    }


}
//producer actor

class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {

        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("小时代");
            }else{
                this.tv.play("广告");
            }
        }
    }
}

//consumer spectator

class Spectator extends Thread{

    Tv tv;

    public Spectator(Tv tv) {
        this.tv = tv;

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }

    }

}



public class CP1 {


    public static void main(String[] args) {
        Tv tv=new Tv();
        new Player(tv).start();
        new Spectator(tv).start();
    }
}
