package cn.ytc.webstore.service;

import java.util.List;

import cn.ytc.webstore.model.Good;

public interface BaseServiceInterface<T> {
	public void add(T obj);
	
	public void update(T obj);
	
	public void delete(T obj);
	
}
