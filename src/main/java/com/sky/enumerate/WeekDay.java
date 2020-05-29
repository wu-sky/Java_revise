package com.sky.enumerate;

import java.lang.annotation.Native;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/5/8
 */
public class WeekDay {

    private String weekName;
    private Integer weekNum;
    private String weekDescription;

    public static WeekDay MONDAY = new WeekDay("星期1", 1, "开始上班了;");
    public static WeekDay TUESDAY = new WeekDay("星期2", 2, "累的像条狗;");
    public static WeekDay WEDNESDAY = new WeekDay("星期3", 3, "累的像条狗;");
    public static WeekDay THURSDAY = new WeekDay("星期4", 4, "累的像条狗;");
    public static WeekDay FRIDAY = new WeekDay("星期5", 5, "终于到周五了;");
    public static WeekDay SATURDAY = new WeekDay("星期6", 6, "睡上一天;");
    public static WeekDay SUNDAY = new WeekDay("星期日", 7, "工作没搞完;");


    private WeekDay(String weekName, Integer weekNum, String weekDescription) {
        this.weekName = weekName;
        this.weekNum = weekNum;
        this.weekDescription = weekDescription;
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "weekName='" + weekName + '\'' +
                ", weekNum=" + weekNum +
                ", weekDescription='" + weekDescription + '\'' +
                '}';
    }
}

class test {
    /**
     * jdk中常用的枚举
     *     @Native public static final int   MIN_VALUE = 0x80000000;
           @Native public static final int MAX_VALUE = 0x7fffffff;
     */
    public static void main(String[] args) {
        // int i=Integer.digits.length;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(WeekDay.FRIDAY.toString());
    }
}