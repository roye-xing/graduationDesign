package com.roye.project.Service;

import com.roye.project.Dao.HrDao;
import com.roye.project.Entity.Department;
import com.roye.project.Entity.Evaluate;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.TakeOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HrService {
    @Autowired
    HrDao hrDao;
    public List<Staff> findAllStaff(){
        return hrDao.findAllStaff();
    }
    public boolean updateStaff(String id, String department, BigDecimal salary,BigDecimal perks){
        hrDao.updateStaff(id,department,salary,perks);
        return true;
    }
    public List<Department> findAllDepartment(){
        return hrDao.findAllDepartment();
    }
    public List<Staff> findStaffByNo(String no){
        return hrDao.findStaffByNo(no);
    }
    public List<Evaluate> findEvaluate(String search,String type){
        return hrDao.findEvaluate(search,type);
    }
    public boolean updateEvaluate(String id,String hrEvaluate,int hrScore){
        hrDao.updateEvaluate(hrEvaluate,hrScore,id);
        return true;
    }
    public List<TakeOff> findAllTakeOff(){
        return hrDao.findAllTakeOff();
    }
    public boolean updateTakeOff(int check,String uuid){
        hrDao.updateTakeOff(check,uuid);
        return true;
    }
}
