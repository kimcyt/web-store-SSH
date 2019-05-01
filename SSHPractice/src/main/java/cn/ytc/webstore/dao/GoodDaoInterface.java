package cn.ytc.webstore.dao;

import java.util.List;

import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;
import cn.ytc.webstore.utils.PageInfo;

public interface GoodDaoInterface extends BaseDaoInterface<Good>{
	public PageInfo getPageInfo(int pageNo, int itemsPerPage);
	
	public PageInfo getPageInfoInCategory(int pageNo, int itemsPerPage, int category);
}
