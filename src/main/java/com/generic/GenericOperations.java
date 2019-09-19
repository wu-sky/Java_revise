package com.generic;


/*
 *用户：sky-吴
 *日期：2019/9/3
 * 实现传入各个数字类型的参数, 让其加减乘除
 */
public class GenericOperations<T extends Number> {


	public static Number add(Number n1, Number n2){
		System.out.println(n1);
		return null;
	}


	public static void main(String[] args){
	  GenericOperations<Long> g=new GenericOperations<>();
	  //GenericOperations<long> g=new GenericOperations<>();
	  //GenericOperations<String> g=new GenericOperations<>();

	}



}


