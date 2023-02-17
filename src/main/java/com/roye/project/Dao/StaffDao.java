package com.roye.project.Dao;

import com.roye.project.Entity.Evaluate;
import com.roye.project.Entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface StaffDao {
    //查询员工信息
    List<Staff> findById(String no);
    //修改员工信息
    boolean update(String id, String name, String gender, Date birth,String email,String tel,boolean secrecy);
    //查询评价信息
    List<Evaluate> findEvaluate(String id);
    //更新评价信息
    boolean updateEvaluate(String id,String oldWork,String selfMsg,int selfScore);
}
