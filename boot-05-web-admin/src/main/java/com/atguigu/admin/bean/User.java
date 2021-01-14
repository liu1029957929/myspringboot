package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @TableField(exist = false)
    private String userid;
    @TableField(exist = false)
    private String userpwd;

    //以下是数据库的字段
    private Long id;
    private String name;
    private int age;
    private String email;
}
