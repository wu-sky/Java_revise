package com.generic;

/*
 *用户：sky-吴
 *日期：2019/9/2
 *
 * 这个类不要管它有没有意义, 这个info是根据你传入的参数决定的
 */
public class Apple<T> {


	private T info;

	public Apple() {
	}

	public Apple(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}


	public static void main(String[] args) {

		Apple a1 = new Apple("shit");
		System.out.println(a1.getInfo());

		//泛型构造器
		Apple<String> a2 = new Apple<>("red");
		System.out.println("the color of that apple is " + a2.getInfo());

		Apple<Integer> a3 = new Apple<>(1);
		System.out.println("the kilos of that apple is " + a3.getInfo());

		/*
		Apple<Integer> a4=new Apple<Integer>("red");
		//Apple(java.lang.Integer)in Apple cannot be applied to (java.lang.String)
		 */
	}
}
