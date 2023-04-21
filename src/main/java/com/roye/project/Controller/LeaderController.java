package com.roye.project.Controller;

import com.roye.project.Entity.Company;
import com.roye.project.Entity.Request;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.TakeOff;
import com.roye.project.Service.HrService;
import com.roye.project.Service.LeaderService;
import com.roye.project.config.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LeaderController {
    @Autowired
    LeaderService leaderService;
    @Autowired
    HrService hrService;
    public boolean checkIdentify(HttpSession session){
        if (session.getAttribute("userType").equals("leader")){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/leader/main")
    public String main(Model model, HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            String username=(String)session.getAttribute("loginUser");
            List<Company> info= leaderService.findCompanyInfo(username);
            model.addAttribute("company",info);
            model.addAttribute("menu", MenuConfig.LeaderMenu());

        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "user/leader/main";
    }
    @RequestMapping("/leader/update")
    public String update(String id,String name,String tel,String address,RedirectAttributes attributes){
        if (leaderService.updateCompanyInfo(id,name, tel, address)){
            attributes.addFlashAttribute("state","editOK");
        }else {
            attributes.addFlashAttribute("state","editError");

        }
        return "redirect:/leader/main";
    }
    @RequestMapping("/leader/setting")
    public String setting(Model model){
        model.addAttribute("menu",MenuConfig.LeaderMenu());
        return "main/setting";
    }
    @RequestMapping("/leader/takeOff")
    public String takeOff(Model model,RedirectAttributes attributes,HttpSession session){
        if(checkIdentify(session)){
            String id=(String)session.getAttribute("loginUser");
            List<TakeOff> list=leaderService.findAllTakeOff(id);
            model.addAttribute("takeoff",list);

            model.addAttribute("menu",MenuConfig.LeaderMenu());

        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }


        return "user/leader/takeOff";
    }
    @RequestMapping("/leader/takeOff/check")
    public String leaderCheck(int check,String uuid,String msg){
        leaderService.updateTakeOff(check,uuid,msg);
        return "redirect:/leader/takeOff";
    }
    @RequestMapping("/leader/members")
    public String members(Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            List<Staff> list=leaderService.findAllMembers((String)session.getAttribute("loginUser"));
            model.addAttribute("menu",MenuConfig.LeaderMenu());
            model.addAttribute("members",list);
            model.addAttribute("departmentList",hrService.findAllDepartment());

        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "user/leader/members";
    }
    @RequestMapping("/leader/members/quit")
    public String quit(String msg,String id,int score){
        leaderService.quitMember(id,msg,score);
        return "redirect:/leader/members";
    }
    @RequestMapping("/leader/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main/index";
    }

    @RequestMapping("/leader/applicate")
    public String applicate(Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            String id=(String)session.getAttribute("loginUser");
            List<Request> list=leaderService.getAllRequest(id);
            model.addAttribute("requests",list);
            model.addAttribute("menu",MenuConfig.LeaderMenu());

        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "user/leader/applicate";
    }
    @RequestMapping("/leader/applicate/{type}")
    public String editApplicate(@RequestParam String uuid,@PathVariable String type,@RequestParam String userid,HttpSession session, RedirectAttributes attributes){
        String id=(String)session.getAttribute("loginUser");
        if (type.equals("agree")){
            leaderService.updateRequest(uuid,userid,id,1);
            attributes.addFlashAttribute("state","editOK");
        }else {
            leaderService.updateRequest(uuid,userid,id,0);
        }
        return "redirect:/leader/applicate";
    }
    @RequestMapping("/leader/pay")
    public String pay(Model model){
        model.addAttribute("menu",MenuConfig.LeaderMenu());
        return "main/pay";
    }

}
