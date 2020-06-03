package com.sky.encryption;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author 吴世凯 邮箱：https://www.cnblogs.com/Free-Thinker/p/10007503.html
 * 日期：09/05/2020
 * BASE64
 * 按 照RFC2045的定义，Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式。
 * （The Base64 Content-Transfer-Encoding is designed to represent arbitrary sequences of octets in a form that
 * need not be humanly readable.）
 * 常见于邮件、http加密，截取http信息，你就会发现登录操作的用户名、密码字段通过BASE64加密的
 */
public class Base64Demo {

    public static byte[] decodeBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }


    public static String encodeBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 等号非常特殊，因为base64是三个字节一组 ，如果当我们的位数不够的时候，会使用等号来补齐
     */
    public  static void base64Padding ( ){
        //  1：MQ== 表示一个字节，不够三个字节，所以需要后面通过 == 号补齐
        System.out.println(Base64.encode("1".getBytes()));
        System.out.println(Base64.encode("12".getBytes()));
        System.out.println(Base64.encode("123".getBytes()));
        // 硅谷:中文占6个字节，6 * 8 = 48 ，刚刚好被整除，所以没有等号
        System.out.println(Base64.encode("硅谷".getBytes()));

    }

    public static void main(String[] args) {
        base64Padding();
    }


}
