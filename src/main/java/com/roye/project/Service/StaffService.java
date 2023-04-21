package com.roye.project.Service;

import com.roye.project.Dao.StaffDao;
import com.roye.project.Dao.TakeOffDao;
import com.roye.project.Entity.Evaluate;
import com.roye.project.Entity.Request;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.TakeOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffDao staffDao;
    @Autowired
    TakeOffDao takeOffDao;
    //员工信息操作
    public List<Staff> findById(String no){
        return staffDao.findById(no);
    }
    public boolean update(String id, String name, String gender, Date birth, String email, String tel, boolean secrecy){
        staffDao.update(id,name,gender,birth,email,tel,secrecy);
        return true;
    }
    //评价信息操作
    public List<Evaluate> findEvaluate(String id){
        return staffDao.findEvaluate(id);
    }
    public boolean updateEvaluate(String id,String oldWork,String selfMsg,int selfScore){
        staffDao.updateEvaluate(id,oldWork,selfMsg,selfScore);
        return true;
    }
    //请假操作
    public boolean addTakeOff(String id, String type, Timestamp regtime,Timestamp backtime,String reason,String uuid) {
        takeOffDao.add(id,type,regtime,backtime,reason,uuid);
        return true;
    }
    public boolean delTakeOff(String uuid){
        takeOffDao.delete(uuid);
        return true;
    }
    public List<TakeOff> checkTakeOff(String no){return takeOffDao.check(no);}

    public List<Request> getAllRequest(String id){
        return staffDao.getAllRequest(id);
    }

    public boolean editRequest(String uuid,int state){
        staffDao.editRequest(uuid,state);
        return true;
    }
    public boolean delRequest(String uuid){
        staffDao.delRequest(uuid);
        return true;
    }
}