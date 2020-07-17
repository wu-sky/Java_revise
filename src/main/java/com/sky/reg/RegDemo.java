package com.sky.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : wushikai
 * <p>
 * date : 2020-07-17
 */
public class RegDemo {


    //Java 中的正则和 js 不一样 , Java没有 reg 对象, 它使用 java.util.regex 包下的Pattern ,Matcher 类
    public static void main(String[] args){

        String content = "I am noob   from runoob.com.";

        String reg = "^.*noob.*$";

        boolean isMatch = false;
        //Pattern.matches(reg, content);

        Pattern p = Pattern.compile(reg);

        Matcher m = p.matcher(content);

        isMatch= m.matches();

        System.out.println("isMatch = " + isMatch);



        //字符串判断------------------------------------------------------
        //判断是否只是数字
        String regNum="^\\d*$";
        String numStr="1234567";
        String errorStr = "1234567aa";
        System.out.println("Pattern.matches( regNum,numStr) = " + Pattern.matches(regNum, numStr));
        System.out.println("Pattern.matches(regNum, errorStr) = " + Pattern.matches(regNum, errorStr));


        //使用字符串去匹配正则字符串;
        System.out.println("numStr.matches(regNum) = " + numStr.matches(regNum));


        //--------------------------------------------------------------




        //字符串替换 --------------------------------------------------------
        //String 中的替换方法, 底层调用的也是正则表达式
        String str1 = errorStr.replace("aa", "bb"); //String 的这个方法底层 使用的就是 正则
        System.out.println("replace = " + str1);
        //------------------------------------------------------------------



        //字符串拆分-----------------------------------------------------------
        //String 的拆分方法
        String ipStr= "192.168.1.128";
        String regSplit ="\\.";
        String[] splitStrings = ipStr.split(regSplit);  //这个底层调用的也是正则
        for (String str : splitStrings){
            System.out.println("str = " + str);
        }

    }


















}
