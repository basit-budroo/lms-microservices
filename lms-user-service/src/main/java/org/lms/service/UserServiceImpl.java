package org.lms.service;

import org.lms.bean.User;
import org.lms.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String mail) {
		
		return userDao.findById(mail).orElse(null);
	}

	@Override
	public User addUser(User user) {
		
		
		return userDao.save(user);
	}

	
	


}
