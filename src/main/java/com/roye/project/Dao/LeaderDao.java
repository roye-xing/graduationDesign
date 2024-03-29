package com.roye.project.Dao;

import com.roye.project.Entity.Company;
import com.roye.project.Entity.Request;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.TakeOff;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface LeaderDao {
    List<Company> findCompanyInfo(String id);
    boolean updateCompanyInfo(String id,String name, String tel, String address);
    public List<TakeOff> findAllTakeOff(String id);
    boolean updateTakeOff(int check,String uuid,String msg);
    List<Staff> findAllMembers(String username);
    boolean quitMember(String id,String msg,int score);
    List<Request> getAllRequest(String id);
    boolean updateRequest(String uuid,String userid,String id,int type);
}
