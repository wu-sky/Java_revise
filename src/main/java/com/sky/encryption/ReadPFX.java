package com.sky.encryption;

/**
 * @author : wushikai
 * <p>
 * date : 2020-06-10
 *
 *
 *
 *　　公钥加密技术12号标准(Public Key Cryptography Standards #12，PKCS#12)为存储和传输用户或服务器私钥、公钥和证书指定了一个可移植的格式。
 *
 * 它是一种二进制格式，用这种格式制作的这些文件也称为PFX文件。
 *
 * 开发人员通常需要将PFX文件转换为某些不同的格式，如PEM或JKS，以便可以为使用SSL通信的独立Java客户端或WebLogic Server使用
 *
 *在Java Security编程中，有几种典型的密码交换信息文件格式:
 *
 *DER-encoded certificate: .cer, .crt
 *
 * 　　PEM-encoded message: .pem
 *
 * 　　PKCS#12 Personal Information Exchange: .pfx, .p12
 *
 * 　　PKCS#10 Certification Request: .p10
 *
 * 　　PKCS#7 cert request response: .p7r
 *
 * 　　PKCS#7 binary message: .p7b
 *
 * 　　.cer/.crt是用于存放证书，它是2进制形式存放的，不含私钥。
 *
 * 　　.pem跟crt/cer的区别是它以Ascii来表示。
 *
 * 　　pfx/p12用于存放个人证书/私钥，他通常包含保护密码，2进制方式
 *
 * 　　p10是证书请求
 *
 * 　　p7r是CA对证书请求的回复，只用于导入
 *
 * 　　p7b以树状展示证书链(certificate chain)，同时也支持单个证书，不含私钥。
 *
 *      如何从p12/pfx文件中提取密钥对及其长度:
 *
 * 　　1，首先，读取pfx/p12文件(需要提供保护密码)
 *
 * 　　2，通过别名(Alias,注意，所有证书中的信息项都是通过Alias来提取的)提取你想要分析的证书链
 *
 * 　　3，再将其转换为一个以X509证书结构体
 *
 * 　　4，提取里面的项，如果那你的证书项放在第一位(单一证书)，直接读取 x509Certs[0](见下面的代码)这个X509Certificate对象
 *
 * 　　5，X509Certificate对象有很多方法, X509Certificate keyPairCert = x509Certs[0];
 *
 * 　　int iKeySize = X509CertUtil.getCertificateKeyLength(keyPairCert);
 *
 * 　　System.out.println("证书密钥算法="+keyPairCert.getPublicKey().getAlgorithm());
 *
 * 　　System.out.println("证书密钥长度="+iKeySize);
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class ReadPFX {
    public ReadPFX (){
    }
    //转换成十六进制字符串
    public static String Byte2String(byte[] b) {
        String hs="";
        String stmp="";

        for (int n=0;n<b.length;n++) {
            stmp=(java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length()==1) hs=hs+"0"+stmp;
            else hs=hs+stmp;
            //if (n<b.length-1)  hs=hs+":";
        }
        return hs.toUpperCase();
    }

    public static byte[] StringToByte(int number) {
        int temp = number;
        byte[] b=new byte[4];
        for (int i=b.length-1;i>-1;i--){
            b[i] = new Integer(temp&0xff).byteValue();//将最高位保存在最低位
            temp = temp >> 8; //向右移8位
        }
        return b;
    }


    public  PrivateKey getPrivateFromPfx(String strPfx, String strPassword){
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(strPfx);
            // If the keystore password is empty(""), then we have to set
            // to null, otherwise it won't work!!!
            char[] nPassword = null;
            if ((strPassword == null) || strPassword.trim().equals("")){
                nPassword = null;
            }
            else
            {
                nPassword = strPassword.toCharArray();
            }
            ks.load(fis, nPassword);
            fis.close();
            System.out.println("keystore type=" + ks.getType());
            // Now we loop all the aliases, we need the alias to get keys.
            // It seems that this value is the "Friendly name" field in the
            // detals tab <-- Certificate window <-- view <-- Certificate
            // Button <-- Content tab <-- Internet Options <-- Tools menu
            // In MS IE 6.
            Enumeration enumas = ks.aliases();
            String keyAlias = null;
            if (enumas.hasMoreElements())// we are readin just one certificate.
            {
                keyAlias = (String)enumas.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
            }
            // Now once we know the alias, we could get the keys.
            System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
            PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
            Certificate cert = ks.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();
            System.out.println("cert class = " + cert.getClass().getName());
            System.out.println("cert = " + cert);
            System.out.println("public key = " + pubkey);
            System.out.println("private key = " + prikey);
            return prikey;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args)  {
        String PfxPath = "D:\\java\\codeLibraries\\project\\pay\\src\\main\\resources\\key\\100009000392.pfx";
        String pfxPassword ="720083";
        KeyStore keyStore = null;
        FileInputStream fileInputStream = null;
        char[] nPassword = pfxPassword.toCharArray();
        Enumeration<String> enumas = null;
        String keyAlias = null;
        PrivateKey privateKey = null;
        Certificate certificate = null;

        try {
            keyStore = KeyStore.getInstance("PKCS12");

            fileInputStream = new FileInputStream(PfxPath);

            keyStore.load(fileInputStream, nPassword);

            System.out.println("keystore type=" + keyStore.getType());
            enumas = keyStore.aliases();

            if (enumas.hasMoreElements())// we are readin just one certificate.
            {
                keyAlias = enumas.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
            }

            System.out.println("is key entry=" + keyStore.isKeyEntry(keyAlias));

            privateKey = (PrivateKey) keyStore.getKey(keyAlias, nPassword);

            certificate = keyStore.getCertificate(keyAlias);
            PublicKey publicKey = certificate.getPublicKey();
            System.out.println("certificate class = " + certificate.getClass().getName());
            System.out.println("certificate = " + certificate);
            System.out.println("public key = " + publicKey);
            System.out.println("private key = " + privateKey);
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | KeyStoreException | IOException e) {
            //注意：这个方法虽然简洁，但是也不够好;
            //A:处理方式是一致的。(实际开发中，好多时候可能就是针对同类型的问题，给出同一个处理)
            //B:多个异常间必须是平级关系。
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

/*
*
*结果:
*
* keystore type=PKCS12
alias=[100009000392]
is key entry=true
certificate class = sun.security.x509.X509CertImpl
certificate = [
[
  Version: V3
  Subject: CN=魔豆智慧停车场
  Signature Algorithm: SHA1withRSA, OID = 1.2.840.113549.1.1.5

  Key:  Sun RSA public key, 1024 bits
  modulus: 118143657449022288489702303292522899484967889451871582387529357458951748161454147003610544306264020930366288918088321261036050567710600281743972842729105992895232075222577222507647897393055540377307396263612580858141349298765817521112413882349691536895948811221565299045485350343301496344235696103121813827783
  public exponent: 65537
  Validity: [From: Fri Aug 31 16:48:50 CST 2018,
               To: Sun Aug 07 16:48:50 CST 2118]
  Issuer: C=-�, ST=上海, L=上海, O=个人业务部, OU=个人业务部, CN=通联支付网络服务股份有限公司
  SerialNumber: [    016c902e c7ceeeb0 b2335c]

Certificate Extensions: 4
[1]: ObjectId: 2.5.29.35 Criticality=false
AuthorityKeyIdentifier [
KeyIdentifier [
0000: F4 2F 61 5A B4 9C 86 7D   1A 74 8D 7E 9D C4 B3 08  ./aZ.....t......
0010: 71 03 5D 9C                                        q.].
]
[C=-�, ST=上海, L=上海, O=个人业务部, OU=个人业务部, CN=通联支付网络服务股份有限公司]
SerialNumber: [    01]
]

[2]: ObjectId: 2.5.29.19 Criticality=true
BasicConstraints:[
  CA:true
  PathLen:2147483647
]

[3]: ObjectId: 2.5.29.15 Criticality=true
KeyUsage [
  DigitalSignature
  Data_Encipherment
]

[4]: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: 32 59 BB 37 0F A2 1E 07   76 1C 64 43 3B DB 40 75  2Y.7....v.dC;.@u
0010: E6 37 C6 23                                        .7.#
]
]

]
  Algorithm: [SHA1withRSA]
  Signature:
0000: 45 EA E3 D2 58 29 B8 01   E3 1B 26 8D 6F 78 B3 CF  E...X)....&.ox..
0010: 1B 4F 75 75 71 A9 1C CE   A7 C6 03 1C 6B 71 8A 08  .Ouuq.......kq..
0020: 3A 56 68 0B 24 D7 06 48   54 D8 7E 4D 3D 41 9F 9C  :Vh.$..HT..M=A..
0030: 8B 3F 0D B7 78 67 63 80   B0 21 71 C5 A5 D0 00 8B  .?..xgc..!q.....
0040: 35 AF 64 3E 49 2C 12 08   74 04 6A AA CF 27 67 14  5.d>I,..t.j..'g.
0050: 69 B2 D7 61 D0 B7 1F 64   33 84 6B E0 CA E2 BD D2  i..a...d3.k.....
0060: 91 E9 D2 70 4C D5 87 79   B1 5B A2 E7 7D 57 E3 8D  ...pL..y.[...W..
0070: F2 F6 03 AD 31 1E D2 D3   28 73 D6 AF 1E 9A B8 62  ....1...(s.....b

]
public key = Sun RSA public key, 1024 bits
  modulus: 118143657449022288489702303292522899484967889451871582387529357458951748161454147003610544306264020930366288918088321261036050567710600281743972842729105992895232075222577222507647897393055540377307396263612580858141349298765817521112413882349691536895948811221565299045485350343301496344235696103121813827783
  public exponent: 65537
private key = sun.security.rsa.RSAPrivateCrtKeyImpl@6b6f0
*
*
* symmetric:
对称的
英式:[sɪ'metrɪk];美式:[sɪ'mɛtrɪk]

本地释义:
adj. 对称的；匀称的

网络释义:
symmetric : 对称的,对称性,对称式,
symmetric function : 对称函数,
symmetric key : 对称密钥,对称金钥,

elliptic:
椭圆
英式:[ɪ'lɪptɪk];美式:[ɪ'lɪptɪkl]

本地释义:
adj. 椭圆形的；省略的

网络释义:
elliptic : 椭圆的,椭圆的,
elliptic curve : 椭圆曲线,椭圆曲线,
elliptic orbit : 椭圆轨道,椭圆轨迹,椭圆形轨道,


pseudo:
伪
英式:[ˈsuːdəʊ; ˈsjuːdəʊ];美式:[ˈsuːdoʊ]

本地释义:
n. 伪君子；假冒的人
adj. 冒充的，假的

网络释义:
pseudo : 假的,虚伪的,冒充的,
Pseudo Terminal : 伪终端,虚拟终端机,
pseudo noise : 伪随机噪声,伪噪声,来源于伪随机

architecture:
体系结构
英式:[ˈɑːkɪtektʃə(r)];美式:[ˈɑːrkɪtektʃər]

本地释义:
n. 建筑学；建筑风格；建筑式样；架构

网络释义:
Architecture : 建筑,架构,建筑学,
Renaissance architecture : 文艺复兴建筑,文艺复兴时期建筑,文芤复兴时期的建筑,
neoclassical architecture : 新古典主义建筑

Java Cryptography Architecture  (JCA)
Java的Cryptography架构是一个提供访问和开发密码功能的框架。它提供了许多cryptographic服务：
    Message digest algorithms 【信息摘要算法, 如：MD5】
    Digital signature algorithms 【数字签名算法，DSA】
    Symmetric bulk encryption  【对称块加密， 如：DES】
    Symmetric stream encryption 【对称流加密， 如：RC4】
    Asymmetric encryption 【非对称加密， 如：RSA】
    Password-based encryption (PBE) 【密码加密】
    Elliptic Curve Cryptography (ECC) 【椭圆曲线加密】
    Key agreement algorithms 【key协议算法】
    Key generators 【key生成器】
    Message Authentication Codes (MACs) 【消息认证码】
    (Pseudo-)random number generators 【伪随机数生成器】

*
*'catch' branch identical to ' Key Store Exception' branch:
“抓住”分支相同的密钥存储异常分支
* */