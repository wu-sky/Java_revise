package com.classCast;

/*
 *用户：sky-吴
 *日期：2019/7/26
 */
public class God  {


	public static void main(String[] args){

		Father f=new Father();
		Son son= (Son) f;
		System.out.println(son.getGirlFriend());
	}
}
///http://MSI/svn/svn1902/
//localhost
//127.0.0.1