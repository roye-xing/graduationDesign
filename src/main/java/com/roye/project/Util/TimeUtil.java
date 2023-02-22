package com.roye.project.Util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//时间工具类
public class TimeUtil {
    //前端String类型时间转数据库Timestamp类型时间
    public static Timestamp timechange(String time){
        //时间格式化
        DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(time.replaceAll("T"," ")+":00",df);
        Date date=Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Timestamp sqlTime=new Timestamp(date.getTime());
        return sqlTime;
    }
    //后端当前时间long类型转数据库timestamp
    public static Timestamp localTime(){
        long time=new Date().getTime();
        Timestamp sqlTime=new Timestamp(time);
        return sqlTime;
    }
}
