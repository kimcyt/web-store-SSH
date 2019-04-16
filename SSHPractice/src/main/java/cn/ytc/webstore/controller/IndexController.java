package cn.ytc.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ytc.webstore.model.User;

@Controller
public class IndexController extends BaseController{
	
	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("iam in index");
		//pass the command object to the request for the login page to store data for the form
		model.addAttribute("user", new User());
		return "login";
	}
}
