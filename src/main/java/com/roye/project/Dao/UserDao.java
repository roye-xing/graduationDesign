package com.roye.project.Dao;

import com.roye.project.Entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
    boolean add(String username,String password,String phone,String email);
    User login(String username,String password,String power);
    boolean update(String id,String nickname,String old_password,String new_password);

    User adminLogin(String username,String password);

}
