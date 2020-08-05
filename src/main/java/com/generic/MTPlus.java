package com.generic;

import com.accessControl.control.E;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型初体验
 *
 * 一些常用的泛型类型变量：
 * E：元素（Element），多用于java集合框架
 * K：关键字（Key）
 * N：数字（Number）
 * T：类型（Type）
 * V：值（Value）
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

    /*术语: 带< xxx>  的方法叫做 泛型方法, 必须有 <T> 来强制指定类型  例如 new List<String>(); 要不然 本来装水的list 被你装了硫酸, 拿出来用的时候, 出了事故 */
    private static <T> T genericAdd(T a, T b) {
        System.out.println(a + "+" + b + "=" + a + b);
        return a;
    }


    /*
    上面这两个方法体现了泛型的
    * 1.适用于多种数据类型执行相同的代码（代码复用）
      2.泛型中的类型在使用时指定,不需要强制类型转换（类型安全,编译器会检查类型）
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
 * 泛型中的约束和局限性
 * 1:不能实例化泛型类
 * 2:静态变量或方法不能引用泛型类型变量，但是静态泛型方法是可以的
 * 3:基本类型无法作为泛型类型
 * 4:无法使用instanceof关键字或==判断泛型类的类型
 * 5:泛型类的原生类型与所传递的泛型无关，无论传递什么类型，原生类是一样的
 * 6:泛型数组可以声明但无法实例化
 * 7:泛型类不能继承Exception或者Throwable
 * 8:不能捕获泛型类型限定的异常但可以将泛型限定的异常抛出
 */
// 泛型类型变量  这个类 < T > 就是 泛型类型变量
class GenericClass<T> {   //术语: 带< xxx> 的类, 叫做泛型类,  例如ArrayList 就是一个泛型类 ,  GenericClass 这个也是一个泛型类
    private T data;

    public T getData() {
        // 1:不能实例化泛型类
       // this.data=new T();  Type parameter 'T' cannot be instantiated directly 无法直接实例化类型参数“T”
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //2:静态变量或方法不能引用泛型类型变量，但是静态泛型方法是可以的
    // private static T result;   cannot be referenced from a static context
//        private static T getResult() {
//        return result;
//    }


    /**
     * 静态泛型方法是可以的 <K> 只是一个约束 , 返回类型是 K
     */
    private static <K> K getKey(K k) {
        return k;
    }


/*
*
6:泛型数组可以声明但无法实例化
7:泛型类不能继承Exception或者Throwable
8:不能捕获泛型类型限定的异常但可以将泛型限定的异常抛出
* */



    public static void main(String[] args) {
        GenericClass<String> genericClassStr = new GenericClass<>();
        ArrayList<String> list = new ArrayList<>();
        genericClassStr.setData("Generic Class");
        list.add("wocao");
        System.out.println(genericClassStr.getData());
        System.out.println(list.toString());

        //3:基本类型无法作为泛型类型 Type argument cannot be of primitive type
        //GenericClass<int> genericClass1 = new GenericClass();


        //4:无法使用instanceof关键字或==判断泛型类的类型
        System.out.println( genericClassStr instanceof GenericClass ); //✔
        //System.out.println( genericClass instanceof GenericClass<String> ); //❌ Illegal generic type for instanceof
        //有个著名的说法, ArrayList<String> list 到底是ArrayList 类型 还是 ArrayList<String> 类型?
        //5:泛型类的原生类型与所传递的泛型无关，无论传递什么类型，原生类是一样的
        GenericClass<Integer> genericClassInt=new GenericClass<>();
        System.out.println( genericClassInt.getClass() == genericClassStr.getClass() );

    }


}


/**
 * 泛型接口, 一脸懵
 * 其实这个接口什么事情都没干
 */
interface IDao<T> {
    T findById(String id);

    boolean delete(String id);

    boolean update(T t);

    boolean add(T t);
}


class User implements Comparable<User> {  ///Type argument cannot be of primitive type
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    User() {
    }

    @Override
    public int compareTo(User o) {
        if (! (o  instanceof User)){
            //有些时候, 你返回什么值都是错误的, 你只能抛出一个异常回去
            throw new  RuntimeException("类型不一致");
        }

        //负整数、零或正整数,根据此对象是小于,等于还是大于指定对象
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args){


        User sky = new User(3L, "sky");
        User land = new User(2L, "land");
        System.out.println(sky.compareTo(land));
        //System.out.println(sky.compareTo(null));


    }


}


/**
 * 实现泛型接口方式一 : 泛型接口实现类-泛型类实现方式
 */
//class BaseDao <T> implements IDao{
// IDao 不加<T> 行不行? 答案是不行; 因为IDao 使用了泛型T, 没有了这个泛型T, 底下的方法是没办法执行的
// Class 'BaseDao' must either be declared abstract or implement abstract method 'update(T)' in 'IDao'
class BaseDao<T> implements IDao<E> {


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


    public static void main(String[] args) {
        BaseDao<User> baseDao = new BaseDao<>();

    }
}


//泛型接口实现类-指定具体类型实现方式 , 对比上面的泛型, UserDao 中的T 全都成为了 User
class UserDao implements IDao<User> {

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }
}


//限定泛型  类型变量, 泛型, 太泛了也不行
class GenericRestrict<T extends Number> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 限定类型使用extends关键字指定
     * 可以使类,接口,类放在前面接口放在后面用&符号分割
     * 例如：<T extends ArrayList & Comparable<T> & Serializable>
     *     comparable 明明是一个接口, 但是却用的extends????????
     *  java-core  P533有这么一段话做解释：
     *     <T extands BoundingType> 表示T应该是绑定类型的子类型（subType）。
     * T和绑定类型可以是类，也可以是接口。
     * 选择关键字extands的原因是更接近子类的概念，并且java的设计者也不打算在语言中添加一个新的关键字  如sub ;
     * 所以，这里的泛型用<T extends Interface>中extends　的关键字的意思，其实是在给泛型设置限定（bound）的时候, 让extends = extends or implements.
     *
     */
    private static < E extends Comparable<E>   > E getMin(E a, E b) {
        return (a.compareTo(b) < 0) ? a : b;
    }

    public static void main(String[] args) {
        GenericRestrict<Integer> restrict = new GenericRestrict<>();
        restrict.setData(3);
        System.out.println(restrict.getData());


        //基本类型都已经实现了comparable接口的方法，所以可以之间比较
        Integer min = GenericRestrict.getMin(3, 4);
        System.out.println(min);
        //public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
        String min1 = GenericRestrict.getMin("a", "r");
        System.out.println(min1);

        User sky = new User(3L, "sky");
        User land = new User(2L, "land");

        System.out.println(   );

        //这个方法之所以能这么用, 就是因为 sky 实现了comparable 接口, 并且comparable< User >  ;
        User min2 = GenericRestrict.getMin(sky, land);
        System.out.println(min2.toString());

    }


}








































