package com.roye.project.Dao;

import com.roye.project.Entity.Department;
import com.roye.project.Entity.Evaluate;
import com.roye.project.Entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HrDao {
    public List<Staff> findAllStaff();
    public List<Department> findAllDepartment();
    public List<Staff> findStaffByNo(String no);
    public List<Evaluate> findEvaluate();
}
