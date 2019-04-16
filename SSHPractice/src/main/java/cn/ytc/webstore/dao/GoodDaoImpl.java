package cn.ytc.webstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;

@Repository("goodDao")
public class GoodDaoImpl extends BaseDao<Good> implements GoodDaoInterface{
	
	public List<Good> getAll(){
		String hql = "from good";
		return getSession().createQuery(hql).list();
	}
	
	public Good getOne(int id) {
		return getSession().get(new Good().getClass(), id);
	}
}
