package com.error;

/**
 * 由递归引起的StackOverFlow
 * 栈溢出 一般与方法递归次数过多或者方法中有产生大量数据的循环有关
 */
public class StackOverFlow {

	public static String callMe(String str) {
		System.out.println(str);
		callMe(str);
		return str;
	}

	public static void main(String[] args) {
		StackOverFlow.callMe("StackOverFlow");
	}

}

/*
 *用户：sky-吴
 *日期：2019/8/28
 */