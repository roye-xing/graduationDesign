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
        String test="order_no=1945073823&subject=support&pay_type=44&money=10.00&app_id=16442&extra=&c4d555914f1d4ff19a522de6fbc8e669";
        System.out.println("加密:"+md5Util.encryption(test));
    }
}
