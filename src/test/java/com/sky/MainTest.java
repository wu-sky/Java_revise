package com.sky;

/**
 * @author：sky-吴 日期：2020/4/26
 * 邮箱:
 */
public class MainTest {

	/*
	*   0x1e
	*   00000001  11111110  => 16 + 14 = 30
	*
	* */
	public static void main(String[] args){
		for (int i = 0; i < 100000; i++) {
			System.out.println("i = " + i);
			if (i==1000){
				System.exit(0);
				return;
			}
		}

	}
	public static void test(){

		byte b[]=new byte[10];
		b[0]=0x11;
		b[1]=0x12;
		b[2]=0x13;
		b[3]=0x14;
		b[4]=0x15;
		b[5]=0x16;
		b[6]=0x17;
		b[6]=0x1a;
		b[7]=0x1b;
		b[8]=0x1c;
		b[9]=0x1e;

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+"  ");
		}

		short s = 0xf;
	}
}
