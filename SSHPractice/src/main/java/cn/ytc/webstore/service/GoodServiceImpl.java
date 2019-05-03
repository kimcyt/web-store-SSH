package cn.ytc.webstore.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.ytc.webstore.dao.GoodDaoImpl;
import cn.ytc.webstore.dao.UserDaoImpl;
import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.utils.ImageTools;
import cn.ytc.webstore.utils.PageInfo;

@Service
public class GoodServiceImpl extends BaseService<Good> implements GoodServiceInterface{

	@Autowired
	GoodDaoImpl goodDao;
	
	private static String path = "C:\\Users\\yunti\\Desktop\\java\\spring\\"
			+ "spring projects\\SSH web-store\\SSHPractice\\src\\main\\webapp\\resources\\image\\";

	public PageInfo getPageInfo(int pageNo, int itemsPerPage) {
		
		return goodDao.getPageInfo(pageNo, itemsPerPage);
	}

	public PageInfo getPageInfoInCategory(int pageNo, int itemsPerPage, int category) {
		// TODO Auto-generated method stub
		return goodDao.getPageInfoInCategory(pageNo, itemsPerPage, category);
	}

	public Good getGood(int id) {
		// TODO Auto-generated method stub
		return goodDao.getOne(id);
	}
	

	public void addGood(Good good, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String oldName = file.getOriginalFilename();
			String newName = good.hashCode()+oldName;
			if(ImageTools.saveImage(file, path+good.getCategory(), newName)) {
				good.getGallery().add(newName);
				System.out.println("adding good "+good);
				goodDao.add(good);
			} else{
				throw new Exception("Item not added: failed to upload image");
			}
			
		} else {
			throw new Exception("Item not added: image missing.");
		}		
	}

	public void updateGood(Good good, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String oldName = file.getOriginalFilename();
			String newName = good.hashCode()+oldName;
			if(ImageTools.saveImage(file, path+good.getCategory(), newName)) {
				ImageTools.deleteImage(path+good.getCategory(), good.getGallery().get(0));
				good.getGallery().set(0, newName);
			} else{
				throw new Exception("Item not added: failed to update image.");
			}
		} 
		System.out.println("updating good "+good);
		goodDao.update(good);
	}

	public void deleteGood(int id) {
		Good good = goodDao.getOne(id);
		goodDao.delete(Good.class, id);
		for(String picName: good.getGallery()) {
			ImageTools.deleteImage(path+good.getCategory(), picName);
		}
	}


	
}
