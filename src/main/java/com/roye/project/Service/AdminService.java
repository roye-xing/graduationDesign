package com.roye.project.Service;

import com.roye.project.Dao.AdminDao;
import com.roye.project.Entity.Company;
import com.roye.project.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;
    public List<User> getAllUser(){
        return adminDao.getAllUsers();
    }
    public boolean addUser(String username,String password,String type){
        return adminDao.addUser(username, password, type);
    }
    public boolean updateUser(String username,String password,String type,String nickname,String companyId){
        adminDao.updateUser(username,password,type,nickname,companyId);
        return true;
    }
    public boolean delUser(String username){
        adminDao.delUser(username);
        return true;
    }
    public List<Company> getAllCompanies(){
        return adminDao.getAllCompanies();
    }
    public boolean updateCompany(String id,String name,String tel,String address){
        adminDao.updateCompany(id, name, tel, address);
        return true;
    }
    public boolean addCompany(String id,String name,String tel,String address){
        adminDao.addCompany(id, name,tel,address);
        return true;
    }
    public boolean delCompany(String id){
        adminDao.delCompany(id);
        return true;
    }
}
