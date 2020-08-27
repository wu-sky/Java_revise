package com.generic;

import com.accessControl.control.E;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 泛型初体验
 * <p>
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
public class MultiTypePlus {
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

    /**---------------------------------泛型方法----------------------------------------------------
     * 术语: 带< xxx>  的方法叫做 泛型方法, 必须有 <T> 来强制指定类型, 好处是 类型不匹配直接报错
     * 例如 new List<String>();
     * 要不然 本来装水的list 被你装了硫酸, 拿出来喝的时候, 出了事故 */
    private static <T> T genericAdd(T a, T b) {
        System.out.println(a + "+" + b + "=" + a + b);
        return a;
    }
    /*
    上面这些方法体现了泛型的
      1.适用于多种数据类型执行相同的代码（代码复用）
      2.泛型中的类型在使用时指定,不需要强制类型转换（类型安全,编译器会检查类型）
    * */

    public static <T> T getMiddle(T ... t){ //第一次见过这种写法

        return t[t.length/2];
    }



    public static void main(String[] args) {

        double doubleResult = MultiTypePlus.add(1d, 1d);
        System.out.println("doubleResult = " + doubleResult);

        double floatResult = MultiTypePlus.add(1f, 2f);
        System.out.println("floatResult = " + floatResult);

        double intResult = MultiTypePlus.add(1, 2);
        System.out.println("intResult = " + intResult);


        Object a = 1, b = 2;

        Integer integerResult = MultiTypePlus.<Integer>genericAdd(1, 2);
        System.out.println("integerResult = " + integerResult);

        String stringResult = MultiTypePlus.<String>genericAdd("1", "2");
        System.out.println("stringResult = " + stringResult);

        /* 可以明显的看出泛型方法的好处就是强制了类型, 防止ClassCastException  */
        //Float FloatResult = MultiTypePlus.<Integer>genericAdd(1.0F, 2.0F);   //genericAdd (java.lang.Integer, java.lang.Integer) in MultiTypePlus cannot be applied to (float, float)
        // System.out.println("FloatResult = " + FloatResult);
        //原生态类型（没有类型参数的泛型）是合法的，但是永远不应该这么做, List 可以不带 <泛型类型> , 但是做么做就失掉了泛型在安全性和描述性方面的所有优势
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


        /**------------------------每一种泛型都定义一个原生态类型（ raw type ）例如，与 List ＞相对应的原生态类型是 List--------------------------------*/
        //4:无法使用instanceof关键字或==判断泛型类的类型, 只能判断其原生态类型
        System.out.println(genericClassStr instanceof GenericClass); //✔
        //System.out.println( genericClass instanceof GenericClass<String> ); //❌ Illegal generic type for instanceof


        //有个著名的说法, ArrayList<String> list 到底是ArrayList 类型 还是 ArrayList<String> 类型?
        //5:泛型类的原生类型与所传递的泛型无关，无论传递什么类型，原生态类型都是一样的




        GenericClass<Integer> genericClassInt = new GenericClass<>();
        System.out.println(genericClassInt.getClass() == genericClassStr.getClass());

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
        if (!(o instanceof User)) {
            //有些时候, 你返回什么值都是错误的, 你只能抛出一个异常回去
            throw new RuntimeException("类型不一致");
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

    public static void main(String[] args) {


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


    public static void main(String[] args) throws NoSuchMethodException {
        /*转不了, 失败了
        * Exception in thread "main" java.lang.NoSuchMethodException: com.generic.BaseDao.add(com.generic.User)
        * */
        BaseDao<User> baseDao = new BaseDao<>();

        Method method = baseDao.getClass().getMethod("add", User.class);
        //知识点：参数化的类型，ParameterizedType
        /*
         * 下面是错误的
         * ParameterizedType[] pt= (ParameterizedType[]) method.getGenericParameterTypes();
         */
        Type[] types=method.getGenericParameterTypes();
        //获取types中的元素，转成ParameterizedType这种类型
        ParameterizedType pt=(ParameterizedType) types[0];
        System.out.println(pt.getRawType()+";"+pt.getActualTypeArguments()[0]);
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


    public static void main(String[] args) throws NoSuchMethodException {
        UserDao userDao = new UserDao();
        Method method = userDao.getClass().getMethod("add", User.class);
        Type[] types = method.getGenericParameterTypes();
        for(Type actualTypeArgument: types) {
            System.out.println(actualTypeArgument);
        }

    }
}


//限定  泛型类型变量
// 泛型, 太泛了也不行
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
     * comparable 明明是一个接口, 但是却用的extends????????
     * java-core  P533有这么一段话做解释：
     * <T extands BoundingType> 表示T应该是绑定类型的子类型（subType）。
     * T和绑定类型可以是类，也可以是接口。
     * 选择关键字extands的原因是更接近子类的概念，并且java的设计者也不打算在语言中添加一个新的关键字  如sub ;
     * 所以，这里的泛型用<T extends Interface>中extends　的关键字的意思，其实是在给泛型设置限定（bound）的时候, 让extends = extends or implements.
     */
    private static <E extends Comparable<E>> E getMin(E a, E b) {
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

        System.out.println();

        //这个方法之所以能这么用, 就是因为 sky 实现了comparable 接口, 并且comparable< User >  ;
        User min2 = GenericRestrict.getMin(sky, land);
        System.out.println(min2.toString());

    }


}


//----------------泛型 通配符类型  -------------------------

/*
*
1,<? extends Parent> 指定了泛型类型的上届
2,<? super Child> 指定了泛型类型的下届
3, <?> 指定了没有限制的泛型类型
*
* */


class Food {
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Fruit extends Food {
    @Override
    public String getColor() {
        return "水果有颜色吗??";
    }
}


class Mongo extends Fruit {
    @Override
    public String getColor() {
        return "我是芒果, 皮是绿色的, 心是黄的";
    }
}


class ChinaMongo extends Mongo {
    @Override
    public String getColor() {
        return "我是中国黄, 皮是黄色的, 心里也是黄色的";
    }
}


class Orange extends Fruit {
    @Override
    public String getColor() {
        return "我是橘黄色";
    }
}


class GenericFood {

    private static void print(GenericClass<Fruit> fruitGenericClass) {
        Fruit fruit = new Fruit();

        fruitGenericClass.setData(fruit);
        System.out.println(fruitGenericClass.getData().getColor());
    }

    private static void use() {

        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        print(fruitGenericClass);
        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
        //类型不匹配,可以使用<? extends Parent> 来解决
        //print(orangeGenericClass); //print (com.generic.GenericClass<com.generic.Fruit>) in GenericFood cannot be applied to (com.generic.GenericClass<com.generic.Orange>)
        //因为print 方法指定了泛型类型变量类型, 它的这个T指定了fruit,  so 它不能 指定别的泛型类型变量

    }


    /**
     * <? extends Parent> 指定了泛型类型的上届, 只要 泛型类型变量是 fruit 的子类都可以使用这个方法
     */
    private static void printExtends(GenericClass<? extends Fruit> genericClass) {
        System.out.println(genericClass.getData().getColor()); //父类有这个属性
    }

    private static void useExtend() {

        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        fruitGenericClass.setData(new Fruit());
        printExtends(fruitGenericClass);
        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
        orangeGenericClass.setData(new Orange());
        printExtends(orangeGenericClass);

        GenericClass<Food> foodGenericClass = new GenericClass<>();
        foodGenericClass.setData(new Food());

        //Food是Fruit的父类，超过了泛型上届范围，类型不匹配
        //printExtends(foodGenericClass);

    }


    /**
     * <? super Child> 指定了泛型类型的下届
     */
    public static void printSuper(GenericClass<? super Mongo> genericClass) {
        /// System.out.println(genericClass.getData().getColor()); //子类可没有这种属性
        System.out.println(genericClass.getData());
    }

    public static void useSuper() {
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        printSuper(foodGenericClass);

        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        printSuper(fruitGenericClass);


        GenericClass<Mongo> mongoGenericClass = new GenericClass<>();
        printSuper(mongoGenericClass);


        //下限就是mongo, 不能再下了
        GenericClass<ChinaMongo> chinaMongoGenericClass = new GenericClass<>();
        //printSuper(chinaMongoGenericClass);

        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
        // Orange和mongo是兄弟关系，没有继承关系，类型不匹配
        //printSuper(orangeGenericClass);

    }


    /**
     * <?> 指定了没有限定的通配符
     */
    public static void printNonLimit(GenericClass<?> genericClass) {

        //System.out.println(genericClass.getData().getColor()); //太泛了, ? 甚至都不知道有没有color 这个属性和它相应的方法
        System.out.println(genericClass.getData());
    }

    public static void useNonLimit() {

        GenericClass<Food> foodGenericClass = new GenericClass<>();
        foodGenericClass.setData(new Food());
        printNonLimit(foodGenericClass);
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        fruitGenericClass.setData(new Fruit());
        printNonLimit(fruitGenericClass);

        GenericClass<?> genericClass = new GenericClass();  //带 ?号  的就不能set
        // genericClass.setData(new Object());
        GenericClass genericClass1 = new GenericClass();  //不带? 号  的就可以
        genericClass1.setData(new Object());
        //setData 方法不能被调用， 甚至不能用 Object 调用；
//        genericClass.setData(foodGenericClass);
//        genericClass.setData(new Object());   // setData  (capture<?>) in GenericClass cannot be applied to (java.lang.Object)  
        //返回值只能赋给 Object
        Object object = genericClass.getData();

    }


    public static void main(String[] args) {
        //useExtend();
        useNonLimit();
    }


}


//--------------------获取泛型的参数类型 -----------------------------------
    /*Type体系中类型的包括：数组类型(GenericArrayType)、参数化类型(ParameterizedType)、类型变量(TypeVariable)、通配符类型(WildcardType)、
    原始类型(Class)、基本类型(Class), 以上这些类型都实现Type接口.*/
interface ParameterizedType extends Type {

    // 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer]
    Type[] getActualTypeArguments();

    //返回当前class或interface声明的类型, 如List<?>返回List
    Type getRawType();

    //返回所属类型. 如,当前类型为O<T>.I<S>, 则返回O<T>. 顶级类型将返回null
    Type getOwnerType();

}


class Client {


    public static void main(String[] args) {

        GenericClass<String> stringGenericClass = new GenericClass<>();
        Type superclass = stringGenericClass.getClass().getGenericSuperclass();
        //getActualTypeArguments 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        System.out.println(type);//class java.lang.String

    }

}


/**
 * Author：Jay On 2019/5/11 21:05
 * <p>
 * Description: 泛型相关的工具类
 */
class GenericUtils {

    public static class Movie {
        private String name;
        private Date time;

        public String getName() {
            return name;
        }

        public Date getTime() {
            return time;
        }

        private Movie(String name, Date time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Movie{" + "name='" + name + '\'' + ", time=" + time + '}';
        }
    }


    /**
     * 对任意集合的排序方法
     *
     * @param targetList 要排序的实体类List集合
     * @param sortField  排序字段
     * @param sortMode   true正序，false逆序
     */
    private static <T> void sortAnyList(List<T> targetList, final String sortField, final boolean sortMode) {
        if (targetList == null || targetList.size() < 2 || sortField == null || sortField.length() == 0) {
            return;
        }
        Collections.sort(targetList, new Comparator<Object>() {
            @Override
            public int compare(Object obj1, Object obj2) {
                int retVal = 0;
                try {
                    // 获取getXxx()方法名称
                    String methodStr = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);
                    Method method1 = ((T) obj1).getClass().getMethod(methodStr, null);
                    Method method2 = ((T) obj2).getClass().getMethod(methodStr, null);
                    if (sortMode) {
                        retVal = method1.invoke(((T) obj1), null).toString().compareTo(method2.invoke(((T) obj2), null).toString());
                    } else {
                        retVal = method2.invoke(((T) obj2), null).toString().compareTo(method1.invoke(((T) obj1), null).toString());
                    }
                } catch (Exception e) {
                    System.out.println("List<" + ((T) obj1).getClass().getName() + ">排序异常！");
                    e.printStackTrace();
                }
                return retVal;
            }
        });
    }


    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            movieList.add(new Movie("movie" + i, new Date()));
        }
        System.out.println("排序前:" + movieList.toString());

        GenericUtils.<Movie>sortAnyList(movieList, "name", true);
        System.out.println("按name正序排：" + movieList.toString());

        GenericUtils.sortAnyList(movieList, "name", false);
        System.out.println("按name逆序排：" + movieList.toString());
    }
}











