package com.roye.project.Dao;

import com.roye.project.Entity.Department;
import com.roye.project.Entity.Evaluate;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.TakeOff;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface HrDao {
    public List<Staff> findAllStaff();
    boolean updateStaff(String id,String department,BigDecimal salary,BigDecimal perks);
    public List<Department> findAllDepartment();
    public List<Staff> findStaffByNo(String no);
    public List<Evaluate> findEvaluate(String search,String type);
    public boolean updateEvaluate(String hrEvaluate,int hrScore,String id);
    List<TakeOff> findAllTakeOff();
}
