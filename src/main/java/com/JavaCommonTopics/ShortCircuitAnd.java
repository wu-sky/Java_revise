package com.JavaCommonTopics;

/**
 * 用代码说明&和&&的区别
 */
public class ShortCircuitAnd {

	public static void function1(){
		String str=null;
		if(str!=null&str.equals("")){
		}else{
			System.out.println("非短路与两边都要做判断导致出现空指针");
		}

	}
	public static void function2(){
		String str=null;
		if(str!=null&&str.equals("")){

		}else{System.out.println("短路与只做一边判断不会出现空指针");}
	}

	public static void function3(){
		int x=2, y=3;
		if (x>2&++y>5){
		}
		System.out.println("x="+ x + " , y=" +y );
	}

	public static void function4(){
		int x=2, y=3;
		if (x>2 && ++y>5){
		}
		System.out.println("x="+ x + " , y=" +y );
	}


	public static void main(String[] args){
		ShortCircuitAnd.function3();
		ShortCircuitAnd.function4();

	}
}

/*
 *用户：sky-吴
 *日期：2019/9/2
 */