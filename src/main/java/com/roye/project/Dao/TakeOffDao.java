package com.roye.project.Dao;

import com.roye.project.Entity.TakeOff;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface TakeOffDao {
    //新增事假
    int add(String id, String type, Timestamp regtime,Timestamp backtime,String reason);
    //修改事假
    //查看事假
    List<TakeOff> check(String id);
    //删除事假
    int delete(String id,String regTime);
}
