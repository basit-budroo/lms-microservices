package org.lms.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.lms.bean.User;
import org.lms.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView loginPageController() {
        return new ModelAndView("Login", "command", new User());
    }
    
    @RequestMapping("/adminLand")
    public ModelAndView adminLander() {
        return new ModelAndView("adminLanding");
    }
    
    @RequestMapping("/signup")
    public ModelAndView signup() {
        return new ModelAndView("signuppage", "user", new User());
    }
    
    @RequestMapping("/userLand")
    public ModelAndView userLander() {
        return new ModelAndView("userLanding");
    }

    @RequestMapping("/login")
    public ModelAndView loginController(@ModelAttribute User user, HttpSession session) {

        ModelAndView modelAndView=new ModelAndView();
        
        if (userService.checkUser(user)) {
        	
           modelAndView.addObject("user", user);  //user object added at request scope
           session.setAttribute("user", user);
           
            if(userService.checkAdmin(user)==1) {
            	modelAndView.setViewName("adminLanding");
            }else {
            	modelAndView.setViewName("userLanding");
            }
          
        }
        else {
            modelAndView.addObject("message", "Invalid Credentials");
            modelAndView.addObject("command", new User());
            modelAndView.setViewName("Login");
        }
        return modelAndView;
    }
    
    @PostMapping(path = "/addusers")
	public void saveEmployeeResource(@ModelAttribute User user) {
		userService.addUser(user);
	}
	
	

	@RequestMapping(path = "/logout", produces = MediaType.TEXT_HTML_VALUE)
	public String thankYou(HttpSession httpSession) {
		httpSession.invalidate();
		return " <h1> Logged out! </h1>";

	}
}