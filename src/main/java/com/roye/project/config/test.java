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
        String test=new String("1819849032");
        System.out.println("原始值："+test);
        System.out.println("位运算后生成md5："+md5Util.string2MD5(md5Util.convertMD5(test)));
        System.out.println("解密一次:"+md5Util.convertMD5(test));
        System.out.println("解密两次:"+md5Util.convertMD5(md5Util.convertMD5(test)));
    }
}
