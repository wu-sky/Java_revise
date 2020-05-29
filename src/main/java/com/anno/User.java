package com.anno;

import java.io.Serializable;
import java.time.LocalDateTime;


/*
 *用户：sky-吴
 *日期：2020/1/7
 */

// @MyAnnotation("哈尼") //error
public class User implements Serializable {

	private String name;
	private LocalDateTime birthday;


	public String getName() {
		return name;
	}
	@MyAnnotation(value = "sb")
	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public static void main(String[] args) {
		User user = new User();
		System.out.println("user.getName() = " + user.getName());

	}
}
