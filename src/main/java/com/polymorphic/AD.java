package com.polymorphic;

/*
 *用户：sky-吴
 *日期：2019/9/3
 */
public abstract class AD implements IA {
	@Override
	public void implementsMe(int i) {
		System.out.println("抽象类可以实现接口的方法");
	}

	//public abstract static void implementsMeAgain();
	//private abstract  void implementsMeAgain();
	public abstract  void implementsMeAgain();

	public static void main(String[] args){
		System.out.println("抽象类可以有main方法");
	}
}
