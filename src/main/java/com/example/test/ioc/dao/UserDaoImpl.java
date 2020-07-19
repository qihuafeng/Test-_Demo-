package com.example.test.ioc.dao;

public class UserDaoImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("Dao层默认获取用户的数据");
    }
}
