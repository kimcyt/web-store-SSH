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

//	public List<Good> getPageGoods(int pageNo, int itemsPerPage) {
//		//!!! in hql the table name must match exactly with model class name due to ORM
//		//get items-per-page from request
////		int itemsNum =Integer.parseInt(itemsPerPage);
////		int start = (Integer.parseInt(pageNum)-1)*itemsNum;
//////		if(!transaction.isActive())
//////			transaction = session.beginTransaction();
////		List<Good> goods = this.getPageGoods(start, start+itemsNum);
////		String hql = "select count(g) from Good g";
////		long count = (long)session.createQuery(hql).list().get(0);
////		System.out.println("-------count is " + count);
////		PageInfo pageInfo = PageInfo.getPageInfo(Integer.parseInt(pageNum), count, goods, itemsNum);
//////		transaction.commit();
////		return pageInfo;
//		
//		String sql = "FROM Good";
////		String sql = "FROM Good";
//		List<Good> goods = (List<Good>)getSession().createQuery(sql)
//				.setFirstResult((pageNo-1)*itemsPerPage).setMaxResults(itemsPerPage).list();
//		return goods;
//	}

	public PageInfo getPageInfo(int pageNo, int itemsPerPage) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String sql = "FROM Good";
		List<Good> goods = (List<Good>)session.createQuery(sql)
				.setFirstResult((pageNo-1)*itemsPerPage).setMaxResults(itemsPerPage).list();
		Query query = session.createQuery("select count(g) from Good g");
		long count =((Number)query.iterate().next()).longValue();  
		int totalP = (int)Math.ceil(count/itemsPerPage)+1;
		PageInfo pageInfo = new PageInfo(goods, pageNo, totalP, count);
		return pageInfo;
	}

	public PageInfo getPageInfoInCategory(int pageNo, int itemsPerPage, int category) {
		// TODO Auto-generated method stub
		return null;
	}
}
