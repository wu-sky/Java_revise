package com.test;

/**
 * Created by admin on 2019/5/13.
 */
public class Temp implements Itest{

    static void change( String str){
        str="3333";
    }
    public static void main(String[] args) {
        Itest test=new Temp();
        test.test();
    }

    @Override
    public void test() {
        System.out.println("实现类的test方法");
    }
}


interface Itest{

    void test();
}