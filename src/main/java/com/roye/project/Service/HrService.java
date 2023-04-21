package com.roye.project.Service;

import com.roye.project.Dao.HrDao;
import com.roye.project.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class HrService {
    @Autowired
    HrDao hrDao;
    public List<Staff> findAllStaff(String id){
        return hrDao.findAllStaff(id);
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
    public List<Evaluate> findEvaluate(String id,String search,String type){
        return hrDao.findEvaluate(id,search,type);
    }
    public boolean updateEvaluate(String id,String hrEvaluate,int hrScore){
        hrDao.updateEvaluate(hrEvaluate,hrScore,id);
        return true;
    }
    public boolean delApplicate(String uuid){
        hrDao.delApplicate(uuid);
        return true;
    }
    public List<TakeOff> findAllTakeOff(String id){
        return hrDao.findAllTakeOff(id);
    }
    public boolean updateTakeOff(int check,String uuid){
        hrDao.updateTakeOff(check,uuid);
        return true;
    }
    public List<Staff> getAllTalents(){
        return hrDao.getAllTalents();
    }
    public boolean sendRequest(String id, String requester, String type, Timestamp sqlTime,String uuid){
        hrDao.sendRequest(id,requester,type,sqlTime,uuid);
        return true;
    }
    public List<Request> getAllRequest(String id){
        return hrDao.getAllRequest(id);
    }
}
