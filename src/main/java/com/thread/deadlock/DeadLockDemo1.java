package com.thread.deadlock;

import static java.lang.Thread.sleep;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/21/2020
 */
public class DeadLockDemo1 {


    public static void main(String[] args) {
        StringBuffer spoon = new StringBuffer();
        StringBuffer chopsticks = new StringBuffer();

        new Thread() {

            @Override
            public void run() {

                spoon.append("鸡汤");
                chopsticks.append("空心菜");
                spoon.append("鸭汤");
                chopsticks.append("上海青菜");
                System.out.println(spoon);
                System.out.println(chopsticks);


            }
        }.start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                spoon.append("甲鱼汤");
                chopsticks.append("韭菜");
                spoon.append("羊汤");
                chopsticks.append("波菜");
                System.out.println(spoon);
                System.out.println(chopsticks);

            }
        }).start();


        new Thread() {

            @Override
            public void run() {

                synchronized (chopsticks) {
                    spoon.append("鸡汤");
                    chopsticks.append("空心菜");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (spoon) {
                        spoon.append("鸭汤");
                        chopsticks.append("上海青菜");
                        System.out.println(spoon);
                        System.out.println(chopsticks);

                    }
                }
            }
        }.start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (spoon) {
                    spoon.append("甲鱼汤");
                    chopsticks.append("韭菜");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (chopsticks) {
                        spoon.append("羊汤");
                        chopsticks.append("波菜");
                        System.out.println(spoon);
                        System.out.println(chopsticks);

                    }
                }
            }
        }).start();


    }


}
