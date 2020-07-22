package com.example.test.spring.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("Dao层默认获取用户的数据");
    }
}
