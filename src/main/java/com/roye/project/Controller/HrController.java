package com.roye.project.Controller;

import com.roye.project.Entity.*;
import com.roye.project.Service.HrService;
import com.roye.project.Util.TimeUtil;
import com.roye.project.Util.UUIDUtil;
import com.roye.project.config.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HrController {
    TimeUtil timeUtil;
    UUIDUtil uuidUtil;
    @Autowired
    HrService hrService;
    public boolean checkIdentify(HttpSession session){
        if (session.getAttribute("userType").equals("hr")){
            return true;
        }else {
            return false;
        }
    }

    @GetMapping  ("/hr/main")
    public String main(Model model,String department,HttpSession session,RedirectAttributes attributes){
        String id=(String)session.getAttribute("loginUser");
        if(checkIdentify(session)){
            if (department==null){
                model.addAttribute("staffList",hrService.findAllStaff(id));
            }else {
                model.addAttribute("staffList",hrService.findStaffByNo(department));
            }

            List<Department> list1=hrService.findAllDepartment();
            List<Menu> list2= MenuConfig.HrMenu();
            model.addAttribute("selected",department);
            model.addAttribute("menu",list2);
            model.addAttribute("departmentList",list1);

        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "user/hr/main";
    }
    @RequestMapping("/hr/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main/index";
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
    @RequestMapping("/hr/setting")
    public String setting(Model model){
        model.addAttribute("menu",MenuConfig.HrMenu());
        return "main/setting";
    }
    @RequestMapping("/hr/evaluate")
    public String evaluate(String search,String type,Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            String id=(String)session.getAttribute("loginUser");
            List<Menu> list2= MenuConfig.HrMenu();
            model.addAttribute("menu",list2);
            List<Evaluate> list=hrService.findEvaluate(id,search,type);
            model.addAttribute("evaluateList",list);

        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }

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
    public String takeOff(Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            String id=(String)session.getAttribute("loginUser");
            List<TakeOff> list=hrService.findAllTakeOff(id);
            model.addAttribute("menu",MenuConfig.HrMenu());
            model.addAttribute("takeoff",list);
        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }

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
    @RequestMapping("/hr/talents")
    public String talents(Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            List<Staff> list=hrService.getAllTalents();
            model.addAttribute("talentsInfo",list);
            model.addAttribute("menu",MenuConfig.HrMenu());
        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }

        return "user/hr/talents";
    }
    @GetMapping("/hr/talents/request")
    public String talentsRequest(@RequestParam("id") String id, @RequestParam("type") String type, HttpSession session,RedirectAttributes attributes){
        String requester=(String)session.getAttribute("loginUser");
        Timestamp timestamp=timeUtil.localTime();
        if (hrService.sendRequest(id,requester,type,timestamp,uuidUtil.getUUID())){
            attributes.addFlashAttribute("state","requestOK");
        }else {
            attributes.addFlashAttribute("state","requestError");
        }
        return "redirect:/hr/talents";
    }
    @RequestMapping("/hr/applicate")
    public String applicate(Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            String id=(String)session.getAttribute("loginUser");
            List<Request> list=hrService.getAllRequest(id);
            model.addAttribute("menu",MenuConfig.HrMenu());
            model.addAttribute("requests",list);
        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }

        return "user/hr/applicate";
    }
    @RequestMapping("/hr/applicate/delete")
    public String deleteapp(RedirectAttributes attributes,@RequestParam String uuid,HttpSession session){
        if(checkIdentify(session)){
           if(hrService.delApplicate(uuid)){
               attributes.addFlashAttribute("state","delOK");
           }else {
               attributes.addFlashAttribute("state","delError");
           }
        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "redirect:/hr/applicate";
    }
    @RequestMapping("/hr/pay")
    public String pay(Model model){
        model.addAttribute("menu",MenuConfig.HrMenu());
        return "main/pay";
    }


}
