package cn.ytc.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ytc.webstore.dao.GoodDaoImpl;
import cn.ytc.webstore.dao.UserDaoImpl;
import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.utils.PageInfo;

@Service
public class GoodServiceImpl extends BaseService<Good> implements GoodServiceInterface{

	@Autowired
	GoodDaoImpl goodDao;

	public PageInfo getPageInfo(int pageNo, int itemsPerPage) {
		
		return goodDao.getPageInfo(pageNo, itemsPerPage);
	}

	public PageInfo getPageInfoInCategory(int pageNo, int itemsPerPage, int category) {
		// TODO Auto-generated method stub
		return goodDao.getPageInfoInCategory(pageNo, itemsPerPage, category);
	}
}
