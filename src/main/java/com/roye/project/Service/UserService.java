package com.roye.project.Service;

import com.roye.project.Dao.UserDao;
import com.roye.project.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
    UserDao userDao;
    public void add(String username,String password){
        userDao.add(username,password);
    }

    public User login(String username,String password,String power){
        return userDao.login(username,password,power);
    }
   public boolean update(String id,String nickname,String old_password,String new_password){
        return userDao.update(id,nickname,old_password,new_password);
   }
   public User adminLogin(String username,String password){
        return userDao.adminLogin(username,password);
   }
}
