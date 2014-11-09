package com.hb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
    
    @Autowired
    public UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
