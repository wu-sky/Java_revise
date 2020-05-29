package com.thread.thread_bank_balance;

/**
 * extends thread类是如何确保临界资源的? 得在main方法中调用第三方的同一个资源.
 * Created by admin on 2019/5/10.
 */

//账户  
class Account {
    /**
     * 临界资源:余额
     */
    private float balance = 1000;

    public float getBalance() {

        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * 临界区:取钱方法
     *
     * @param money
     */
    public void withDraw(float money) {
        synchronized (this) {
            if (balance >= money) {
                System.out.println("取走 " + money + "钱");
                try {
                    /**
                     * 当两个线程同时启动的时候, 保证都能同时进入临界资源, 同时进入意味着余额都是充足的
                     */
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance = balance - money;


            } else {
                System.out.println("余额不足 无法取钱");
            }
        }
    }

}

class Account1 extends Thread {
    private Account account;

    public Account1(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withDraw(800);
        System.out.println("余额为" + account.getBalance());
    }
}

class Account2 extends Thread {

    private Account account;

    public Account2(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withDraw(700);
        System.out.println("余额为 " + account.getBalance());
    }
}

public class Main {

    public static void main(String[] args) {

        Account account = new Account();
        Account2 t2 = new Account2(account);
        Account1 t1 = new Account1(account);
        //在main方法里面借助了同一个Account对象account, 这个对象account就是临界资源.
        t1.start();
        t2.start();


    }
}  
