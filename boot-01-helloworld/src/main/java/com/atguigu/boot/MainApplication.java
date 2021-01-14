package com.atguigu.boot;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.myConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/*
@SpringBootApplication：表明这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        /*Pet tom = run.getBean("tom",Pet.class);
        Pet tom1 = run.getBean("tom",Pet.class);

        //当proxyBeanMethods为true时，为true
        //当proxyBeanMethods为false时，也为true
        System.out.println(tom==tom1);

        myConfig bean = run.getBean(myConfig.class);
        User user = bean.user01();
        User user1 = bean.user01();
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，Springboot总会检查这个组件是否在容器中
        //保持组件单实例
        System.out.println(user==user1);

        System.out.println("===========");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }*/
/*        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中tom组件："+tom);*/
        Car car = run.getBean(Car.class);
        System.out.println(car);
    }
}
