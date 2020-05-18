package com.polymorphic;



/*
 *用户：sky-吴
 *日期：2019/9/3
 */
public abstract class AE extends AD {

	@Override
	public abstract void implementsMeAgain();


	public void test() {
		//super.name="bbb";
		System.out.println(super.name);
	}

	//public abstract AE() {	} Modifier 'abstract' not allowed here
	public static void main(String[] args) {
		AE ae = new AE() {
			@Override
			public void implementsMeAgain() {}
		};
		ae.test();
	}
}


/**
 * abstract 抽象===>需要被继承并实现===>不能用private和static, 因为这两货都不能被继承
 * <p>
 * 接口目的是给人调用===>方法都是抽象的, 变量都是final的
 */