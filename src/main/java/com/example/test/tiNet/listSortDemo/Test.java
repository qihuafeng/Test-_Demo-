package com.example.test.tiNet.listSortDemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @Author ShineQi
 * @Date 2020/11/14 13:59
 */
public class Test {
    public static void main(String[] args) {
        String[] data = {"1.1", "1.3.5", "1.2", "1.222", "5.1", "3.1", "3.5", "3.3", "1.2.8.1", "3.1.5","1.2.1"};
        Arrays.sort(data, (String a, String b) -> {
            String[] spa = a.split("\\.");
            String[] spb = b.split("\\.");
            int len = Math.min(spa.length, spb.length);
            for(int i = 0; i < len; i++) {
                if(!spa[i].equals(spb[i])) {
                    int flag = Integer.compare(Integer.parseInt(spa[i]), Integer.parseInt(spb[i]));
                    return Integer.compare(Integer.parseInt(spa[i]), Integer.parseInt(spb[i]));
                }
            }
            return Integer.compare(spa.length, spb.length);
        });
//        for(String a: data) {
//            System.out.print(a+ " ");
//        }
//        int x = Integer.compare(5,20);
//        int y = Integer.compare(20,5);
//        int z = Integer.compare(5,5);
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);
    }

    //        Collections.sort(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                String[] so1 = o1.getAge().split("\\.");
//                String[] so2 = o2.getAge().split("\\.");
//                int len = Math.min(so1.length, so2.length);
//                for (int i = 0; i < len; i++) {
//                    if (!so1[i].equals(so2[i])) {
//                        return Integer.compare(Integer.parseInt(so1[i]), Integer.parseInt(so2[i]));
//                    }
//                }
//                return Integer.compare(so1.length,so2.length);
//            }
//        });



}
