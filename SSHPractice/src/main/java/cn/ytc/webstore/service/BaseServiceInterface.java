package cn.ytc.webstore.service;

public interface BaseServiceInterface<T> {
	public void add(T obj);
	
	public void update(T obj);
	
	public void delete(T obj);
	

}
