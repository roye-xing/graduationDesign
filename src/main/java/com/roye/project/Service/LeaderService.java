package com.roye.project.Service;


import com.roye.project.Dao.LeaderDao;
import com.roye.project.Entity.Company;
import com.roye.project.Entity.Request;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.TakeOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LeaderService {
    @Autowired
    LeaderDao leaderDao;
    public List<Company> findCompanyInfo(String id){
        return leaderDao.findCompanyInfo(id);
    }
    public boolean updateCompanyInfo(String id,String name, String tel, String address){
        leaderDao.updateCompanyInfo(id,name,tel,address);
        return true;
    }
    public List<TakeOff> findAllTakeOff(String id){
        return leaderDao.findAllTakeOff(id);
    }
    public boolean updateTakeOff(int check,String uuid,String msg){
        leaderDao.updateTakeOff(check,uuid,msg);
        return true;
    }
    public List<Staff> findAllMembers(String username){
        return leaderDao.findAllMembers(username);
    }
    public boolean quitMember(String id,String msg,int score){
        leaderDao.quitMember(id,msg,score);
        return true;
    }
    public List<Request> getAllRequest(String id){
        return leaderDao.getAllRequest(id);
    }
    public boolean updateRequest(String uuid,String userid,String id,int type){
        leaderDao.updateRequest(uuid,userid,id,type);
        return true;
    }
}
