package com.example.test.demoTest.spring;

import com.example.test.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @date 2020/7/18
 * @author qihuafeng
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Test
    public void beanTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student s = (Student) applicationContext.getBean("student");
        System.out.println(s.toString());

    }
}
