package com.roye.project.Controller;

import com.roye.project.Entity.*;
import com.roye.project.Service.HrService;
import com.roye.project.config.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HrController {
    @Autowired
    HrService hrService;
    @GetMapping  ("/hr/main")
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
    @RequestMapping("/hr/main/update")
    public String update(String id, BigDecimal salary, BigDecimal perks, String depa, RedirectAttributes attributes){
        if (hrService.updateStaff(id,depa,salary,perks)){
            attributes.addFlashAttribute("state","editOK");
        }else {
            attributes.addFlashAttribute("state","editError");
        }
        return "redirect:/hr/main";
    }
    @RequestMapping("/hr/evaluate")
    public String evaluate(String search,String type,Model model){
        List<Menu> list2= MenuConfig.HrMenu();
        model.addAttribute("menu",list2);
        List<Evaluate> list=hrService.findEvaluate(search,type);
        model.addAttribute("evaluateList",list);
        return "user/hr/evaluate";
    }
    @RequestMapping("/hr/evaluate/update")
    public String updateEvaluate(int hrScore,String hrEvaluate,String staffId,RedirectAttributes attributes){
        if (hrService.updateEvaluate(staffId,hrEvaluate,hrScore)){
            attributes.addFlashAttribute("state","editOK");
        }else {
            attributes.addFlashAttribute("state","editError");
        }
        return "redirect:/hr/evaluate";
    }
    @RequestMapping("/hr/takeOff")
    public String takeOff(Model model){
        List<TakeOff> list=hrService.findAllTakeOff();
        model.addAttribute("menu",MenuConfig.HrMenu());
        model.addAttribute("takeoff",list);
        return "user/hr/takeOff";
    }
    @RequestMapping(value="/hr/takeOff/{type}/{uuid}")
    public String updateTakeOff(@PathVariable String type,@PathVariable String uuid){
        if (type.equals("agree")){
            hrService.updateTakeOff(1,uuid);
        }else{
            hrService.updateTakeOff(2,uuid);
        }
        return "redirect:/hr/takeOff";
    }
}