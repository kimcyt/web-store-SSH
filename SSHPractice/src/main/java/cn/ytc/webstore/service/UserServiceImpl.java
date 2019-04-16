package cn.ytc.webstore.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ytc.webstore.dao.BaseDao;
import cn.ytc.webstore.dao.UserDaoImpl;
import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserServiceInterface{

	@Autowired
	UserDaoImpl userDao;
	
	public boolean verify(int id, String password) {
		
		User user = userDao.getOne(id);
		if(user==null)
			return false;
		return user.getPassword().equals(password);
	}
	
	public void signUp(User user) {
		//auto conversion from jsp data
		userDao.add(user);
	}
	
	public User getUser(int id) {
		return userDao.getOne(id);
	}
}
