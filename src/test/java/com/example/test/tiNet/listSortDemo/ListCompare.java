package com.example.test.tiNet.listSortDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ShineQi
 * @Date 2020/11/13 23:33
 */
public class ListCompare {
    public static void main(String[] args) {
        Student s1 = new Student("小明","男","30");
        Student s2 = new Student("小红","女","20");
        Student s3 = new Student("小蓝","女","40");
        Student s4 = new Student("小华","男","18");
        Student s5 = new Student("小文","男","63");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        Comparator<Student> netTypeComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.valueOf(o1.getAge()) - Integer.valueOf(o2.getAge());
            }
        };

        Collections.sort(list,netTypeComparator); //对path进行排序
        System.out.println(list);

    }
}
