package com.atguigu.admin;

import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from tbl_student", Integer.class);
        log.info("数量{}",integer);
        log.info("数据源类型{}",dataSource.getClass());
    }

    @Test
    void testSelect(){
        User user = userMapper.selectById(1L);
        log.info("用户{}",user);
    }

}
