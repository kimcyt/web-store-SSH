package cn.ytc.webstore.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageTools {
	
	public static boolean saveImage(MultipartFile file, String path, String newName) {

		File uploadFile = new File(path, newName);
		if(!uploadFile.getParentFile().exists()) {
			uploadFile.getParentFile().mkdirs();
		}
		if(uploadFile.exists()) {
			return false;
		} else {
			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} 
		}
		return true;

	}
	
	public static boolean deleteImage(String path, String name) {
		File file = new File(path, name);
        if(file.exists()&&file.isFile()) {
        	file.delete();
        	return true;
        } 
        return false;    
	}
}
