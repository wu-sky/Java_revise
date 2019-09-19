package com.JavaCommonTopics;


import java.util.ArrayList;
import java.util.List;

/**
 * switch语句能否作用在byte上，能否作用在long上，能否作用在String上?????
 * 泛型方法实现数值类型加法
 */
public class TypeOfSwitch<E> {

	/*
	 * 泛型不能用static, 否则报错
	 * switch也不能用泛型, 连机会都不给
	 */
	//extend限制返回时候的类型

	public static void sumlist(List<? extends Number> list) {
		double sum = 0.0;

		for(Number each : list) {
			sum += each.doubleValue();
		}

		double sum2 = list.stream().mapToDouble(x -> x.doubleValue()).sum();
		System.out.println(sum);
		System.out.println(sum2);
	}

	//super限制添加时候的类型
	public static void lowerBound(List<? super Number> list) {
		list.add(new Integer(1));
		list.add(new Float(2));
		Integer value1 = (Integer) list.get(0);
		Float value2 = (Float) list.get(1);
		System.out.println(value1 + "\t" + value2);
	}

	public static void main(String[] args) {
		List<Number> list = new ArrayList<>();
		lowerBound(list);
		System.out.println("---------");

		List<Integer> intList = new ArrayList(){{add(1); add(2); add(3);}};
		sumlist(intList);
		System.out.println("---------");

		List<Double> doubleList = new ArrayList(){{add(1.0); add(2.0); add(3.0);}};
		sumlist(doubleList);
	}





}
