package cn.ytc.webstore.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {
	
	@Autowired
	private SessionFactory session;
	
	public Session getSession() {
		return session.getCurrentSession();
	}
	
	public void add(T obj) {
		getSession().save(obj);
	}
	
	public void update(T obj) {
		getSession().update(obj);
	}
	
	public void delete(int id) {
		getSession().delete(this.getOne(id));
	}
	
	public T getOne(int id) {
		return (T) getSession().load(this.getTClass(), id);
	}
	
	public Class<T> getTClass(){
		Class<T> tClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return tClass;
	}
	
}
