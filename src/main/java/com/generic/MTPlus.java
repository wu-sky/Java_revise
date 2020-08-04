package com.generic;

import com.accessControl.control.E;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型初体验
 *
 * @author : wushikai https://www.jianshu.com/p/986f732ed2f1
 * <p>
 * date : 2020-08-04
 */
public class MTPlus {
    /*为什么使用泛型? 没有泛型的情况下, 同一个加法功能, 每个类型都要写一遍*/
/*    private static int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }*/

    /*当使用了泛型之后, 同一个功能, 方法只要写一个*/
    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    /*泛型方法, 必须有 <T> 来强制指定类型  例如 new List<String>(); 要不然 本来装水的list 被你装了硫酸, 拿出来用的时候, 出了事故 */
    private static <T> T genericAdd(T a, T b) {
        System.out.println(a + "+" + b + "=" + a + b);
        return a;
    }


    /*
    上面这两个方法体现了泛型的
    * 1.适用于多种数据类型执行相同的代码（代码复用）
      2.泛型中的类型在使用时指定，不需要强制类型转换（类型安全，编译器会检查类型）
    *
    * */


    public static void main(String[] args) {

        double doubleResult = MTPlus.add(1d, 1d);
        System.out.println("doubleResult = " + doubleResult);

        double floatResult = MTPlus.add(1f, 2f);
        System.out.println("floatResult = " + floatResult);

        double intResult = MTPlus.add(1, 2);
        System.out.println("intResult = " + intResult);


        /*泛型方法*/
        Object a = 1, b = 2;

        Integer integerResult = MTPlus.<Integer>genericAdd(1, 2);
        System.out.println("integerResult = " + integerResult);

        String stringResult = MTPlus.<String>genericAdd("1", "2");
        System.out.println("stringResult = " + stringResult);

        /* 可以明显的看出泛型方法的好处就是强制了类型, 防止ClassCastException  */
        //Float FloatResult = MTPlus.<Integer>genericAdd(1.0F, 2.0F);   //genericAdd (java.lang.Integer, java.lang.Integer) in MTPlus cannot be applied to (float, float)
        // System.out.println("FloatResult = " + FloatResult);
        List list = new ArrayList();
        list.add(1); //Unchecked call to 'add(E)' as a member of raw type 'java.util.List' less... (Ctrl+F1)
        list.add(2);
        list.add("3");
        System.out.println("list.toString() = " + list.toString());
        //  System.out.println(((int) list.get(1) + (int) list.get(2))); //ClassCastException


        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        // list1.add("3");
        list1.add(3);
        System.out.println(((int) list1.get(1) + (int) list1.get(2)));


    }


}


/**
 * 泛型类
 */
class GenericClass<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass<>();
        ArrayList<String> list =new ArrayList<>();
        genericClass.setData("Generic Class");
        list.add("wocao");
        System.out.println(genericClass.getData());
        System.out.println(list.toString());
    }





}



/**
 * 泛型接口, 一脸懵
 * 其实这个接口什么事情都没干
 * */
interface IDao<T> {
    T findById(String id);
    boolean delete(String id);
    boolean update(T t);
    boolean add(T t);
}

/**
 * 实现泛型接口方式一 : 泛型接口实现类-泛型类实现方式
 * */

//class BaseDao <T> implements IDao{
// IDao 不加<T> 行不行? 答案是不行; 因为IDao 使用了泛型T, 没有了这个泛型T, 底下的方法是没办法执行的
// Class 'BaseDao' must either be declared abstract or implement abstract method 'update(T)' in 'IDao'
class BaseDao <T> implements IDao<E>{


    @Override
    public E findById(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(E t) {
        return false;
    }

    @Override
    public boolean add(E t) {
        return false;
    }
}








