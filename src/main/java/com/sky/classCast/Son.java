package com.sky.classCast;

/*
 *用户：sky-吴
 *日期：2019/7/26
 */
public class Son extends Father {
	String name;
	String girlFriend;
	@Override
	public String getName() {
		name="李三郎之子";
		return name;
	}

	@Override
	public void setName(String name) {

		this.name = name;
	}

	@Override
	public String getGirlFriend() {
		girlFriend="杨玉环";
		return "子类的"+girlFriend;
	}

	public void setGirlFriend(String girlFriend) {
		this.girlFriend = girlFriend;
	}
}
