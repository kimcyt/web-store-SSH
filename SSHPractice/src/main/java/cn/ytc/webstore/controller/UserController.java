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
import cn.ytc.webstore.utils.RequestResult;


@Controller
public class UserController extends BaseController{

	@Autowired
	UserServiceInterface userService;
	
	@ResponseBody
	@RequestMapping(path="/user", method=RequestMethod.POST)
	public RequestResult signUp(@RequestParam String userId, @RequestParam String username, @RequestParam String password,  
			HttpServletResponse res, HttpSession session) {
		System.out.println("iam signing up: "+userId +" "+username);
		
		RequestResult rr = new RequestResult();
		if(userService.userIdUsed(userId)) {
			System.out.println("ID already taken-----------");
			rr.setError("The userId has already been taken, please try again");
		} else {
			System.out.println("creating new account-------------");
			User user = new User(userId, username, password);
			userService.signUp(user);
			session.setAttribute("currentUser", user);	
			rr.setUrl("/main");
		}
//		return JSONObject.toJSONString(rr);
		return rr;
	}
	
	
	@ResponseBody
	@RequestMapping(path="/user/{id}", method=RequestMethod.POST)
	public RequestResult login(@RequestParam String userId, @RequestParam String password,  HttpServletResponse res, HttpSession session) {
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

//		TODO: CHANGE the way to recognize type of user
		RequestResult rr = new RequestResult();
		
		if(userService.isAdmin(userId, password)) {
			System.out.println("admin verified----");
			rr.setUrl("/goods/1/5/admin");
//			"/goods/{pageNo}/{itemsPerPage}/{userType}"
			return rr;
		}
		
		boolean verified = userService.verify(userId, password);
		if(verified) {
			User user = userService.getUser(userId);
			session.setAttribute("currentUser", user);
//			model.addAttribute("user", user);
			rr.setUrl("/main");  
//			/goods/1/10/customer
		} else {
//			model.addAttribute("error", "Invalid userId or password.");
//			return "forward:/";
			rr.setError("Invalid userId or password.");
		}
		return rr;
	}
}
