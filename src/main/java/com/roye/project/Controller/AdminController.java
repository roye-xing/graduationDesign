package com.roye.project.Controller;

import com.roye.project.Entity.User;
import com.roye.project.Service.AdminService;
import com.roye.project.Service.UserService;
import com.roye.project.Util.MD5Util;
import com.roye.project.Util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    MD5Util md5Util;
    UUIDUtil uuidUtil;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    public boolean checkIdentify(HttpSession session){
        if (session.getAttribute("userType").equals("admin")){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/admin/login")
    public Object adminLogin(String username, String password, HttpSession session, HttpServletRequest request){
        User user=userService.adminLogin(username,md5Util.string2MD5(md5Util.convertMD5(password)));
        if (user!=null){
            session.setAttribute("loginUser",username);
            session.setAttribute("userType","admin");
            return "redirect:/admin/main";
        }else {
            return "user/admin/index";
        }
    }
    @RequestMapping("/admin/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "user/admin/index";
    }
    @RequestMapping("/admin/main")
    public String main(Model model,RedirectAttributes attributes,HttpSession session){
        if(checkIdentify(session)){
            List<User> list=adminService.getAllUser();
            model.addAttribute("users",list);
        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "user/admin/main";
    }
    @RequestMapping("/admin/main/add")
    public String add(String name,String password,String usertype,RedirectAttributes attributes){
        if (adminService.addUser(name,md5Util.string2MD5(md5Util.convertMD5(password)), usertype)){
            attributes.addFlashAttribute("state","insertOK");
        }else {
            attributes.addFlashAttribute("state","insertError");

        }
        return "redirect:/admin/main";
    }
    @RequestMapping("/admin/main/update")
    public String update(String username,String password,String type,String nickname,String companyId,RedirectAttributes attributes){
        if (adminService.updateUser(username,md5Util.string2MD5(md5Util.convertMD5(password)),type,nickname,companyId)){
            attributes.addFlashAttribute("state","delOK");
        }else {
            attributes.addFlashAttribute("state","delError");
        }
        return "redirect:/admin/main";
    }
    @RequestMapping("/admin/main/delete")
    public String delete(@RequestParam String username, RedirectAttributes attributes){
        if (adminService.delUser(username)){
            attributes.addFlashAttribute("state","delOK");
        }else {
            attributes.addFlashAttribute("state","delError");
        }
        return "redirect:/admin/main";
    }
    @RequestMapping("/admin/company")
    public String company(Model model,HttpSession session,RedirectAttributes attributes){
        if(checkIdentify(session)){
            model.addAttribute("companies",adminService.getAllCompanies());
        }else {
            attributes.addFlashAttribute("msg","禁止越权访问");
            return "redirect:/index";
        }
        return "user/admin/company";
    }
    @RequestMapping("/admin/company/{type}")
    public String editCompany(@PathVariable String type,String id,String name,String tel,String address,RedirectAttributes attributes){
        if (type.equals("add")){
            if (adminService.addCompany(uuidUtil.eightUUID(), name,tel,address)){
                attributes.addFlashAttribute("state","insertOK");
            }else {
                attributes.addFlashAttribute("state","insertError");
            }
        }if (type.equals("update")){
            if (adminService.updateCompany(id,name,tel,address)){
                attributes.addFlashAttribute("state","editOK");
            }else{
                attributes.addFlashAttribute("state","editError");
            }
        }
        return "redirect:/admin/company";
    }
    @RequestMapping("/admin/company/delete")
    public String delCompany(@RequestParam String id,RedirectAttributes attributes){
        if (adminService.delCompany(id)){
            attributes.addFlashAttribute("state","delOK");
        }else {
            attributes.addFlashAttribute("state","delError");
        }
        return "redirect:/admin/company";
    }
}
