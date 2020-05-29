package com.sky.classCast;

/*
 *用户：sky-吴
 *日期：2019/7/26
 */
public class God  {


	public static void main(String[] args){


		//父类由子类实现, 调用的方法就是子类的 , 儿子能实现父亲的志愿
		Father father=new Son();
		System.out.println(father.getGirlFriend());
		//子类不能由父类实现, 父亲不能捆绑住儿子
		Son son= (Son) new Father();
		System.out.println(son.getGirlFriend());
	}
}
///http://MSI/svn/svn1902/
//localhost
//127.0.0.1