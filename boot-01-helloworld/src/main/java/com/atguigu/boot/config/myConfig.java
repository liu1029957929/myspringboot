package com.atguigu.boot.config;


import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理bean的方法
 *  Full(@Configuration(proxyBeanMethods = true))保证每个@Bean方法调用多少次返回的组件都是单实例的
 *  Lite(@Configuration(proxyBeanMethods = false))每个@Bean方法调用多少次返回的组件都是新建的
 *
 * 4.@Import({User.class})给容器中自动创建出User类型的组件，默认的名称是全类名
 */

@Import(User.class)
@Configuration(proxyBeanMethods = false)//告诉springboot这是一个配置类
@EnableConfigurationProperties(Car.class)
//1.开启car和配置文件的绑定功能
//2.把这个car这个组件自动注册到容器中
public class myConfig {

        @ConditionalOnMissingBean(name="tom")
        @Bean//给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值就是组件在容器中的实例
       public User user01(){
           return new User("zhangsan",10);
       }

       @Bean("tom")
        public Pet myPet(){
            return new Pet("tom");
       }
}
