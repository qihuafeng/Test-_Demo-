package com.example.test.demoTest.spring;

import com.example.test.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jnlp.IntegrationService;
import java.util.*;

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
    @Test
    public void setTest(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        for(String i :set){
            System.out.println(i);
        }
        System.out.println(set.toString().split(","));
        System.out.println(set);
        System.out.println(set.add("1"));
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        System.out.println(treeSet);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
//        linkedList.get();

    }
}
