package cn.ytc.webstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.ytc.webstore.service.GoodServiceInterface;
import cn.ytc.webstore.service.UserServiceInterface;
import cn.ytc.webstore.utils.PageInfo;
import cn.ytc.webstore.model.Administrator;
import cn.ytc.webstore.model.Category;
import cn.ytc.webstore.model.Good;

@Controller
public class GoodController extends BaseController{
	
	@Autowired
	GoodServiceInterface goodService;
	
	@ModelAttribute
	public void init(HttpSession session) {
//		model.addAttribute("good", new Good());
		if(session.getAttribute("allCategories")==null)
			session.setAttribute("allCategories", Category.getCategoryMap());
	}
	
	
	@RequestMapping(path="/goods/{pageNo}/{items}")
	public String displayPageGoods(HttpSession session, Model model, @PathVariable("pageNo") int pageNo, @PathVariable("items") int itemsPerPage) {
		System.out.println("displaying goods");
		//given pageNO and items per page, store goods in model and jump to main/itemsManagement based on user type
//		model.addAttribute("pageNo", pageNo);
//		model.addAttribute("itemsPerPage", itemsPerPage);
		PageInfo pageInfo = goodService.getPageInfo(pageNo, itemsPerPage);
		System.out.println("good obtained: "+pageInfo.getPageGoods());
		model.addAttribute("pageInfo", pageInfo);
		if(session.getAttribute("currentUser") instanceof Administrator) {
			return "itemsManagement";
		} else {
			return "main";
		}
	}
	/*
	 * 
	 */

	@RequestMapping(path="/goods/{pageNo}/{items}/{category}", method=RequestMethod.GET)
	public String displayPageGoodsInCategory(HttpSession session, Model model, @PathVariable("pageNo") int pageNo, 
			@PathVariable("items") int itemsPerPage, @PathVariable("category") int category) {
		PageInfo pageInfo = goodService.getPageInfoInCategory(pageNo, itemsPerPage, category);
//		System.out.println("good obtained: "+pageInfo.getPageGoods());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("currentCategory", category);
		if(session.getAttribute("currentUser") instanceof Administrator) {
			return "itemsManagement";
		} else {
			return "main";
		}
	}
	
	@RequestMapping(path="/good/{id}", method=RequestMethod.GET)
	public String displayGood(Model model, @PathVariable("id") int id) {
		Good good = goodService.getGood(id);
		model.addAttribute("good", good);
		return "displayGood";
	}

	//@RequestParam String name, @RequestParam String price, @RequestParam int category, @RequestParam String gallery
	@RequestMapping(path="/good", method=RequestMethod.POST)
	public String addGood(HttpSession session, Model model, Good good, @RequestParam(value = "image", required = false) MultipartFile file) {
		String newName = "";
		if(!file.isEmpty()) {
			//get real path for image folder
//			String path = session.getServletContext().getRealPath("/resources/image/"+good.getCategory());
			String path = "C:\\Users\\yunti\\Desktop\\java\\spring\\"
					+ "spring projects\\SSH web-store\\SSHPractice\\src\\main\\webapp\\resources\\image\\"+good.getCategory();
			String oldName = file.getOriginalFilename();
			newName = good.hashCode()+oldName;
			File uploadFile = new File(path, newName);
			if(!uploadFile.getParentFile().exists()) {
				uploadFile.getParentFile().mkdirs();
			}
			if(uploadFile.exists()) {
				model.addAttribute("error", "Item not added: failed to upload image - image name already exists.");
			} else {
				try {
					file.transferTo(uploadFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					model.addAttribute("error", "Item not added: failed to upload image - error occured while uploading image.");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		} else {
			model.addAttribute("error", "Item not added: image missing.");
		}
		
		good.getGallery().add(good.getCategory()+"/"+newName);
		System.out.println("adding good "+good);
		goodService.add(good);
		return "forward:/goods/1/5";
	}

	@RequestMapping(path="/good/{id}", method=RequestMethod.PUT)
	public String updateGood() {
		return null;
	}
	

	@RequestMapping(path="/good/{id}", method=RequestMethod.DELETE)
	public String deleteGood() {
		return null;
	}
}
