package cn.ytc.webstore.dao;

import java.util.List;

import cn.ytc.webstore.model.Good;

public class GoodDaoImpl extends BaseDao implements BaseDaoInterface{
	
	public List<Good> getAll(){
		String hql = "from good";
		return getSession().createQuery(hql).list();
	}
}
