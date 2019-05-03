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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.ytc.webstore.service.GoodServiceInterface;
import cn.ytc.webstore.service.UserServiceInterface;
import cn.ytc.webstore.utils.ImageTools;
import cn.ytc.webstore.utils.PageInfo;
import cn.ytc.webstore.utils.RequestResult;
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
	
	//todo: fix category folder bug: when changing item category, image can no longer be found
	
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
	public String addGood(Model model, Good good, @RequestParam(value = "image", required = false) MultipartFile file) {

		System.out.println("adding good "+good);
		try {
			goodService.addGood(good, file);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "addGood";
		}

		return "redirect:/goods/1/5";
	}

	@RequestMapping(path="/good/{id}", method=RequestMethod.POST) //still dont know how to use PUT with file 
	public String updateGood(Model model, Good good, @RequestParam(value = "image", required = false) MultipartFile file) {

		System.out.println("updatingGood "+good);
//		goodService.update(good);
		try {
			goodService.updateGood(good, file);
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "updateGood";
		}
		return "redirect:/goods/1/5";
	}
	

	@ResponseBody
	@RequestMapping(path="/good/{id}", method=RequestMethod.DELETE)
	public RequestResult deleteGood(@PathVariable int id) {
		RequestResult rr = new RequestResult();
		System.out.println("deleting good");
		try {
			goodService.delete(Good.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		rr.setUrl("/goods/1/5");
		return rr;
	}
	
	@RequestMapping("/update/{id}")
	public String update(Model model, @PathVariable int id) {
		System.out.println("updating");
		model.addAttribute("good", goodService.getGood(id));
		return "updateGood";
	}
	
	
}
