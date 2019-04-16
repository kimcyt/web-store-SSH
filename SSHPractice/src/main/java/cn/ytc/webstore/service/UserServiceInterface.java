package cn.ytc.webstore.service;

import cn.ytc.webstore.model.User;

public interface UserServiceInterface extends BaseServiceInterface<User>{
	public boolean verify(int id, String password);
	
	public void signUp(User user);
	
	public User getUser(int id);
	
}
