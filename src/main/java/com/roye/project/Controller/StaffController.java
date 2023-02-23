package com.roye.project.Controller;

import com.roye.project.Entity.*;
import com.roye.project.Service.StaffService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StaffController {
    TimeUtil timeUtil;
    UUIDUtil uuidUtil;
    @Autowired
    StaffService staffService;
    @RequestMapping ("/staff/main")//PASS
    public String main(Model model, HttpSession session){
        String username=(String) session.getAttribute("loginUser");
        List<Menu> list=new ArrayList<Menu>();
        List<Staff> list1=staffService.findById(username);
        list=MenuConfig.StaffMenu();
        model.addAttribute("menu",list);
        model.addAttribute("staffInfo",list1);


        return "user/staff/main";
    }
    @RequestMapping("/staff/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main/index";
    }
    @RequestMapping("/staff/setting")
    public String setting(Model model){
        model.addAttribute("menu",MenuConfig.StaffMenu());
        return "main/setting";
    }
    @RequestMapping("/staff/applicate")
    public String applicate(Model model,HttpSession session){
        String id=(String)session.getAttribute("loginUser");
        List<Request> requests=staffService.getAllRequest(id);
        model.addAttribute("menu",MenuConfig.StaffMenu());
        model.addAttribute("requests",requests);
        return "user/staff/applicate";
    }
    @RequestMapping("/staff/applicate/{type}")
    public String editApplicate(RedirectAttributes attributes, @PathVariable String type, @RequestParam String uuid){
        if (type.equals("agree")){
            staffService.editRequest(uuid,1);
        }if (type.equals("disagree")) {
            staffService.editRequest(uuid,0);
        }if (type.equals("delete")){
            if (staffService.delRequest(uuid)){
                attributes.addFlashAttribute("state","delOK");
            }else {
                attributes.addFlashAttribute("state","delError");
            }
        }
        return "redirect:/staff/applicate";
    }
    @RequestMapping("/staff/evaluate")
    public String evaluate(Model model,HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        List<Menu> list=MenuConfig.StaffMenu();
        model.addAttribute("menu",list);

        List<Evaluate> list1=staffService.findEvaluate(username);
        model.addAttribute("evaluates",list1);

        return "user/staff/evaluate";
    }
    @RequestMapping("/staff/evaluate/update")
    public String updateEvaluate(HttpSession session,String oldWork,String selfText,int selfScore,RedirectAttributes attributes){
        String username=(String)session.getAttribute("loginUser");
        if (staffService.updateEvaluate(username,oldWork,selfText,selfScore)){
            attributes.addFlashAttribute("state","editOK");
        }else {
            attributes.addFlashAttribute("state","editError");
        }

        return "redirect:/staff/evaluate";
    }
    @GetMapping("/staff/takeOff")//clear
    public String takeOff(Model model,HttpSession session) throws Exception{
        String username=(String) session.getAttribute("loginUser");
        List<Menu> list=MenuConfig.StaffMenu();
        try{
            List<TakeOff> list1=staffService.checkTakeOff(username);
            model.addAttribute("takeoffinfo",list1);
        }catch (Exception e){

        }
        model.addAttribute("menu",list);
        return "user/staff/takeOff";
    }
    @RequestMapping("/staff/takeOff/add")//clear
    public String addTakeOff(RedirectAttributes attributes,
                             HttpSession session,
                             String type,
                             String reason,
                             String regtime,
                             String backtime){
        String id=(String) session.getAttribute("loginUser");
        Timestamp sql_regtime= timeUtil.timechange(regtime);
        Timestamp sql_backtime= timeUtil.timechange(backtime);
        String uuid=uuidUtil.getUUID();
        staffService.addTakeOff(id,type,sql_regtime,sql_backtime,reason,uuid);
        return "redirect:/staff/takeOff";
    }
    @RequestMapping(value="/staff/takeOff/delete")//clear
    public String delTakeOff(@PathVariable String uuid,RedirectAttributes attributes){
        if (staffService.delTakeOff(uuid)){
            attributes.addFlashAttribute("state","delOK");
        }else {
            attributes.addFlashAttribute("state","delError");
        }
        return "redirect:/staff/takeOff";
    }
    @RequestMapping("/staff/update")//clear
    public String upDate(String id,
                         String name,
                         String gender,
                         boolean secrecy,
                         String birth,String tel,String email, RedirectAttributes attributes){
        Date sqlDate=Date.valueOf(birth);
        System.out.println(secrecy);
        if (name!=""){
            if (staffService.update(id, name, gender, sqlDate,email,tel,secrecy)){
                //跳转页面携带参数要使用addFlashAttribute
            attributes.addFlashAttribute("state","editOK");
            }
        }
        else {
            attributes.addFlashAttribute("state","editError");
        }

        return "redirect:/staff/main";
    }
    @RequestMapping("/staff/pay")
    public String pay(Model model){
        model.addAttribute("menu",MenuConfig.StaffMenu());
        return "main/pay";
    }
}
