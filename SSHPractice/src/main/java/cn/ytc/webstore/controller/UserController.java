package cn.ytc.webstore.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ytc.webstore.model.User;
import cn.ytc.webstore.service.UserServiceImpl;
import cn.ytc.webstore.service.UserServiceInterface;

@Controller
public class UserController extends BaseController{

	@Autowired
	UserServiceInterface userService;
	
	@ResponseBody
	@RequestMapping(path="/user", method=RequestMethod.POST)
	public String login(@RequestParam String userId, @RequestParam String password,  HttpServletResponse res, HttpSession session) {
		System.out.println("login is working " + userId +"  "+ password);

//		if(user.getUserId()==null || user.getPassword()==null) {
////			model.addAttribute("error", "Please enter your user ID and password.");
////			return "login";
//			return "Please enter your user ID and password.";
//		}
//		if(error.hasFieldErrors()) {
//			model.addAttribute("error", error.getFieldError());
//			return "login";
//		}
		
		Integer userid = Integer.parseInt(userId);
		boolean verified = userService.verify(userid, password);
		if(verified) {
			User user = userService.getUser(userid);
			session.setAttribute("currentUser", user);
//			model.addAttribute("user", user);
			
			return "redirect:/main";
		} else {
//			model.addAttribute("error", "Invalid userId or password.");
//			return "forward:/";
			return "Invalid userId or password.";
		}
	}
}
