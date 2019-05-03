package cn.ytc.webstore.dao;

import cn.ytc.webstore.model.Good;

public interface BaseDaoInterface<T> {
	public void add(T obj);
	
	public void update(T obj);
	
	public void delete(Class clazz, int id);
	
}
