package com.roye.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @RequestMapping ({"/","/index"})
    public String index(){
        return "main/index";
    }
    @RequestMapping ("/admin")
    public String admin(){
        return "user/admin/index";
    }

}
