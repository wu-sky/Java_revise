package com.generic.dao;

import com.generic.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*利用泛型模拟curd, 更加抽象, 更加减少代码量
 *用户：sky-吴
 *日期：2019/7/31
 */
public class BaseDao<E extends Model> implements IBaseDao<E> {
	@Override
	public E getObjById(long id) {

		System.out.println("base getObj");
		return null;
	}

	@Override
	public List<E> list(Map<String, Object> param) {
		System.out.println("base list");
		System.out.println();
		List<E> list=new ArrayList<>();


		return null;
	}

	@Override
	public int add(E obj) {
		System.out.println("base add");
		return 0;
	}

	@Override
	public int update(E u) {

		System.out.println("base update");
		return 0;
	}

	@Override
	public int delete(long id) {
		System.out.println("base delete");
		return 0;
	}


	//泛型方法, 用于获取数据库中各种各样的数据, 表中一共有多少条记录, 那个用户最早/晚注册..
	public <E> E getValue(){

		return null;
	}
}
