package org.lms.resource;

import javax.servlet.http.HttpSession;

import org.lms.bean.User;
import org.lms.service.LmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LmsResource {
	
	@Autowired
	private LmsService lmsService;
	
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("Login", "command", new User());
	}
	
	
	
	@RequestMapping("/login")
	public ModelAndView loginController(@ModelAttribute User user,HttpSession session) {
		
		ModelAndView modelAndView=new ModelAndView();
		if (lmsService.checkUser(user)) {
			modelAndView.addObject("user", user);  //user object added at request scope
			session.setAttribute("user", user);
			modelAndView.setViewName("index");
		}
		else {
			modelAndView.addObject("message", "Invalid Credentials");
			modelAndView.addObject("command", new User());
			modelAndView.setViewName("Login");
		}
		return modelAndView;
	}


}
