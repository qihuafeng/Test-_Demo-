package com.example.test.ioc.service;

import com.example.test.ioc.dao.UserDao;
import com.example.test.ioc.dao.UserDaoImpl;
import com.example.test.ioc.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{

    //多个不同的实现要新加很多的代码，或者改变原来的代码
    //private UserDao userDao = new UserDaoImpl();
    //private UserDao userDao = new UserDaoMysqlImpl();
    //private UserDao userDao = new UserDaoOrcaleImpl();


    //第二种方法
    private  UserDao userDao;
    //有set进行动态的设置对象，不用new了，把创建对象的权利交给IOC容器
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }

}
