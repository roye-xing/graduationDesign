package com.roye.project.Dao;

import com.roye.project.Entity.Company;
import com.roye.project.Entity.TakeOff;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface LeaderDao {
    List<Company> findCompanyInfo(String id);
    boolean updateComapanyInfo(String name, String tel, String address, Timestamp editTime);
    public List<TakeOff> findAllTakeOff();
    boolean updateTakeOff(int check,String uuid,String msg);
}
