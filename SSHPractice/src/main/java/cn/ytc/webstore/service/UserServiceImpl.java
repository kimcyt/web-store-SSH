package cn.ytc.webstore.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Properties;
import java.util.Map.Entry;

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
	
	public boolean verify(String id, String password) {
		
		User user = userDao.getOne(id);
		if(user==null)
			return false;
		return user.getPassword().equals(password);
	}
	
	public void signUp(User user) {
		//auto conversion from jsp data
		userDao.add(user);
	}
	
	public User getUser(String id) {
		return userDao.getOne(id);
	}
	
	public boolean userIdUsed(String id) {
		return userDao.getOne(id)!=null;
	}

	public boolean isAdmin(String id, String password) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream in = null;
		try {
			System.out.println("checking admin---------");
			in = new FileInputStream("C:\\Users\\yunti\\Desktop\\java\\spring\\spring projects\\SSH web-store\\SSHPractice\\src\\main\\resources\\adminInfo.properties");
			prop.load(in);
			System.out.println(prop.get(id) + "  "+password);
			String pwd = (String) prop.get(id);
			if(pwd!=null)
				return pwd.equals(password);
						
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
