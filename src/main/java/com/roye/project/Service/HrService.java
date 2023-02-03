package com.roye.project.Service;

import com.roye.project.Dao.HrDao;
import com.roye.project.Entity.Department;
import com.roye.project.Entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService {
    @Autowired
    HrDao hrDao;
    public List<Staff> findAllStaff(){
        return hrDao.findAllStaff();
    }
    public List<Department> findAllDepartment(){
        return hrDao.findAllDepartment();
    }
    public List<Staff> findStaffByNo(String no){
        return hrDao.findStaffByNo(no);
    }
}
