package com.roye.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("*/pay")
    public String pay(){
        return "redirect:./pay";
    }
}
