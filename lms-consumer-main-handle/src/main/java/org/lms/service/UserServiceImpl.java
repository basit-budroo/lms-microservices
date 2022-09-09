package org.lms.service;

import org.lms.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean checkUser(User user) {
        User obj = restTemplate.getForObject("http://user-service/users/" + user.getEmail() + "/" + user.getPassword(), User.class);
        if (obj == null) {
            return false;
        }
        return true;
    }

    @Override
    public int checkAdmin(User user) {
        User obj = restTemplate.getForObject("http://user-service/users/" + user.getEmail() + "/" + user.getPassword(), User.class);

        return obj.getType();
    }

    @Override
    public User addUser(User user) {
       
    	return restTemplate.postForObject("http://user-service/addusers", user, User.class);
    }   
      
}
