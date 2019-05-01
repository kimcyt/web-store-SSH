package cn.ytc.webstore.service;

import java.util.List;

import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;
import cn.ytc.webstore.utils.PageInfo;

public interface GoodServiceInterface extends BaseServiceInterface<Good>{
	
	public PageInfo getPageInfo(int pageNo, int itemsPerPage);
}
