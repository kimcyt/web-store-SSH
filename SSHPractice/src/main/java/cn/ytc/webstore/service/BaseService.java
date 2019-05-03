package cn.ytc.webstore.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ytc.webstore.dao.BaseDao;
import cn.ytc.webstore.dao.BaseDaoInterface;

public class BaseService<T> implements BaseServiceInterface<T> {

	@Autowired
	BaseDaoInterface<T> dao;
	
	public void add(T obj) {
		dao.add(obj);
	}
	
	public void update(T obj) {
		dao.add(obj);
	}
	
	public void delete(Class clazz, int id) {
		dao.delete(clazz,id);
	}
	
//	public T getOne(int id) {
//		System.out.println("class: " + this.getClass());
//		Type type = this.getClass().getGenericSuperclass();
//		System.out.println("type in base service: "+type);
//		ParameterizedType pt = (ParameterizedType) type;
//		Type[] ts = pt.getActualTypeArguments();
//		Class c= (Class) ts[0];
//		System.out.println(c);
//		return (T) dao.getOne(id);
//	}
}
