package com.roye.project.Dao;

import com.roye.project.Entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
    int add(User user);
    User login(String username,String password,String power);
    boolean update(String id,String nickname,String old_password,String new_password);

}
