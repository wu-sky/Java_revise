package com.generic.dao;

import com.generic.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*模拟controller
 *用户：sky-吴
 *日期：2019/9/3
 */
//@Controller
public class UserController {
	private UserDao dao=new UserDao();
	public User getUser(Long id){return dao.getObjById(id);}
	public Integer update(){return dao.update(new User());}
	public Integer delete(){return dao.delete(1L);}
	public List<User> list(){
		Map<String, Object> map=new HashMap<>();
		map.put("user", new User());
		return dao.list(map);
	}
	public static void main(String[] args){
		BaseDao<User> baseDao = new BaseDao<>();
		List<User> list = baseDao.list(null);
		ArrayList<? extends Model> users1;
		//users1.add(new User(1L, "aaa"));
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(123L, "sky"));
		users1=users;
		System.out.println( users1.toString() );

	}
}

