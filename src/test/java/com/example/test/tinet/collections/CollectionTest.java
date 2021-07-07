package com.example.test.tinet.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ShineQi
 * @Date 2020/11/17 17:26
 */
public class CollectionTest {
    public static void main(String[] args) {

        List<String> cnos = new ArrayList<>();
        cnos.add("1");
        cnos.add("2");
        cnos.add("3");
        cnos.add("4");
        cnos.add("5");

        List<Integer> taskIds = new ArrayList<>();
        taskIds.add(5);
        taskIds.add(7);
        taskIds.add(8);
        taskIds.add(9);
        taskIds.add(10);

        List<Integer> taskIds2 = new ArrayList<>();
        taskIds2.add(5);
        taskIds2.add(6);

        boolean flag =  Collections.disjoint(taskIds2,taskIds);
        System.out.println(flag);
        String s = "task_ids";
        System.out.println(s.substring(0,s.length()-1));


    }
}
