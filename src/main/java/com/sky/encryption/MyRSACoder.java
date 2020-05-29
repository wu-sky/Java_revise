package com.sky.encryption;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher; //一般来说这个是jdk里面的类, 为什么分开出来了


/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/27/2020
 * 一些关键英语和概念
 * Cipher [saifer]  密码 cipher code  用户密码/口令 password
 * Cryptographic [qui pik gra phic]  密码学
 *
 *
 * java中的Cipher类  此类为加密和解密提供密码功能。它构成了 Java Cryptographic Extension (JCE) 框架的核心
 *
 *  PKCS==> The Public-Key Cryptography Standards (PKCS)是由美国RSA数据安全公司及其合作伙伴制定的一组公钥密码学标准，
 * 其中包括证书申请、证书更新、证书作废表发布、扩展证书内容以及数字签名、数字信封的格式等方面的一系列相关协议
 *  https://baike.baidu.com/item/PKCS/1042350?fr=aladdin
 *
 *  X.509==> 是密码学里公钥证书的格式标准 https://baike.baidu.com/item/X.509?fromtitle=x509
 *
 *
 */

public class MyRSACoder {
    //非对称密钥算法
    public static final String KEY_ALGORITHM = "RSA";
    /**
     * 密钥长度，DH算法的默认密钥长度是1024
     * 密钥长度必须是64的倍数，在512到65536位之间
     */
    private static final int KEY_SIZE = 512;
    //公钥
    private static final String PUBLIC_KEY = "我是公钥";

    //私钥
    private static final String PRIVATE_KEY = "我是私钥";

    /**
     * 初始化密钥对
     *
     * @return Map 甲方密钥的Map
     */
    public static Map<String, Object> initKey() throws Exception {


        //创建和初始化 密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(KEY_SIZE); //必须有密钥长度


        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();


        //甲方公钥 接获取的是没处理过的公钥
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic(); //Exponent 指数
        System.out.println("公钥系数:" + rsaPublicKey.getModulus() + "  加密指数：" + rsaPublicKey.getPublicExponent());

        //甲方私钥 接获取的是没处理过的私钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        System.out.println("私钥系数:" + rsaPrivateKey.getModulus() + "解密指数：" + rsaPrivateKey.getPrivateExponent());
        System.out.println("rsaPrivateKey.getAlgorithm() = " + rsaPrivateKey.getAlgorithm());

        //将密钥存储在map中
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, rsaPublicKey);
        keyMap.put(PRIVATE_KEY, rsaPrivateKey);
        return keyMap;

    }

    /**
     * 私钥加密
     * @param key 密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception {

        //取得私钥对象
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");


        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);


        //创建和初始化 cipher 对象
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        //数据最终加密
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        //取得私钥对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        //创建和初始化 cipher 对象
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        //数据最终解密
        return cipher.doFinal(data);
    }






    /**
     * 公钥加密
     * @param key 密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //初始化公钥   密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        //数据最终加密
        return cipher.doFinal(data);
    }



    /**
     * 公钥解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");


        //初始化公钥 密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);


        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return cipher.doFinal(data);
    }



    /**
     * @throws Exception
     */
    public static void main(String[] args) {
        try {


            //初始化密钥 生成密钥对
            Map<String, Object> keyMap = MyRSACoder.initKey();
            //公钥
            Key key = (Key) keyMap.get(PUBLIC_KEY);
            byte[] publicKey = key.getEncoded();
            //byte[] publicKey = b;
            //私钥
            Key key1=(Key) keyMap.get(PRIVATE_KEY);
            byte[] privateKey = key1.getEncoded();
            //用BASE64编码进行传输 经过BASE64处理过后的公私钥类似于这些  MFwwDQwCIf0.....YWDIcCAwEAAQ==
            System.out.println("公钥：" + Base64.encode(publicKey));
            System.out.println("私钥：" + Base64.encode(privateKey));

            System.out.println("================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");
            String data = "username=sky&password=12345678";
            System.out.println("===========甲方向乙方发送加密数据==============");
            System.out.println("原文:" + data);
            //甲方进行数据的加密
            byte[] code1 = MyRSACoder.encryptByPublicKey(data.getBytes(), publicKey);
            System.out.println("甲方 使用乙方公钥加密后的数据：" + Base64.encode(code1));
            System.out.println("===========乙方使用甲方提供的公钥对数据进行解密==============");
            //乙方进行数据的解密
            //byte[] decode1=MyRSACoder.decryptByPublicKey(code1, publicKey);
            byte[] decode1 = MyRSACoder.decryptByPrivateKey(code1, privateKey);
            System.out.println("乙方解密后的数据：" + new String(decode1) + "");

            System.out.println("===========反向进行操作，乙方向甲方发送数据==============");

            data = "servername=tomcat&serverIP=20.13.133.12";

            System.out.println("原文:" + data);

            //乙方使用公钥对数据进行加密
            byte[] code2 = MyRSACoder.encryptByPublicKey(data.getBytes(), publicKey);
            System.out.println("===========乙方使用公钥对数据进行加密==============");
            System.out.println("加密后的数据：" + Base64.encode(code2));

            System.out.println("=============乙方将数据传送给甲方======================");
            System.out.println("===========甲方使用私钥对数据进行解密==============");

            //甲方使用私钥对数据进行解密
            byte[] decode2 = MyRSACoder.decryptByPrivateKey(code2, privateKey);

            System.out.println("甲方解密后的数据：" + new String(decode2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 取得私钥
     *
     * @param keyMap 密钥map
     * @return byte[] 私钥
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * 取得公钥
     *
     * @param keyMap 密钥map
     * @return byte[] 公钥
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }
}