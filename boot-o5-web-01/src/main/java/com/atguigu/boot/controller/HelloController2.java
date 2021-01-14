package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController2 {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") String id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,Object> iu,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,Object> header
                                     ){
        Map<String,Object> map = new HashMap<>();
/*        map.put("id",id);
        map.put("username",username);
        map.put("iu",iu);*/
        map.put("userAgent",userAgent);
        map.put("header",header);
        return map;
    }

    @PostMapping("/save")
    public Map<String,Object> postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //   /car/sell;low=34;brand=byd,audi,yd
    @GetMapping("/car/{path}")
    public Map<String,Object> carsSell(@MatrixVariable("low") Integer low,
                                       @MatrixVariable("brand") List<String> brand,
                                       @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;

    }

    //  /boss/1;age=10/2;age=20
    @GetMapping("/boss/{bossAge}/{empAge}")
    public Map<String,Object> boss(@MatrixVariable(value = "age",pathVar = "bossAge") Integer bossAge,
                                   @MatrixVariable(value = "age",pathVar = "empAge") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;

    }

    /**
     * 数据绑定：页面提交的请求数据都可以和对象属性进行绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }
}
