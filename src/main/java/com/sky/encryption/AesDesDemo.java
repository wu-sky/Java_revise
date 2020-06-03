package com.sky.encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：2020/6/1
 */
public class AesDesDemo {

    //原文
    static String data = "name=伍思凯&password=12345";
    //加密密钥  DES加密密钥字符串规定长度是8, AES的秘钥规定是16位秘钥
    static final String DES_KEY = "12345678";

    static final String AES_KEY = "1234567812345678";
    //加密算法
    static final String ALGORITHM_DES = "DES";
    static final String ALGORITHM_AES = "AES";
    static final String AES_TRANSFORMATION="AES/CBC/PKCS5Padding"; //使用这个, 不管是加密还是解密, 都只能用同一个cipher 对象
    //加密对象
    static Cipher cipher;


    //加密规则, 参数1: 密钥的字节, 参数2: 加密算法
    static SecretKeySpec secretKeySpec = new SecretKeySpec(DES_KEY.getBytes(), ALGORITHM_DES);
    static SecretKeySpec secretKeySpecAES = new SecretKeySpec(AES_KEY.getBytes(), ALGORITHM_AES);


    public static String encryptDES() throws BadPaddingException,
            IllegalBlockSizeException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException {
        //获取cipher实例
        cipher = Cipher.getInstance(ALGORITHM_DES);

        //初始化加密类对象
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);


        byte[] bytes = cipher.doFinal(data.getBytes());
        System.out.println("有乱码的密文String =" + new String(bytes));
        //如果出现乱码证明有些字符如  -53  -16   不能映射成utf-8编码字符串 它会自动映射成这个字符==>  65533 �
        System.out.print("密文bytes =");
        for (byte b:bytes){
            System.out.print(String.valueOf(b)+ "  " );
        }
        System.out.println();

        //这个时候需要base64编码
        //jdk自带的base64问题太多, 最好用apache的
     /*   Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(bytes);
        System.out.println(new String(decode));*/
        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        System.out.println("经过base64转码之后, 可以阅读的密文String="+ new String(encodeBase64));

        //想一想, 如果有乱码, 数据究竟改如何传输???????
        return new String(encodeBase64);

    }
    public static void decryptDES(String encryptionStr) throws BadPaddingException,
            IllegalBlockSizeException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException {
        //获取cipher实例
        cipher = Cipher.getInstance(ALGORITHM_DES);

        //初始化加密类对象
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decodeBase64 = Base64.decodeBase64(encryptionStr.getBytes());

        byte[] bytes = cipher.doFinal(decodeBase64);
        System.out.println("原文解密String=" + new String(bytes));
        //如果出现乱码证明有些字符如  -53  -16   不能映射成utf-8编码字符串 它会自动映射成这个字符==>  65533 �
        System.out.print("bytes =");
        for (byte b:bytes){
            System.out.print(String.valueOf(b)+ "  " );
        }
        System.out.println();

    }

    public static String encryptAES() throws BadPaddingException,
            IllegalBlockSizeException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException {
        //获取cipher实例, 获取实例的参数不光是算法 名, 还可以包含 填充方式
        cipher = Cipher.getInstance(ALGORITHM_AES);

        //初始化加密类对象
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpecAES);


        byte[] bytes = cipher.doFinal(data.getBytes());
        System.out.println("有乱码的密文String =" + new String(bytes));
        //如果出现乱码证明有些字符如  -53  -16   不能映射成utf-8编码字符串 它会自动映射成这个字符==>  65533 �
        System.out.print("密文bytes =");
        for (byte b:bytes){
            System.out.print(String.valueOf(b)+ "  " );
        }
        System.out.println();

        //这个时候需要base64编码
        //jdk自带的base64问题太多, 最好用apache的
     /*   Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(bytes);
        System.out.println(new String(decode));*/
        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        System.out.println("经过base64转码之后, 可以阅读的密文String="+ new String(encodeBase64));

        //想一想, 如果有乱码, 数据究竟改如何传输???????
        return new String(encodeBase64);

    }
    public static void decryptAES(String encryptionStr) throws BadPaddingException,
            IllegalBlockSizeException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException {
        //获取cipher实例
        cipher = Cipher.getInstance(ALGORITHM_AES);

        //初始化加密类对象
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecAES);

        byte[] decodeBase64 = Base64.decodeBase64(encryptionStr.getBytes());

        byte[] bytes = cipher.doFinal(decodeBase64);
        System.out.println("原文解密String=" + new String(bytes));
        //如果出现乱码证明有些字符如  -53  -16   不能映射成utf-8编码字符串 它会自动映射成这个字符==>  65533 �
        System.out.print("bytes =");
        for (byte b:bytes){
            System.out.print(String.valueOf(b)+ "  " );
        }
        System.out.println();

    }


    public static void main(String[] args) throws Exception {

        decryptDES(encryptDES());
        decryptAES(encryptAES());
    }

}

/*
 * p18中,  DES加密密钥字符串规定长度是8
 * 伍思凯对应的utf-8 字节数字:  -28  -68  -115  -26  -128  -99  -27  -121  -81
 * */