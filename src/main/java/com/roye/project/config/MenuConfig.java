package com.roye.project.config;

import com.roye.project.Entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuConfig {
    public static List<Menu> StaffMenu(){
        List<Menu> list=new ArrayList<Menu>();

        Menu menu1=new Menu();
        menu1.setMenuName("个人信息");
        menu1.setIcon("<span data-feather='home'></span>");
        menu1.setMenuUrl("main");

        Menu menu2=new Menu();
        menu2.setMenuName("评价信息");
        menu2.setIcon("<span data-feather='bar-chart-2'></span>");
        menu2.setMenuUrl("evaluate");

        Menu menu3=new Menu();
        menu3.setMenuName("事假申请");
        menu3.setIcon("<span data-feather='file'></span>");
        menu3.setMenuUrl("takeOff");

        list.add(menu1);
        list.add(menu2);
        list.add(menu3);

        return list;
    }
    public static List<Menu> HrMenu(){
        List<Menu> list=new ArrayList<Menu>();

        Menu menu1=new Menu();
        menu1.setMenuName("员工列表");
        menu1.setIcon("<span data-feather='home'></span>");
        menu1.setMenuUrl("main");

        Menu menu2=new Menu();
        menu2.setMenuName("员工评价");
        menu2.setIcon("<span data-feather='bar-chart-2'></span>");
        menu2.setMenuUrl("evaluate");

        Menu menu3=new Menu();
        menu3.setMenuName("事假处理");
        menu3.setIcon("<span data-feather='layers'></span>");
        menu3.setMenuUrl("takeOff");

        list.add(menu1);
        list.add(menu2);
        list.add(menu3);
        return list;
    }
    public static List<Menu> LeaderMenu(){
        List<Menu> list=new ArrayList<Menu>();

        Menu menu1=new Menu();
        menu1.setMenuName("公司信息");
        menu1.setIcon("<span date-feather=''></span>");
        menu1.setMenuUrl("main");

        Menu menu2=new Menu();
        menu2.setMenuName("成员管理");

        Menu menu3=new Menu();
        menu3.setMenuName("事假处理");
        menu3.setIcon("<span data-feather='layers'></span>");
        menu3.setMenuUrl("takeOff");

        list.add(menu1);
        list.add(menu2);
        list.add(menu3);

        return list;
    }
}
