package com.JavaCommonTopics;

/*
 *用户：sky-吴
 *日期：2019/9/17
 */
public class StrFIQ {

	static int  test(){
		int x=1;
		try {
            return x;}
		finally {
			++x;
		}
	}

	public static void main(String[] args){
		System.out.println(new StrFIQ().test());
	}



	public static void test01(){
		String s1="a";
		String s2=s1+"b";
		String s3="a"+"b";
		System.out.println(s2== "ab");
		System.out.println(s3== "ab");

	}
}
