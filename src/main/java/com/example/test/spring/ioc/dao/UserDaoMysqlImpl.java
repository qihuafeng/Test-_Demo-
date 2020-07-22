package com.example.test.spring.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMysqlImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("MySql实现获取用户的数据！");
    }
}
