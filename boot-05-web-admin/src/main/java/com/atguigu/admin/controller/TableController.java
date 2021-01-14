package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.Student;
import com.atguigu.admin.service.CityService;
import com.atguigu.admin.service.StudetnService;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @Autowired
    StudetnService studetnService;

    @Autowired
    CityService cityService;
    @ResponseBody
    @GetMapping("/city")
    public City getCity(@RequestParam("id") Integer id){
        return cityService.getCityById(id);
    }


    @ResponseBody
    @GetMapping("/test")
    public Student MybatisTest(@RequestParam("id") String id){
        return studetnService.test01(id);
    }

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/delete/{pn}/user")
    public String deleteUser(@RequestParam("id")Integer id,
                             @PathVariable("pn")Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn ,Model model){
/*        List<User> userList = Arrays.asList(
                new User("zhangsan","123456"),
                new User("lisi","1234567"),
                new User("wangwu","12345678"),
                new User("zhaoliu","123456789")

        );
        model.addAttribute("userList",userList);*/
        Page p = new Page(pn,2);
        Page page = userService.page(p, null);
        model.addAttribute("page",page);
        String countId = page.getCountId();
        long current = page.getCurrent();
        List records = page.getRecords();
        page.getTotal();
        long pages = page.getPages();
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

}
