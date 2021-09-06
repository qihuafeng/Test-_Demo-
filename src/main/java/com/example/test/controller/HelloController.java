package com.example.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/devops-development")
    public String sayHello(){
        String s = "name";
        return "devops-development";
    }

    @RequestMapping("/devops-monitor")
    public String sayHello1(){
        return "devops-monitor";
    }


    @RequestMapping("/devops-vnc")
    public String sayHello2(){
        return "devops-vnc";
    }
}