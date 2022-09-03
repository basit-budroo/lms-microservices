package org.lms.service;

import org.lms.bean.User;




public interface UserService {
	User getUser(String mail);

	 User addUser(User user);

}
