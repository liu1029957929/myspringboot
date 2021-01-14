package com.atguigu.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor  //全参构造器
@NoArgsConstructor  //无参构造器
@ToString
@Data
@EqualsAndHashCode
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

}
