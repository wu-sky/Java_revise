package com.sky.str;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/26/2020
 */
public class StringRevise {



    public  static void judgeContain ( ){

        String  str = "包含收银宝账号，如：大龙火锅盛天地店，990611063006001";

        System.out.println(        str.indexOf("990611063006001") != -1 );

    }









    public static void codeStr() throws UnsupportedEncodingException {

        String str1=new String("123abc伍思凯");
        System.out.println("str1.getBytes(utf-8) = " + Arrays.toString(str1.getBytes(StandardCharsets.UTF_8)));
        System.out.println("str1.getBytes(gbk) = " + Arrays.toString(str1.getBytes("gbk")));
        byte[] bytes={49, 50, 51, 97, 98, 99, -28, -68, -115, -26, -128, -99, -27, -121, -81};
        String str2=new String(bytes);
        System.out.println("str2 = " + str2);
        bytes=new byte[]{49, 50, 51, 97, 98, 99, -50, -23, -53, -68, -65, -83};
        str2=new String(bytes, "gbk");
        System.out.println("str2 = " + str2);

    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        //codeStr();
        ///databaseField2JavaField();

        String  str = "包含收银宝账号，如：大龙火锅盛天地店，990611063006001";

        System.out.println(        str.indexOf("990611063006001") != -1 );


        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.get(0));

        String str1 = "abc";
        String str2 = "abc";
        System.out.println( str1.contains(str2));



    }

}
