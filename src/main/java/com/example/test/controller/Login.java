package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login1")
public class Login {

    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Cuiyw");
        return "login";
    }
}