package com.roye.project.config;

import com.roye.project.Entity.Department;
import com.roye.project.Entity.Menu;
import com.roye.project.Service.HrService;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        HrService hrService = new HrService();
        List<Department> list=hrService.findAllDepartment();
        System.out.println(list);
    }
}
