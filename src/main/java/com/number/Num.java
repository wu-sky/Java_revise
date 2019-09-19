package com.number;

/*
 *用户：sky-吴
 *日期：2019/9/5
 */
public class Num {
	public static void main(String[] args) {
		/**
		 * 数据类型：
		 * 基本数据类型：4类8种基本数据类型
		 *
		 * 基本数据类型：数值类型(byte short int long) 字符类型(char)  布尔类型(boolean)
		 * //它们在内存中的房间有多大？
		 * byte:1个字节8位  0000 0000
		 * short:2个字节16位 0000 0000 0000 0000
		 * int:4个字节32位 0000 0000 0000 0000 0000 0000 0000 0000
		 * long:8个字节64位 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
		 * char:2个字节16位 0000 0000 0000 0000
		 */

		byte b1 = 20;//十进制
		byte b2 = 0b10;//二进制
		byte b3 = 017;//八进制 0开头 ，0~7
		byte b4 = 0x1f;//十六进制数：0 ~ 9  A ~ F, 注：必须以0x或0X开头

		System.out.println("byte min value: " + Byte.MIN_VALUE);
		System.out.println("byte max value: " + Byte.MAX_VALUE);

		short s1 = 1234;
		short s2 = 0b1000;//二进制
		short s3 = 01234;//八进制
		short s4 = 0x3f;//十六进制
		System.out.println("short min value: " + Short.MIN_VALUE);
		System.out.println("short max value: " + Short.MAX_VALUE);

	}
}
