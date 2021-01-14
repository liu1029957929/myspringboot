package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController3 {
    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","haha");
        return "forward:/success";
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map success(@RequestAttribute("msg") String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",msg);
        return map;
    }
}
