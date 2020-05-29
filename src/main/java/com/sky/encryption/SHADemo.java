package com.sky.encryption;

import java.security.MessageDigest;

/**
 * @author：吴世凯 邮箱：https://www.cnblogs.com/Free-Thinker/p/10007503.html
 * 日期：09/05/2020
 *SHA
 * SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，被广泛地应用于电子商务等信息安全领域。
 * 虽然，SHA与MD5通过碰撞法都被破解了， 但是SHA仍然是公认的安全加密算法，较之MD5更为安全。
 */
public class SHADemo {
    /**
     * SHA加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {

        MessageDigest sha = MessageDigest.getInstance("KEY_SHA");

        sha.update(data);

        return sha.digest();

    }
}


