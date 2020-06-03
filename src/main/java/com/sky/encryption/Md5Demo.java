package com.sky.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author：吴世凯 邮箱：https://www.cnblogs.com/Free-Thinker/p/10007503.html
 * 日期：09/05/2020
 */
public class Md5Demo {
    /**
     * MD5加密
     *通常我们不直接使用上述MD5加密。通常将 MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串。
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("KEY_MD5");
        md5.update(data);

        return md5.digest();

    }


    public static String getMD5(String str, int length) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");//获取MD5实例
            messageDigest.update(str.getBytes());//此处传入要加密的byte类型值
            byte[] digest = messageDigest.digest();//此处得到的是md5加密后的byte类型值

            /*
               下边的运算就是自己添加的一些二次小加密，记住这个千万不能弄错乱，
                   否则在解密的时候，你会发现值不对的（举例：在注册的时候加密方式是一种，
                在我们登录的时候是不是还需要加密它的密码然后和数据库的进行比对，但是
            最后我们发现，明明密码对啊，就是打不到预期效果，这时候你就要想一下，你是否
             有改动前后的加密方式）
            */
            int i;

            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    sb.append(0);
                sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
            }
            return sb.toString().substring(0, length);//从下标0开始，length目的是截取多少长度的值
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void encryptByMd5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());//update处理
            byte [] encryContext = messageDigest.digest();//调用该方法完成计算

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i)); //数字转成16进制符号
            }
            System.out.println("32result: " + buf.toString());// 32位的加密
            System.out.println("16result: " + buf.toString().substring(8, 24));// 16位的加密
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String str="devName=my_device&merId=15e39ae372444ec2a3b8e65b9dccba1a&proKey=a1n4vb9ELL3&reqTime=2020-05-11 02:28:474&signType=MD5&storeId=0084a912d651452ba820252ae531b5c1&userId=15d0cb80-0400-45ab-8442-86ada036d97d&version=1.0&DES_KEY=011490";
        String str1="devName=my_device&proKey=a1n4vb9ELL3&reqTime=2020-05-11 02:28:474&signType=MD5&userId=15d0cb80-0400-45ab-8442-86ada036d97d&version=1.0&DES_KEY=011490";
       String sign=getMD5(str1, 32);
       System.out.println("sign = \n" + sign.toUpperCase());
      //  encryptByMd5("version=1.0&signType=MD5&proKey=a1n4vb9ELL3&devName=my_device&merId=15e39ae372444ec2a3b8e65b9dccba1a&storeId=0084a912d651452ba820252ae531b5c1&userId=15d0cb80-0400-45ab-8442-86ada036d97d");
      //  System.out.println(sign.toUpperCase());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");
        String format = simpleDateFormat.format(date);
       // System.out.println("format = " + format);

        System.out.println(Integer.toHexString(15));


    }/* 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'*/



}
