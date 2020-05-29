package com.sky.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author：吴世凯 邮箱：https://www.cnblogs.com/Free-Thinker/p/10007503.html
 * 日期：09/05/2020
 * BASE64
 * 按 照RFC2045的定义，Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式。
 * （The Base64 Content-Transfer-Encoding is designed to represent arbitrary sequences of octets in a form that
 * need not be humanly readable.）
 * 常见于邮件、http加密，截取http信息，你就会发现登录操作的用户名、密码字段通过BASE64加密的
 */
public class Base64Demo {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }


    public static void main(String[] args) {
        try {
            String encryptBASE64 = encryptBASE64("caonima".getBytes());
            System.out.println("encryptBASE64 = " + encryptBASE64);
            byte[] bytes = decryptBASE64("caonima");
            System.out.println("bytes = " + new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
