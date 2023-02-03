package com.roye.project.Controller;

import com.roye.project.Entity.Department;
import com.roye.project.Entity.Menu;
import com.roye.project.Entity.Staff;
import com.roye.project.Service.HrService;
import com.roye.project.config.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HrController {
    @Autowired
    HrService hrService;
    @RequestMapping  ("/hr/main")
    public String main(Model model,String department){
        if (department==null){
            List<Staff> list=hrService.findAllStaff();
            model.addAttribute("staffList",list);
        }else {
            List<Staff> list=hrService.findStaffByNo(department);
            model.addAttribute("staffList",list);
        }

        List<Department> list1=hrService.findAllDepartment();
        List<Menu> list2= MenuConfig.HrMenu();

        model.addAttribute("selected",department);
        model.addAttribute("menu",list2);
        model.addAttribute("departmentList",list1);


        return "user/hr/main";
    }
    @RequestMapping("/hr/evaluate")
    public String evaluate(){
        return "user/hr/evaluate";
    }
}
