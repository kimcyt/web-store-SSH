package cn.ytc.webstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * if @transcational is added, all beans of implementational classes will
 * become proxy and fail to be loaded
 * either use openSession() and close it everytime after transcation
 * or only autowire abstract classes (interfaces)
 */


@Repository("dao")
public class BaseDao<T> implements BaseDaoInterface<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	public void add(T obj) {
		Session sess = getSession();
		sess.save(obj);
		sess.close();
	}
	
	public void update(T obj) {
		Session sess = getSession();
		sess.update(obj);
		sess.close();
	}
	
	public void delete(T obj) {
		Session sess = getSession();
		sess.delete(obj);
		sess.close();
	}

	
}
