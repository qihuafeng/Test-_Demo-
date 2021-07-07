package com.example.test.tinet.listSortDemo;

import java.util.*;

/**
 * @Author ShineQi
 * @Date 2020/11/14 19:16
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Student s1 = new Student("张浩","男","18");
        Student s2 = new Student("liuwen","male","20");
        Student s3 = new Student("毛越","男","14");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                //return Integer.valueOf(o2.getAge())-Integer.valueOf(o1.getAge());
                return Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));

            }
        });
        System.out.println(list);

    }
}
