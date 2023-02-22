package com.roye.project.Controller;

import com.roye.project.Entity.Menu;
import com.roye.project.Entity.Staff;
import com.roye.project.Entity.User;
import com.roye.project.Service.StaffService;
import com.roye.project.Service.UserService;
import com.roye.project.Util.CodeUtil;
import com.roye.project.Util.MD5Util;
import com.roye.project.config.MenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    MD5Util md5Util;
    @Autowired
    UserService userService;
    @Autowired
    StaffService staffService;

    @RequestMapping("/user/login")
    public Object select(String username,
                         String password,
                         String power,
                         HttpServletRequest request,
                         Model model,
                         HttpSession session){
        User user=userService.login(username,md5Util.string2MD5(md5Util.convertMD5(password)),power);
        if (user!=null){
            if (CodeUtil.checkVerifyCode(request)){
                if (power.equals("staff")) {
                    session.setAttribute("loginUser", username);
                    session.setAttribute("userType",power);
                    return "redirect:/staff/main";
                }else if (power.equals("hr")){
                    session.setAttribute("loginUser",username);
                    session.setAttribute("userType",power);
                    return "redirect:/hr/main";
                }else{
                    session.setAttribute("loginUser",username);
                    session.setAttribute("userType",power);
                    return "redirect:/leader/main";
                }
            }else {
                model.addAttribute("selected",power);
                model.addAttribute("msg","验证码错误");
                return "main/index";
            }

        }else {
            model.addAttribute("selected",power);
            model.addAttribute("msg","请检查身份、用户名或密码是否有误");
            return "main/index";
        }

    }
    @RequestMapping("/user/register")
    public String add(User user,String username,String password,HttpServletRequest request,Model model){
        if (username!="" && password!=""){
            if (CodeUtil.checkVerifyCode(request)){
                userService.add(username, md5Util.string2MD5(md5Util.convertMD5(password)));
                model.addAttribute("remsg","注册成功，您可以登陆了");
                return "main/index";
            }else {
                model.addAttribute("remsg","验证码错误");
                return "main/index";
            }
        }else {
            model.addAttribute("remsg","用户名或密码不能为空");
            return "main/index";
        }
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main/index";
    }
    @RequestMapping("*/setting/update")
    public String update(HttpSession session,String nickname,String password,String newPwd,RedirectAttributes attributes){
        String id=(String)session.getAttribute("loginUser");
        if (userService.update(id,nickname,md5Util.string2MD5(md5Util.convertMD5(password)),newPwd)){
            attributes.addFlashAttribute("state","editOK");
        }else {
            attributes.addFlashAttribute("state","editError");
        }
        return "redirect:../setting";
    }
}
