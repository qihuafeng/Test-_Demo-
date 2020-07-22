package com.example.test.spring.scope;

import com.example.test.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Singleton {
    public static void main(String[] args) {

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            Student s1= (Student) applicationContext.getBean("student");
            Student s2= (Student) applicationContext.getBean("student");
            //如果是单例模式就输出为true,设计模式为singleton单例模式
            //如果scope=“prototype” 就为false
            System.out.println(s1.equals(s2));

            //不同的对象输出为false
            Student student = new Student();
            Student student1 = new Student();
            System.out.println(student.equals(student1));

    }
}
