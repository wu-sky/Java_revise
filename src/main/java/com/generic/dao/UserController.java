package com.generic.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*模拟controller
 *用户：sky-吴
 *日期：2019/9/3
 */
//@Controller
public class UserController {
	//在spring中是不用new的
	private UserDao dao=new UserDao();
	public User getUser(Long id){return dao.getObjById(id);}
	public Integer update(){return dao.update(new User());}
	public Integer delete(){return dao.delete(1L);}
	public List<User> list(){
		Map<String, Object> map=new HashMap<>();
		map.put("user", new User());
		return dao.list(map);
	}
}
