package com.example.test.tiNet.listSortDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author ShineQi
 * @Date 2020/11/14 17:05
 */
public class Lambda {
    public static void main(String[] args) {
        String s = "你好";
        final Runnable runnable = () -> System.out.println(s);
        String[] data = {"1.1", "1.3.5", "1.2", "1.222", "5.1", "3.1", "3.5", "3.3", "1.2.8.1", "3.1.5","1.2.1"};
        /*Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] spa = o1.split("\\.")
                return 0;
            }
        });*/



    }
}
