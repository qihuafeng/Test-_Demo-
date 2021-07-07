package com.example.test.tinet.jspController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ShineQi
 * @Date 2020/12/10 18:05
 */

@Controller
@RequestMapping("/1")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        String s = "S12";
        String s1 = "S12";
        String s2 = "S12";
        return "index";
    }
}
