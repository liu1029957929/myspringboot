package com.atguigu.boot.bean;

import lombok.*;

@AllArgsConstructor  //全参构造器
@NoArgsConstructor  //无参构造器
@ToString
@Data
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;

}
