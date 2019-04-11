package cn.ytc.webstore.dao;

public interface BaseDaoInterface<T> {
	
	public void add(T obj);
	
	public void update(T obj);
	
	public void delete(int id);
	
	public T getOne(int id);
}
