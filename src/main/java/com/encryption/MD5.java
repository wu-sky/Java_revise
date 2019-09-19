package com.encryption;


import java.security.MessageDigest;
import java.util.Arrays;

public class MD5 {
	/**
	 *
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// 参数代表的是算法名称
			md.update(str.getBytes());//
			byte b[] = md.digest();//加密之后, 获得一个二进制数组
			System.out.println("b:"+Arrays.toString(b));
			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	public static void main(String[] args) {
		//System.out.println(md5("31119@qq.com"+"123456"));
		System.out.println(md5("aa"));
	}
}


/*

  en加密 cry哭 t/tion
  de解密 cry   t/tion
 *用户：sky-吴
 *日期：2019/7/30
 */