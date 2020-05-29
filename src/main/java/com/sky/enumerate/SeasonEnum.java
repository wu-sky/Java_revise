package com.sky.enumerate;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/5/8
 */
public enum SeasonEnum {


    //1. 提供当前枚举类的对象，多个对象间用逗号隔开，末尾对象用分号结束;
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "银装素裹");

    //2.声明Season对象的属性: private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器 并给对象属性初始化
    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4. 其他诉求1： 获取枚举类对象的属性(由于final 修饰 则没有set 方法)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    public static void main(String[] args){
    /*    Season spring = Season.SPRING;
        System.out.println(spring); //打印 SPRING 对象名字
        System.out.println(Season.class.getSuperclass()); //打印 Season 父类

        // values()：返回枚举类型的对象数组;该方法可以很方便地遍历所有的枚举值;
        Season[] values = Season.values();
        for(int i = 0 ;i<values.length;i++){
            System.out.println(values[i]);
        }

        //valueOf(String str):可以把一个字符串转为对应的枚举类对象;要求字符串必须是枚举类对象的“名字”;如不是，会有运行时异常;
        Season winter = Season.valueOf("WINTER");
        System.out.println(winter); //返回枚举类中对象名是 str 的对象*/
    }

}
