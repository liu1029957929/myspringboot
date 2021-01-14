package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FromTestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    public String sql(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from tbl_student", Integer.class);
        return integer.toString();
    }

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userid") String userid,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos
                         ) throws IOException {

        log.info("email:{},userid:{},headerImg:{},photos:{}",email,userid,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\photo"+"\\"+originalFilename));
        }
        if(photos.length!=0){
            for(MultipartFile photo :photos){
                String originalFilename = photo.getOriginalFilename();
                photo.transferTo(new File("F:\\photo"+"\\"+originalFilename));
            }
        }

        return "main";
    }


}
