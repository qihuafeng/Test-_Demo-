package com.example.test.tiNet.listSortDemo;

import org.thymeleaf.spring5.context.SpringContextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ShineQi
 * @Date 2020/11/14 18:13
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三","男","1.1");
        Student s2 = new Student("张三","男","1.3.5");
        Student s3 = new Student("张三","男","1.2");
        Student s4 = new Student("张三","男","1.222");
        Student s5 = new Student("张三","男","5.1");
        Student s6 = new Student("张三","男","2");
        Student s7 = new Student("张三","男","3.5");
        Student s8 = new Student("张三","男","1.2.8.1");
        Student s9 = new Student("张三","男","3.1.5");
        Student s10 = new Student("张三","男","2.1");
        Student s11 = new Student("李四","男","1");
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);
        studentList.add(s8);
        studentList.add(s9);
        studentList.add(s10);
        studentList.add(s11);
        System.out.println(studentList);
        Collections.sort(studentList, (o1, o2) -> {
            String[] so1 = o1.getAge().split("\\.");
            String[] so2 = o2.getAge().split("\\.");
            int len = Math.min(so1.length, so2.length);
            for (int i = 0; i < len; i++) {
                if (!so1[i].equals(so2[i])) {
                    return Integer.compare(Integer.parseInt(so1[i]), Integer.parseInt(so2[i]));
                }
            }
            return Integer.compare(so1.length, so2.length);

        });
        //Collections排序升序
       /* Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });*/

       Collections.sort(studentList, new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               String[] so1 = o1.getAge().split("\\.");
               String[] so2 = o2.getAge().split("\\.");
               int len = Math.min(so1.length, so2.length);
               for (int i = 0; i < len; i++) {
                   if (!so1[i].equals(so2[i])) {
                       return Integer.compare(Integer.parseInt(so1[i]), Integer.parseInt(so2[i]));
                   }
               }
               return Integer.compare(so1.length, so2.length);
           }
       });

        System.out.println("===================排序后===================");

        System.out.println(studentList);

        studentList.stream().filter(para ->!para.getName().equals("李四"));
        System.out.println();




        /*Collections.sort(ivrVOS, new Comparator<CtiLinkEnterpriseIvrVO>() {
            @Override
            public int compare(CtiLinkEnterpriseIvrVO o1, CtiLinkEnterpriseIvrVO o2) {
                String[] so1 = o1.getPath().split("\\.");
                String[] so2 = o2.getPath().split("\\.");
                int len = Math.min(so1.length, so2.length);
                for (int i = 0; i < len; i++) {
                    if (!so1[i].equals(so2[i])) {
                        return Integer.compare(Integer.parseInt(so1[i]), Integer.parseInt(so2[i]));
                    }
                }
                return Integer.compare(so1.length,so2.length);
            }
        });*/

    }
}
