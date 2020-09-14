package com.sky.str;

import org.junit.Test;

import java.util.Random;

/**
 * @author : wushikai
 * <p>
 * date : 2020-09-05
 */
public class PrintColor {

    public static void main(String[] args) {
        System.out.println("\033[30;1m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[31;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[32;3m" + "我是什么颜色; what color I am??" + "\033[3m");
        System.out.println("\033[33;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[34;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[35;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[36;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[37;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[40;31;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[41;32;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[42;33;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[43;34;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[44;35;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[45;36;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[46;37;4m" + "我是什么颜色??" + "\033[0m");
        System.out.println("\033[47;4m" + "我是什么颜色??" + "\033[0m");
        printColor();

    }

    /**
     * // 背景颜色代号(41-46)
     *         // 前景色代号(31-36)
     *         //前景色代号和背景色代号可选，就是或可以写，也可以不写
     *         // 数字+m：1加粗；3斜体；4下划线
     *         // 格式：System.out.println("\33[前景色代号;背景色代号;数字m");
     *
     *
     *         */
    @Test
    public void test1(){

        System.out.format("\033[44;32;4m我是博主%n");//%n表示换行

    }






    public static void printColor() {
        // 背景颜色代号(41-46)
        // 前景色代号(31-36)
        //前景色代号和背景色代号可选，就是或可以写，也可以不写
        // 数字+m：1加粗；3斜体；4下划线
        // 格式：System.out.println("\33[前景色代号;背景色代号;数字m");
        Random backgroundRandom = new Random();
        Random fontRandom = new Random();
        for (int i = 1; i <= 50; i++) {
            int font = fontRandom.nextInt(6) + 31;
            int background = backgroundRandom.nextInt(6) + 41;
            System.out.format("前景色是%d,背景色是%d------\33[%d;%d;4m我是博主%n", font, background, font, background);
        }
    }
}
