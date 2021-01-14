package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
     Student getStudent(String id);
}
