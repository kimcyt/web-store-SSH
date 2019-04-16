package cn.ytc.webstore.dao;

import org.springframework.stereotype.Repository;

import cn.ytc.webstore.model.User;

@Repository("userDao")
public interface UserDaoInterface extends BaseDaoInterface<User>{
	
}
