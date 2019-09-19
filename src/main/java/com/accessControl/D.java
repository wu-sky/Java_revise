package com.accessControl;

import com.accessControl.control.A;

/*
 *用户：sky-吴
 *日期：2019/9/3
 */
public class D extends A {

	void test(){
		D d=new D();
		System.out.println(d.name);
		//'school' is not public in 'com.accessControl.control.A'. Cannot be accessed from outside package
		//System.out.println(d.school);
		//'id' has protected access in 'com.accessControl.control.A'
		//System.out.println(a.id);
		/*嫁出去的女儿泼出去的水, 还不如邻居家的谁 */
	}
}
