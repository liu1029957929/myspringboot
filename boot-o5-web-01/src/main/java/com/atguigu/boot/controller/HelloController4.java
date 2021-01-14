package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController4 {
    @GetMapping("/test/haha")
    public String haha(Model model){
        model.addAttribute("url","http://www.baidu.com");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
