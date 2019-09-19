package com.generic.dao;

import java.util.List;
import java.util.Map;
public interface IBaseDao<E> {
	public E getObjById(long id);
	public List<E> list(Map<String, Object> param);
	public int add(E obj);
	public int update(E u);
	public int delete(long id);
}



/*
 *用户：sky-吴
 *日期：2019/7/31
 */