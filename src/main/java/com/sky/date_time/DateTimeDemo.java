package com.sky.date_time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : wushikai
 * <p>
 * date : 6/2/2020
 */
public class DateTimeDemo {

    /*2.java.sql.Date与java.sql.Timestamp相互转换

java.sql.Date--->java.sql.Timestamp
      new java.sql.Timestamp(yourDate.getTime());

       java.sql.Timestamp-->java.sql.Date
       new java.sql.Date(yourTimestamp.getTime());*/


    public static void timeStamp2Str() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());//获取系统当前时间
        System.out.println("timestamp.toString() = " + timestamp.toString());

        //使用SimpleDateFormat格式化timestamp即可
        String timestampStr = simpleDateFormat.format(timestamp);

        System.out.println("timestampStr = " + timestampStr);
    }


    public static void str2timeStamp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(new Date());
        System.out.println("timeStr = " + timeStr);
        Timestamp timestamp = Timestamp.valueOf(timeStr);
        System.out.println("timestamp.toString() = " + timestamp.toString());
    }

    public static void timestamp2Date() {
        //public class Timestamp extends java.util.Date {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println("timestamp.toString() = " + timestamp.toString());


        //public class Date extends java.util.Date {
        java.sql.Date date = new java.sql.Date(new Date().getTime());

        System.out.println(new Date().getTime());

    }


    public static void main(String[] args) {
        timeStamp2Str();
        str2timeStamp();
        timestamp2Date();
    }


}
