package com.example.test.controller;

import com.example.test.entity.User;
import com.example.test.service.UserService;
import com.example.test.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "helloIndex";
    }

    @ResponseBody
    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public User selectUserById(@RequestParam("userId") Integer id) {
        System.out.println("id:" + id);
        User user = userService.selectByPrimaryKey(id);
        System.out.println(user.toString());
        return user;

    }
}
