package com.sky.innerclass;

import org.apache.commons.lang.builder.CompareToBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/25/2020
 *
 * 为什么要创建内部类, 就是因为有些数据它纯粹就是只供给它的外部类使用, 对于代码的整洁和优化来说它并不需要写成外部类.
 * 比如说一个人的大脑, 他有自己的数据, 有自己的方法, 但是他离开了人他就没有意义. jdk中有很多类就使用了内部类, 人家写的时候想了想啊,
 * 没必要把这个类暴露出来, 直接就写成了内部类.
 * 谁用到了内部类:
 *  // Integer ==>  private static class IntegerCache {xxxx}
 *  // thread ==>  public enum State {xxx}
 *
 */
public class Person {


    static class Brain {
        private String name;
        public Brain() {
            this.name="brain";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Leg {

        private String name;


        public Leg() {
            this.name="leg";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



    //一般见的多的还是这个玩意, 使用局部(方法)内部类创建一个接口对象
    public Map getMap(){
        class MyMap extends HashMap {
            String name;

            public MyMap( ) {
               this.name="myMap";
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        return new MyMap();
    }


    public Comparable getComparable(){

        //返回一个有名字的实现了comparable接口的内部类
         class MyComparable implements Comparable {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        return  new MyComparable();
    }

    public Comparable getComparable1(){

        //返回一个匿名的实现了comparable接口的内部类, 这个就一步到位了
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    public void setComparable(Comparable c){

    }

}

class Test{

    public static void main(String[] args) {
        Person.Brain brain=new Person.Brain();



        //Person.Leg leg=new Person.Leg(); 告诉我为什么不能这么写???
        Person person =new Person();
        Person.Leg leg = person.new  Leg();
        System.out.println("leg.getName() = " + leg.getName());

        //对比js是不是有些十分相似
        person.setComparable(new Comparable(){

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        });

    }
}
