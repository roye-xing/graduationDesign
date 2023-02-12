package com.roye.project.config;

import com.roye.project.Entity.Department;
import com.roye.project.Entity.Menu;
import com.roye.project.Service.HrService;
import com.roye.project.Util.UUIDUtil;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        UUIDUtil uuidUtil = null;
        String uuid2=uuidUtil.eightUUID();
        System.out.println(uuid2);
    }
}
