package com.sky.anno;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;


/*
 *用户：sky-吴
 *日期：2020/1/7
 */


public class User implements Serializable {

	@MyAnnotation(value = "sb")
	private String name;
	private LocalDateTime birthday;

	@MyAnnotation()
	private String nameDefault;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public String getNameDefault() {
		return nameDefault;
	}

	public void setNameDefault(String nameDefault) {
		this.nameDefault = nameDefault;
	}

	/**
	 * 这种一般通过动态代理来实现注解
	 */
	public static void main(String[] args) {
		User user= new  User();
		//目标类通过反射获取自身字段的注解
		Class<User> userClass = User.class;
		for (Field f: userClass.getDeclaredFields()){
			// 判断这个字段是否有myAnnotation注解
			if (f.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation annotation = f.getAnnotation(MyAnnotation.class);
				//使用注解给自己的字段注入值
				user.setName(annotation.value());
				user.setNameDefault(annotation.value());
			}
		}
		System.out.println("user.getName() = " + user.getName());
		System.out.println("user.getNameDefault() = " + user.getNameDefault());

	}
}
