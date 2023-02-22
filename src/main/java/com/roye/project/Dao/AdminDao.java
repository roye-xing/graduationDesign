package com.roye.project.Dao;

import com.roye.project.Entity.Company;
import com.roye.project.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    List<User> getAllUsers();
    boolean addUser(String username,String password,String type);
    boolean updateUser(String username,String password,String type,String nickname,String companyId);
    boolean delUser(String username);

    List<Company> getAllCompanies();
    boolean updateCompany(String id,String name,String tel,String address);
    boolean addCompany(String id,String name,String tel,String address);
    boolean delCompany(String id);
}
