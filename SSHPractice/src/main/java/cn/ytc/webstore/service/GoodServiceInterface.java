package cn.ytc.webstore.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;
import cn.ytc.webstore.utils.PageInfo;

public interface GoodServiceInterface extends BaseServiceInterface<Good>{
	
	public PageInfo getPageInfo(int pageNo, int itemsPerPage);
	
	public PageInfo getPageInfoInCategory(int pageNo, int itemsPerPage, int category);
	
	public Good getGood(int id);
	
	public void addGood(Good good, MultipartFile file)throws Exception;
	
	public void updateGood(Good good, MultipartFile file) throws Exception;
	
	public void deleteGood(int id);
}
