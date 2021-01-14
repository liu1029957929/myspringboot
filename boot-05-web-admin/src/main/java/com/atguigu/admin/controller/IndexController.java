package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    /**
     *登录页面
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(user.getUserid().length()!=0 && "123456".equals(user.getUserpwd())){
            session.setAttribute("user",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","帐号密码错误");
            return "login";
        }
    }

    /**
     *
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session){
/*        Object user = session.getAttribute("user");
        if(user!=null){
            return "main";
        }
        return "login";*/
        return "main";
    }
}
