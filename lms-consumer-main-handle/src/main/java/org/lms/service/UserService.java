package org.lms.service;

import org.lms.bean.User;

public interface UserService {
	boolean checkUser(User user);

	int checkAdmin(User user);

	User addUser(User user);
}
