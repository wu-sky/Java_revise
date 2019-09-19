package com.innerclass;



import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by admin on 2019/5/10.
 */
public class Main implements IFace {

    @Override
    public void method() {
        System.out.print("Main类方法被调用");
        class Inner{

            public void print(  ){
                System.out.println("方法内部类被调用...");
            }
        }
        new Inner().print();
    }

    public static void main(String[ ] args) {

        IFace i = new IFace() {
            @Override
            public void method() {
                for (int i = 0; i < 1; i++) {

                    System.out.println("匿名内部类方法被调用....");
                }

            }
        };
        i.method();
        System.out.println("看看我是谁的对象??  " + i.getClass());

        System.out.println("下面我连内部类对象名字都没有");

        new IFace() {


            @Override
            public void method() {
                System.out.println("我是匿名内部类的方法, 我连对象的名字我都不知道");
                System.out.println("通过反射, 我的类名是:" + this.getClass());

            }
            //调用匿名内部类的方法
        }.method();

        new Main() {

            public void print() {
                System.out.println("我的上层函数是Main类的构造函数!");
                System.out.println("我是Main类的匿名内部类方法");
                System.out.println("通过反射, 我的类名是:" + this.getClass());
            }
        }.print();

        Main m = new Main();

       new ArrayList<String>(){
            public void print(  ){

                System.out.println("建立匿名内部类, 必须创建一个new. ");
            }

        }.print();
        new HashSet<String>(){


        };
        System.out.print("idea");

    }

}
