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

    @RequestMapping("/index1111")
    @ResponseBody
    public String index() {
        //git分支测试
        return "helloIndex测试！！！";
    }

    @ResponseBody
    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public User selectUserById(@RequestParam("userId") Integer id) {
        System.out.println("id:" + id);
        User user = userService.selectByPrimaryKey(id);
        System.out.println(user.toString());
        return user;

    }

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(){
        User user = new User(2,"瑞文","123456","1556265");
        int i = userService.insert(user);
        if(i==1){
            return "插入·成功";
        }
        return null;
    }
}
