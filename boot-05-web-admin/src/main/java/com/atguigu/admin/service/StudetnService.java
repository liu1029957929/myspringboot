package com.atguigu.admin.service;

import com.atguigu.admin.mapper.StudentMapper;
import com.atguigu.admin.bean.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudetnService {
    @Resource
    StudentMapper studentMapper;

    public Student test01(String id){
        return studentMapper.getStudent(id);
    }
}
