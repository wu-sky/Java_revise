package com.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by admin on 2019/5/14.
 */
public class Target {
    private String privateName;
    //注意: 常理来说在本类外面是无法访问到private的, 但是反射就是那么强大
    public String publicName;
    //为什么Javabean规范必须必须有无参构造函数, 自己调用自己, 创建的对象就是调用无参构造器,
    // 有参的没法做成框架, 因为不懂你里面是什么参数.
    public Target() {
    }
    public Target(String privateName) {

        this.privateName = privateName;
        System.out.println("我是有参构造器, "+privateName);
    }//构造器重载没有overload

    @Override
    public String toString() {
        return "Target{" +
                "privateName='" + privateName + '\'' +
                ", publicName='" + publicName + '\'' +
                '}';
    }

    public void  print(){

        System.out.println("调用的是public 的无参成员函数");
    }

    public void   print(String what ){

        System.out.println("有参成员函数: 调"+what);



    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }


    /**opClassName
     * 抓取类名
     */
    public static void opClassName() {

        Class<?> target1=null;//这个东西, 我也不知道是哪个类的对象
        Class<?> target2=null;
        Class<?> target3=null;
        target1=new Target().getClass();//为什么乐哥说的每个Javabean要有一个无参构造函数
        target2= Target.class;

        try {
            String classname="classname";//这个类名写不对就会报异常
            target3=Class.forName(classname);
            System.out.println("classname:"+target3);
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            String classname="reflection.Target";//必须写全路径, 否则也是报异常
            //自己抓自己, 有些人会问, 我都知道类名了直接new不就完事了吗?
            // 但是! 不改动代码的情况下, 你根本无法创建出来. 而且你有没有看到, 这个是以字符串为载体的, 我是不是想写什么就写什么啊.
            //若我把类名路径作为一个字符串, 存在database/file里面,  我用反射就能调用这个类, 你的jdbc, spring ioc就是用这种方法.
            target3=Class.forName(classname);
            System.out.println("target3:"+target3);
        }catch (Exception e){
            System.out.println(e);
        }


        System.out.println("target1:"+target1);
        System.out.println("target2.getPrivateName():"+target2.getName());

    }

    /**
     * opClassfield
     *  抓取属性字段
     *
     */
    public static void opClassfield() {
        Class<?> target=null;
        try {
            target=Class.forName("reflection.Target");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("------------target类的所有属性---------");
        Field[] fieldAll=target.getDeclaredFields();//这个方法连private都可以get到
        for (int i = 0; i <fieldAll.length; i++) {
            int modifier=fieldAll[i].getModifiers();//直接获取访问控制修饰符返回的是一个int型
            String authority= Modifier.toString(modifier);//这句把modifier从int型翻译成访问控制String
            Class<?> type=fieldAll[i].getType();
            System.out.println(authority + " " + type.getName() + " " + fieldAll[i].getName());
        }

        System.out.println("---------获取target类的公有属性----------");
        Field[] fs=target.getFields();
        for(Field f:fs){
            System.out.println(f.getModifiers()+"  "+f.getName()+"  "+f.getType());//1 代表public
        }

        System.out.println("----------根据指定名字获取属性-----------");
        try {

            // 调一调私有属性privateName 结果是java.lang.NoSuchFieldException: privateName
            // Field fieldSingle=target.getField("privateName");
            //调一调私有属性privateName, declare这个可以有
            Field fieldSingle=target.getDeclaredField("privateName");
            System.out.println(fieldSingle.getModifiers()+"  "+fieldSingle.getName()+"  "+fieldSingle.getType());
            fieldSingle.setAccessible(true);
            Constructor constructor=target.getConstructor(String.class);
            Target t=(Target)constructor.newInstance("我卢本伟真的没有开挂");
            fieldSingle.set((Target)t,"艹尼玛");
            System.out.println(t.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
        opClassMethods
     */
    public static void opClassMethods(String[] args) {
        Class<?> target=null;
        try {
            target=Class.forName("reflection.Target");
            System.out.println("----------抓取单个的method-----------");
            Method method=target.getMethod("print");//抓取类的无参方法
            method.invoke(target.newInstance());//调用抓取的方法
            //注意:调用有参方法的时候getmethod(方法名, 参数类.class);
            method=target.getMethod("print" , String.class);
            method.invoke(target.newInstance(), "尼玛");

            System.out.println("----------抓取全部的method-----------");
            Method methods[]=target.getMethods();
            for(Method m: methods){
                Class<?>[] pt=m.getParameterTypes();//获得构造器的参数列表类型[可能有String, int, boolean...]
                //System.out.println(m.getParameterCount());//参数个数
                String s="";
                for (Class<?> p:pt){
                    s+=p.getName()+", ";//类型是什么?? 一个个调出来它们的类型名称
                }
                System.out.println(Modifier.toString(m.getModifiers())+" "+m.getReturnType() +" "+m.getName()+"("+s+")");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 抓target类的构造器
     * opClassConstructors
     * @param args
     * result:
     * public reflection.Target()
       public reflection.Target(java.lang.String, )
     */
    public static void opClassConstructors(String[] args) {
        try {
            Class<?> target=Class.forName("reflection.Target");
            Constructor<?>[] constructors=target.getConstructors();
            //String.class是获取String的class对象, 注意这个是类对象不是普通对象
            Constructor<?> conSingle=target.getConstructor(String.class);
            Target t=(Target)conSingle.newInstance("我被调用了");//通过反射不new却能创建一个对象
            for(Constructor<?> c:constructors){
                //用一个类型容器去装这些类型的类
                Class<?>[] ps=c.getParameterTypes();//获得构造器的参数列表类型[可能有String, int, boolean...]
               System.out.println("参数个数是: "+c.getParameterCount());//参数个数
                String s="";
                for (Class<?> p:ps){
                    s+=p.getName()+", ";//类型是什么?? 一个个调出来它们的类型名称
                }

                System.out.println(Modifier.toString(c.getModifiers())+" "+c.getName()+"("+s+")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        opClassName();
    }
}




/**
 * alt+7 show outline
 * ctrl+= expand code
 * CTRL+-= collapse code
 */
