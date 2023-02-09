package com.roye.project.Controller;

import com.roye.project.Entity.Company;
import com.roye.project.Entity.TakeOff;
import com.roye.project.Service.LeaderService;
import com.roye.project.config.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LeaderController {
    @Autowired
    LeaderService leaderService;
    @RequestMapping("/leader/main")
    public String main(Model model, HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        List<Company> info= leaderService.findCompanyInfo(username);
        model.addAttribute("company",info);
        model.addAttribute("menu", MenuConfig.LeaderMenu());
        return "user/leader/main";
    }
    @RequestMapping("/leader/takeOff")
    public String takeOff(Model model){
        List<TakeOff> list=leaderService.findAllTakeOff();
        model.addAttribute("takeoff",list);

        model.addAttribute("menu",MenuConfig.LeaderMenu());

        return "user/leader/takeOff";
    }
    @RequestMapping(value="/leader/takeOff/{type}/{uuid}")
    public String updateTakeOff(@PathVariable String type, @PathVariable String uuid){
        if (type.equals("agree")){
            leaderService.updateTakeOff(1,uuid);
        }else{
            leaderService.updateTakeOff(2,uuid);
        }
        return "redirect:/leader/takeOff";
    }

}
