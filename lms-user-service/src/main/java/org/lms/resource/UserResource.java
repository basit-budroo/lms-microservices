package org.lms.resource;


import javax.servlet.http.HttpSession;

import org.lms.bean.User;
import org.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String welcome() {
		return " <h1> Welcome</h1>";

	}


	@GetMapping(path = "/users/{mail}/{pass}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByMail(@PathVariable("mail") String mail, @PathVariable("pass") String pass/*HttpSession   httpSession*/) {
		User user = userService.getUser(mail);
		if (user != null) {
			if (user.getPass().equals(pass)) {
				//httpSession.setAttribute("user",user);
				
				return new ResponseEntity<User>(user, HttpStatus.FOUND);
				
			} else {
				return new ResponseEntity<User>(new User(), HttpStatus.NOT_ACCEPTABLE);
			}
		}

		return new ResponseEntity<User>(new User(), HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping(path = "/addusers",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public User saveEmployeeResource(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	

	@RequestMapping(path = "/logout", produces = MediaType.TEXT_HTML_VALUE)
	public String thankYou(HttpSession httpSession) {
		httpSession.invalidate();
		return " <h1> Logged out! </h1>";

	}

}
