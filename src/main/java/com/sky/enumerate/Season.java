package com.sky.enumerate;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/5/8
 */

//自定义枚举类
public class Season{
    //jdk 5 之前, Java没有枚举, 只能自己定义一个枚举类来充当枚举的功能
    //枚举的特点是它的类是固定数量的, 定死的


    //1.声明Season对象的属性: private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器 并给对象属性初始化
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3. 提供当前枚举类的多个对象：public static final 修饰
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "银装素裹");

    //4. 其他诉求1： 获取枚举类对象的属性(由于final 修饰 则没有set 方法)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4. 其他诉求2：提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ",seasonDesc='" + seasonDesc + '\'' +
                "}";
    }

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }


}

