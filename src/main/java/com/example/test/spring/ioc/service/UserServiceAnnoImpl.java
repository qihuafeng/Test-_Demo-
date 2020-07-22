package com.example.test.spring.ioc.service;

import com.example.test.spring.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class UserServiceAnnoImpl implements UserService{

    @Resource
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Override
    public void getUser() {
        userDao.getUser();
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceAnnoImpl();
        userService.getUser();
    }
}
