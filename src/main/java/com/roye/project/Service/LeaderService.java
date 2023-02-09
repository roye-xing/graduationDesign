package com.roye.project.Service;


import com.roye.project.Dao.LeaderDao;
import com.roye.project.Entity.Company;
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
    public boolean updateCompanyInfo(String name, String tel, String address, Timestamp editTime){
        leaderDao.updateComapanyInfo(name,tel,address,editTime);
        return true;
    }
    public List<TakeOff> findAllTakeOff(){
        return leaderDao.findAllTakeOff();
    }
    public boolean updateTakeOff(int check,String uuid,String msg){
        leaderDao.updateTakeOff(check,uuid,msg);
        return true;
    }
}
