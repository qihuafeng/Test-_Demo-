package com.example.test.ioc.dao;

public class UserDaoMysqlImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("MySql实现获取用户的数据！");
    }
}
