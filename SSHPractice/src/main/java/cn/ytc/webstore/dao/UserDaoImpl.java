package cn.ytc.webstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.ytc.webstore.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDaoInterface{

	public User getOne(int id) {
		return getSession().get(new User().getClass(), id);
	}
	
}
