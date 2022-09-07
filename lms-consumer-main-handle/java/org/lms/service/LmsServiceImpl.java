package org.lms.service;

import org.lms.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LmsServiceImpl implements LmsService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean checkUser(User user) {
		
		// consume data URI
		
		return false;
	}
	
	

}
