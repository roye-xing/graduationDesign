package com.roye.project.Service;

import com.roye.project.Dao.UserDao;
import com.roye.project.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
    UserDao userDao;
    public void add(User user){
        userDao.add(user);
    }

    public User login(String username,String password,String power){
        return userDao.login(username,password,power);
    }
}
