package com.generic;

/*
 *用户：sky-吴
 *日期：2019/9/2
 * 到了子类这里, 父类必须明确泛型的类型, 否则报错
 */
public class A1 extends Apple<String> {

	@Override
	public String getInfo() {
	    return "子类"+super.getInfo();
	}

	/*
	@Override
	public Integer getInfo() {
	    return null;
	}
	*/


	public static void main(String[] args){
		A1 a1 = new A1();
		System.out.println(a1.getInfo());
	}
}

/*
* 'getInfo()' clashes with [和...冲突] 'getInfo()'; both methods have same,  erasure[擦除] 'getInfo()' is already defined in
* 'com
* .generic.A1
* genericUpperBound
* */