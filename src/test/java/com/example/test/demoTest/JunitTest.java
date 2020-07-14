package com.example.test.demoTest;

import com.example.test.entity.User;
import com.example.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {

    @Resource
    private UserService userService;

    @Test
    public  void sout(){
        System.out.println("你好");
    }

    @Test
    public void selectById(){
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user);

    }
    @Test
    public void  idcard(){
        String idcard = "412825200007154974";
        System.out.println(idcard.length());
    }


}
