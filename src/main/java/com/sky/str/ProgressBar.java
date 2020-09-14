package com.sky.str;

import org.junit.Test;

/**
 * @author : wushikai
 * <p>
 * date : 2020-09-05
 */
public class ProgressBar {



    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <= 100; i++) {
            printSchedule(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



      //  demo();
     /*   System.out.println("=====================================================");
        printPercent();
        System.out.println("====================================================");
        System.out.println();
        printSchedule(100);*/
    }



    public  static void printPercent ( ) throws InterruptedException {

        String str ="";
        for (int i = 0; i <= 100; i++) {
            str=i+"%";
            System.out.print(str);
            Thread.sleep(100);
            for (int j = 0; j < str.length(); j++) {
                System.out.print("\b");
            }

        }
        System.out.print(str);
        System.out.println();


    }



    /**
     * 进度条总长度
     */
    private static int TOTLE_LENGTH = 40;
    /**
     * 整体的思想就是:每一遍都是使用字符去填充, 然后整行删掉; 再填充数据, 再删掉;
     *
     *     >             10%
     *     整行删掉
     *    >>             20%
     *    整行删掉
     *    >>>            30%
    *     ....
     *    >>>>>>>>>>     100%
    * */
    public static void printSchedule(int percent){
        for (int i = 0; i < TOTLE_LENGTH + 5; i++) { //40  + 5 是因为 100%这个字符必须删掉
            System.out.print("\b");
        }
        //░▒
        int now = TOTLE_LENGTH * percent / 100;
        for (int i = 0; i < now; i++) {
            System.out.print(">");
        }
        for (int i = 0; i < TOTLE_LENGTH - now; i++) {
            System.out.print(" ");
        }
        System.out.print("  " + percent + "%");
    }



    /*关键是  \b 是转义字符, 功能是 ⬅ 删掉一个字符 */
    public  static void demo  ( ) throws InterruptedException {
        System.out.print("a");
        Thread.sleep(3000);
        System.out.print("\b");

    }
}
