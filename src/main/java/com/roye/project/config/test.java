package com.roye.project.config;

import com.roye.project.Entity.Department;
import com.roye.project.Entity.Menu;
import com.roye.project.Service.HrService;
import com.roye.project.Util.MD5Util;
import com.roye.project.Util.UUIDUtil;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        MD5Util md5Util=null;
        System.out.println(md5Util.string2MD5(md5Util.convertMD5("test")));
    }
}
