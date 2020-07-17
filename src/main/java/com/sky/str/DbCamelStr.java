package com.sky.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : wushikai
 * <p>
 * date : 5/30/2020
 */
public class DbCamelStr {


    /**
     * 驼峰和下划线互转, 看上去容易, 其实真不好写
     */
    public  static void databaseField2JavaField ( ){

        ArrayList<String> stringsDb = new ArrayList<>();
        stringsDb.add("create_day");
        stringsDb.add("freeze_reason");
        stringsDb.add("syb_flag");
        stringsDb.add("syb_verify_status");
        stringsDb.add("merchant_short_name");



        ArrayList<String> stringsJava = new ArrayList<>();
        for (String str: stringsDb){

            System.out.println("字符串===> " + str);
            for(int index=0;index< str.length();index++){
           /*     String resultStr=new String();
                if(str.charAt(index)=='_'){
                    System.out.println("位置是:"+index);
                    char c = str.charAt(index + 1);
                    char c1 = Character.toUpperCase(c);
                    str = str.replace(c, c1);


                }*/
                StringBuilder builder = new StringBuilder();
                Arrays.asList(str.split("_")).forEach(temp -> builder.append((temp).toUpperCase()));
                str= builder.toString();
            }
            // str = str.replace("_", "");
            stringsJava.add(str);
        }
        System.out.println(stringsJava);


    }



    private static Pattern AZ_PATTERN = Pattern.compile("[A-Z]");
    private static Pattern UNDERLINE_PATTERN = Pattern.compile("_([a-z])");
    public static String toCamelStr(String str) {
        //正则匹配下划线及后一个字符，删除下划线并将匹配的字符转成大写
        Matcher matcher = UNDERLINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配的子串替换成指定字符串，并且将替换后的子串及之前到上次匹配的子串之后的字符串添加到StringBuffer对象中
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            //把之后的字符串也添加到StringBuffer对象中
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        return toCamelStr(sb.toString());
    }


    /**
     * 将驼峰格式字符串转下划线格式
     * @param str string 待处理字符串
     * @return string 处理结果
     */
    public static String toDbStr(String str) {
        //正则匹配大写字符转成小写并在前面加上下划线
        Matcher matcher = AZ_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配的子串替换成指定字符串，并且将替换后的子串及之前到上次匹配的子串之后的字符串添加到StringBuffer对象中
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            //把之后的字符串也添加到StringBuffer对象中
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        return toDbStr(sb.toString());
    }

}
