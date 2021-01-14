package com.atguigu.admin.service;

import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.bean.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getCityById(Integer id){
        return cityMapper.getById(id);
    }
}
