package cn.ytc.webstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;
import cn.ytc.webstore.utils.PageInfo;

@Repository("goodDao")
public class GoodDaoImpl extends BaseDao<Good> implements GoodDaoInterface{
	
	//!!!! seession is not closed!!!
	
	public List<Good> getAll(){
		String hql = "from good";
		return getSession().createQuery(hql).list();
	}
	
	public Good getOne(int id) {
		return getSession().get(new Good().getClass(), id);
	}

	public PageInfo getPageInfo(int pageNo, int itemsPerPage) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Good> goods = (List<Good>)session.createQuery("FROM Good")
				.setFirstResult((pageNo-1)*itemsPerPage).setMaxResults(itemsPerPage).list();
		Query query = session.createQuery("select count(g) from Good g");
		long count =((Number)query.iterate().next()).longValue();  
		int totalP = (int)Math.ceil(count/itemsPerPage);
		PageInfo pageInfo = new PageInfo(goods, pageNo, totalP, count);
		session.close(); 
		//if close session after getting goods and not set lazy-init as false for good.gallery, goods.gallery 
		//is not loaded until it is accessed in jsp, so when we try to load good.gallery, session is already closed.
		return pageInfo;
	}

	public PageInfo getPageInfoInCategory(int pageNo, int itemsPerPage, int category) {
		Session session = getSession();
		System.out.println("category is "+category);
		List<Good> goods = (List<Good>)session.createQuery("FROM Good good WHERE good.category="+category)
				.setFirstResult((pageNo-1)*itemsPerPage).setMaxResults(itemsPerPage).list();
		Query query = session.createQuery("select count(good) from Good good WHERE good.category="+category);
		long count =((Number)query.iterate().next()).longValue();  
		int totalP = (int)Math.ceil(count/itemsPerPage);
		PageInfo pageInfo = new PageInfo(goods, pageNo, totalP, count);
		session.close();
		return pageInfo;
	}
}
