package cn.ytc.webstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ytc.webstore.model.Category;
import cn.ytc.webstore.model.Good;
import cn.ytc.webstore.model.User;

@Controller
public class IndexController extends BaseController{
	
	
	@RequestMapping("/")
	public String login(Model model) {
		System.out.println("iam in index");
		//pass the command object to the request for the login page to store data for the form
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signUp() {
		System.out.println("iam in signup");
		return "signup";
	}

	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		System.out.println("iam logging out");
		session.setAttribute("currentUser", null);
		return "login";
	}
//	@RequestMapping("/main")
//	public String main() {
//		System.out.println("iam in main");
//		return "main";
//	}

//	@RequestMapping("/items")
//	public String items() {
//		System.out.println("iam in items management");
//		return "itemsManagement";
//	}
	
	
	@RequestMapping("/addGood")
	public String addGood(HttpSession session, Model model) {
		System.out.println("iam in add good");
		if(session.getAttribute("allCategories")==null)
			session.setAttribute("allCategories", Category.getCategories());
		model.addAttribute("good", new Good());
		return "addGood";
	}
}
