package com;

/*
 *用户：sky-吴
 *日期：2019/9/25
 */
public class Test {


	public static void main(String[] args){
	  String s1="abc";
	  String s2="abc";
	  String s3=new String("abc");
		System.out.println(s1==s3);
		System.out.println(s1==s3.intern());
	}
}
