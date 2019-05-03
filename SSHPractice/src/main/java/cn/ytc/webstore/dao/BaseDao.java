package cn.ytc.webstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		//with openSession(), need to close it manually
		return sessionFactory.openSession();
	}
	
	public void add(T obj) {
		//for data manipulation(save/update/delete), must commit transaction to execute
		Session sess = getSession();
		Transaction tran = sess.beginTransaction();
		sess.save(obj);
		System.out.println("user added");
		tran.commit();
		sess.close();
	}
	
	public void update(T obj) {
		Session sess = getSession();
		Transaction tran = sess.beginTransaction();
		sess.update(obj);
		tran.commit();
		sess.close();
	}
	
	public void delete(Class clazz, int id) {
		Session sess = getSession();
		Transaction tran = sess.beginTransaction();
		Object obj = sess.load(clazz, id);
		if(obj!=null) {
			sess.delete(obj);
			tran.commit();
		}
		sess.close();
	}

	
}
