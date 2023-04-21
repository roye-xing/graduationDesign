package com.roye.project.Dao;

import com.roye.project.Entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface HrDao {
    public List<Staff> findAllStaff(String id);
    boolean updateStaff(String id,String department,BigDecimal salary,BigDecimal perks);
    public List<Department> findAllDepartment();
    boolean delApplicate(String uuid);
    public List<Staff> findStaffByNo(String no);
    public List<Evaluate> findEvaluate(String id,String search,String type);
    public boolean updateEvaluate(String hrEvaluate,int hrScore,String id);
    List<TakeOff> findAllTakeOff(String id);
    boolean updateTakeOff(int check,String uuid);
    List<Staff> getAllTalents();
    boolean sendRequest(String id, String requester, String type, Timestamp sqlTime,String uuid);
    List<Request> getAllRequest(String id);
}
