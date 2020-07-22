package com.example.test.spring.ioc;

import com.example.test.spring.ioc.dao.UserDaoImpl;
import com.example.test.spring.ioc.service.UserService;
import com.example.test.spring.ioc.service.UserServiceImpl;

public class UserTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //之前，程序是主动创建对象！控制权在程序员手上
        //使用set注入后，程序不再具有主动性，而是变成了被动的接受对象
        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());

        userService.getUser();

        //这种思想，从根本上解决了问题，我们程序员不用再去管理对象的创建了，
        // 系统的耦合性大大降低，可以更加专注的在业务实现上

        //自己理解，不用再去改变service层代码了，可以更加方便的横向扩展
    }
}
