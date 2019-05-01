package cn.ytc.webstore.service;

import cn.ytc.webstore.model.User;

public interface UserServiceInterface extends BaseServiceInterface<User>{
	public boolean verify(String id, String password);
	
	public void signUp(User user);
	
	public User getUser(String id);
	
	public boolean userIdUsed(String id);
	
	public boolean isAdmin(String id, String password);
	
}
